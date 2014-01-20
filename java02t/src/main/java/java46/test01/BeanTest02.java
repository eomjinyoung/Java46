package java46.test01;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java46.vo.Member;
import java46.vo.Project;

public class BeanTest02 {

	/* [Factory Method 패턴을 사용하여 객체 생성 - AbstractFactoryBean 상속]
	 */
	public static void main(String[] args) {
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
