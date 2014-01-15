package spms.servlets;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.sql.DataSource;

import spms.annotations.Component;

// 웹애플리케이션이 시작될 때 서블릿이 사용할 객체들을 준비
public class AppInitServlet extends GenericServlet {
	private static final long serialVersionUID = 1L; 

	HashMap<String,Object> objMap = new HashMap<String,Object>();
	ArrayList<String> classNameList = new ArrayList<String>();

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup(
					"java:/comp/env/jdbc/spmsdb");

			objMap.put("dataSource", ds);

			/*[목표]
			 * 클래스 목록을 가져와서 @Component가 선언된 클래스를 찾는다.
			 * 그리고, 그 클래스의 인스턴스를 만들어서 objMap에 저장한다.
			 * 
			 *[절차]
			 * 1) 	WEB-INF/classes에 등록된 모든 클래스 목록을 가져온다.
			 * 2) 클래스를 로딩한 후 @Component 애노테이션이 붙었는지 조사한다.
			 * 3) 만약 @Component 애노테이션이 붙었다면, 인스턴스를 생성한 후 맵에 저장한다.
			 */
			findClassName("", new File(this.getServletContext().getRealPath(
					"/WEB-INF/classes")));

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
					dependency = findObject(m.getParameterTypes()[0]);
					if (dependency != null) {
						m.invoke(instance, dependency);
						break;
					}
				}
			}
		}
	}
	
	private Object findObject(Class<?> type) throws Exception {
		for (Object dependency : objMap.values()) {
			if (type.isInstance(dependency)) {
				return dependency;
			}
		}
		return null;
	}

	private void prepareComponent() throws Exception {
		Class<?> c = null;
		Component comp = null;
		for (String className : classNameList) {
			try {
				c = Class.forName(className);
				comp = (Component)c.getAnnotation(Component.class);
				if (comp != null) {
					objMap.put(comp.value().equals("")?c.getName():comp.value(), 
							c.newInstance());
				}
			} catch (Exception e) {
				continue;
			}
		}
	}

	private void findClassName(String base, File f) {
		File[] files = f.listFiles();
		for(File file : files) {
			if (file.isFile()) {
				if (file.getName().endsWith(".class")) {
					classNameList.add(base + file.getName().replace(".class", ""));
				}
			} else {
				findClassName(base + file.getName() + ".", file);
			}
		}
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {

	}

}





