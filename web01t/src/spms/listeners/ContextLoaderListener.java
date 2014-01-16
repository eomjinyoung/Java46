package spms.listeners;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.reflections.Reflections;

import spms.annotations.Component;

/* ServletContextListener 인터페이스 
 * - 서블릿 컨테이너와 리스너 사이의 호출 규칙
 * - 웹 애플리케이션을 시작하거나 종료할 때 호출함.
 * - 구현체:
 *    웹 애플리케이션을 시작할 때 자원 준비를 수행.
 *    웹 애플리케이션을 종료할 때 자원 해제를 수행 
 * - 리스너의 의미?
 *    이벤트 처리 담당자.
 *    
 */
public class ContextLoaderListener implements ServletContextListener {
	Logger logger = Logger.getLogger("spms.listener");
	HashMap<String,Object> objMap = new HashMap<String,Object>();
	ServletContext ctx;
	
	// 웹 애플리케이션을 시작할 때 호출됨.
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ctx = sce.getServletContext();
		
		try {
			String resource = ctx.getInitParameter("mybatisConfig");
      logger.debug("mybatisConfig 값은 " + resource);
      
			InputStream inputStream = Resources.getResourceAsStream(resource);
      SqlSessionFactory sqlSessionFactory = 
      		new SqlSessionFactoryBuilder().build(inputStream);

      objMap.put("sqlSessionFactory", sqlSessionFactory);
      logger.info("SqlSessionFactory 등록");
      
			prepareComponent();
			logger.info("@Component가 선언된 객체를 모두 준비했음.");
			
			injectDependency();
			logger.info("의존객체 주입 완료했음.");
			
			copyFromObjMapToServletContext();
			logger.info("객체풀에 저장된 모든 인스턴스를 ServletContext에 복사하였음.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 웹 애플리케이션을 종료할 때 호출됨.
	@Override
	public void contextDestroyed(ServletContextEvent sce) {}
	
	
	private void copyFromObjMapToServletContext() {
		for (String key : objMap.keySet()) {
			ctx.setAttribute(key, objMap.get(key));
			logger.trace(key + ":" + objMap.get(key) + " 복사완료");
		}
	}
	
	private void injectDependency() throws Exception {
		Object instance = null;
		Class<?> clazz = null;
		Method[] methods = null;
		Object dependency = null;
		for (String key : objMap.keySet()) {
			instance = objMap.get(key);
			clazz = instance.getClass();
			methods = clazz.getMethods();
			for (Method m : methods) {
				if (m.getName().startsWith("set")) {
					dependency = findObjectInObjMap(m.getParameterTypes()[0]);
					if (dependency != null) {
						m.invoke(instance, dependency);
						logger.debug(clazz.getName() + "." + m.getName() + "() 호출됨.");
					}
				}
			}
		}
	}
	
	private Object findObjectInObjMap(Class<?> type) throws Exception {
		for (Object dependency : objMap.values()) {
			if (type.isInstance(dependency)) {
				return dependency;
			}
		}
		return null;
	}

	private void prepareComponent() throws Exception {
		Reflections reflections = new Reflections("spms");
		Set<Class<?>> types = reflections.getTypesAnnotatedWith(
				Component.class);
		
		Component comp = null;
		for (Class<?> c : types) {
			comp = (Component)c.getAnnotation(Component.class);
			objMap.put(comp.value().equals("")?c.getName():comp.value(), 
				c.newInstance());
		}
	}

}
