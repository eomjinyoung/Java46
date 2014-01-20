package java46.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java46.vo.Member;

public class BeanTest01 {

	public static void main(String[] args) {
		ApplicationContext ctx = 
				new FileSystemXmlApplicationContext("application-context.xml");
		
		Member m2 = (Member)ctx.getBean("m2");
		
		System.out.println(m2.getName());
		System.out.println(m2.getAge());
		
		Member m3= (Member)ctx.getBean("m3");
		
		System.out.println(m3.getName());
		System.out.println(m3.getAge());
		
		Member m4= (Member)ctx.getBean("m4");
		
		System.out.println(m4.getName());
		System.out.println(m4.getAge());
	}
	
	/* 1. 스프링 IoC 컨테이너를 이용하여 빈 관리 
	 * - 빈 정보를 설정한 파일을 작성한다.(예: application-context.xml)
	 * - 빈 정보 설정파일을 읽어서 빈을 생성한다.
	 * - IoC 컨테이너 클래스 
	 *   1) ClassPathXmlApplicationContext : 클래스 경로에서 설정 파일을 찾는다.
	 *   2) FileSystemXmlApplicationContext : 일반 파일 시스템 경로에서 설정 파일을 찾는다.
	 */
	public static void main02(String[] args) {
		ApplicationContext ctx = 
				new FileSystemXmlApplicationContext("application-context.xml");
		Member m1 = (Member)ctx.getBean("m1");
		
		m1.setName("홍길동");
		m1.setAge(20);
		
		System.out.println(m1.getName());
		System.out.println(m1.getAge());
	}
	
	public static void main01(String[] args) {
		Member m1 = new Member();
		m1.setName("홍길동");
		m1.setAge(20);
		
		System.out.println(m1.getName());
		System.out.println(m1.getAge());
	}

}
