package spms.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Set;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.reflections.Reflections;

import spms.annotations.Component;

// 웹애플리케이션이 시작될 때 서블릿이 사용할 객체들을 준비
public class AppInitServlet extends GenericServlet {
	private static final long serialVersionUID = 1L; 

	HashMap<String,Object> objMap = new HashMap<String,Object>();

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		try {
			String resource = config.getInitParameter("mybatisConfig");
      InputStream inputStream = Resources.getResourceAsStream(resource);
      SqlSessionFactory sqlSessionFactory = 
      		new SqlSessionFactoryBuilder().build(inputStream);

      objMap.put("sqlSessionFactory", sqlSessionFactory);
			
			prepareComponent();

			injectDependency();

			copyFromObjMapToServletContext();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void copyFromObjMapToServletContext() {
		for (String key : objMap.keySet()) {
			this.getServletContext().setAttribute(key, objMap.get(key));
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

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {

	}

}





