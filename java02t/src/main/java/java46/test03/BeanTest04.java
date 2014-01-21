package java46.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class BeanTest04 {
	/* [셋터 메서드 대신 인스턴스 변수에 애노테이션 선언]
	 * 
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = 
				new FileSystemXmlApplicationContext("application-context04.xml");
		
		Member m1 = (Member)ctx.getBean("ohoraMember");
		System.out.println(m1.getName());
		System.out.println(m1.getAge());
		
		Project p1 = (Project)ctx.getBean("ohoraProject");
		Member mgr = p1.manager;
		
		System.out.println(mgr.getName());
		System.out.println(mgr.getAge());
	}
	
}





