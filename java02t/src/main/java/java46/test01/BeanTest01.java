package java46.test01;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java46.vo.Member;
import java46.vo.Project;

public class BeanTest01 {

	public static void main(String[] args) {
		ApplicationContext ctx = 
				new FileSystemXmlApplicationContext("application-context.xml");
	
	}
	/* [Properties 타입의 프로퍼티 값 설정]
	 * - <props> 태그 사용
	 */
	public static void main08(String[] args) {
		ApplicationContext ctx = 
				new FileSystemXmlApplicationContext("application-context.xml");
	
		Member mm2 = (Member)ctx.getBean("mm2");
		Properties props = mm2.getEmails();
		for (Object key : props.keySet()) {
			System.out.println(key + "=" + props.get(key));
		}
	}
	/* [Map 타입의 프로퍼티 값 설정]
	 * - <map> 태그 사용
	 */
	public static void main07(String[] args) {
		ApplicationContext ctx = 
				new FileSystemXmlApplicationContext("application-context.xml");
		
		Member mm1 = (Member)ctx.getBean("mm1");
		Map<String,String> tels = mm1.getTels();
		for (String key : tels.keySet()) {
			System.out.println( key + "=" + tels.get(key) );
		}
		System.out.println("------------------------");
		for (Map.Entry<String,String> entry : tels.entrySet()) {
			System.out.println( entry.getKey() + "=" + entry.getValue() );
		}
	}
	
	/* [List, Set 타입의 프로퍼티 값 설정 ]
	 * - <list> 또는 <set> 태그를 사용한다.
	 */
	public static void main06(String[] args) {
		ApplicationContext ctx = 
				new FileSystemXmlApplicationContext("application-context.xml");
	
		Project pl1 = (Project)ctx.getBean("pl1");
		Set<Member> members = pl1.getMembers();
		for (Member m : members) {
			System.out.println(m.getName());
		}
	
	}
	/* [프로퍼티에 객체 할당]
	 * - ref 속성 사용
	 * - 객체 생성
	 */
	public static void main05(String[] args) {
		ApplicationContext ctx = 
				new FileSystemXmlApplicationContext("application-context.xml");
		
		Project pm1 = (Project)ctx.getBean("pm1");
		Member mgr = pm1.getManager();
		System.out.println(pm1.getTitle());
		System.out.println(mgr.getName());
		
		Project pm2 = (Project)ctx.getBean("pm2");
		Member mgr2 = pm2.getManager();
		System.out.println(pm2.getTitle());
		System.out.println(mgr2.getName());
		
		/* pm3와 m5가 생성되는 시점
		 * 먼저 모든 객체들을 생성 -> 각 객체에 대해 의존 객체 주입
		 * 즉, 다음 코드와 같은 원리이다.  
		 */
		/*
		Member m5 = new Member();
		Project pm3 = new Project("프로젝트 with 관리자3", 0);
		
		m5.setName("오호라");
		m5.setAge(40);
		pm3.setManager(m5);
		*/
		
		Project pm4 = (Project)ctx.getBean("pm4");
		Member mgr4 = pm4.getManager();
		System.out.println(pm4.getTitle());
		System.out.println(mgr4.getName());
	}
	
	/* 3. 호출할 생성자 설정하는 방법
	 * - 생성자를 지정하지 않으면 기본 생성자를 호출한다.
	 * - <constructor-arg> 태그 사용
	 */
	public static void main04(String[] args) {
		ApplicationContext ctx = 
				new FileSystemXmlApplicationContext("application-context.xml");
		
		Project p1 = (Project)ctx.getBean("p1");
		System.out.println(p1.getTitle());
		System.out.println(p1.getState());
		
		Project p2 = (Project)ctx.getBean("p2");
		System.out.println(p2.getTitle());
		System.out.println(p2.getState());
		
		Project p3= (Project)ctx.getBean("p3");
		System.out.println(p3.getTitle());
		System.out.println(p3.getState());
		
		Project p4= (Project)ctx.getBean("p4");
		System.out.println(p4.getTitle());
		System.out.println(p4.getState());
	}
	
	/* 2. 빈의 프로퍼티 설정
	 * - <property>와 <value> 사용
	 * - <property>와 value 속성 사용
	 * - p:속성명 사용
	 */
	public static void main03(String[] args) {
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
