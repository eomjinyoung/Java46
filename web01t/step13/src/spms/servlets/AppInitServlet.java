package spms.servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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
			//SqlSessionFactory를 만들 때 사용할 설계도
			String resource = "spms/dao/mybatis-config.xml";
			
			//설계도 파일을 읽어들일 InputStream 준비
			/*
			String path = this.getServletContext().getRealPath("/WEB-INF/classes");
			path += "/" + resource;
			FileInputStream inputStream = new FileInputStream(path);
			*/
			
      InputStream inputStream = Resources.getResourceAsStream(resource);
      SqlSessionFactory sqlSessionFactory = 
      		new SqlSessionFactoryBuilder().build(inputStream);

      objMap.put("sqlSessionFactory", sqlSessionFactory);
			
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





