package java46.test01;

import java46.vo.Member;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class BeanTest02 {
	/* [객체 Scope 설정]
	 * - 기본은 객체가 한 개만 생성된다.
	 * - 만약 scope이 prototype이면 getBean() 마다 객체를 새로 만든다.
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = 
				new FileSystemXmlApplicationContext("application-context02.xml");
	
		Member m4_1 = (Member)ctx.getBean("m4");
		Member m4_2 = (Member)ctx.getBean("m4");
		
		if (m4_1 == m4_2) {
			System.out.println("m4_1 == m4_2");
		} else {
			System.out.println("m4_1 != m4_2");
		}
	}
	
	/* [Factory Method 패턴을 사용하여 객체 생성 - AbstractFactoryBean 상속]
	 */
	public static void main03(String[] args) {
		ApplicationContext ctx = 
				new FileSystemXmlApplicationContext("application-context02.xml");
	
		Member m3 = (Member)ctx.getBean("m3");
		System.out.println(m3.getName());
		System.out.println(m3.getAge());
	}
	
	/* [Factory Method 패턴을 사용하여 객체 생성 - 인스턴스 메서드 호출]
	 * - 인스턴스로 선언된 팩토리 메서드 사용
	 */
	public static void main02(String[] args) {
		ApplicationContext ctx = 
				new FileSystemXmlApplicationContext("application-context02.xml");
	
		Member m2 = (Member)ctx.getBean("m2");
		System.out.println(m2.getName());
		System.out.println(m2.getAge());
	}
	
	/* [Factory Method 패턴을 사용하여 객체 생성 - 스태틱 메서드 호출]
	 * - static으로 선언된 팩토리 메서드 사용
	 */
	public static void main01(String[] args) {
		ApplicationContext ctx = 
				new FileSystemXmlApplicationContext("application-context02.xml");
	
		Member m1 = (Member)ctx.getBean("m1");
		System.out.println(m1.getName());
		System.out.println(m1.getAge());
	}
	

}
