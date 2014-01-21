package spms.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
	Logger log = Logger.getLogger(ContextLoaderListener.class);
	
	// 웹 애플리케이션을 시작할 때 호출됨.
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext ctx = sce.getServletContext();
		
		try {
      String contextConfig = ctx.getInitParameter("contextConfig");
      ApplicationContext applicationContext = 
  				new ClassPathXmlApplicationContext(contextConfig);
      
      log.debug("빈의 수:" + applicationContext.getBeanDefinitionCount());
      for (String name : applicationContext.getBeanDefinitionNames()) {
      		log.debug("=>" + applicationContext.getBean(name));
      }
      
      ctx.setAttribute("applicationContext", applicationContext);
      
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 웹 애플리케이션을 종료할 때 호출됨.
	@Override
	public void contextDestroyed(ServletContextEvent sce) {}
}
