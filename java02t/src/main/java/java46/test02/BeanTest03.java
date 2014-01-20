package java46.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class BeanTest03 {
	/* [@Component를 이용하여 객체 자동 생성 - 객체의 아이디 값을 변경]
	 * - <bean id="객체이름" class="클래스명"/>
	 * - @Component로 객체를 생성하는 경우 객체의 이름은 클래스명(첫 알파벳은 소문자)이 된다.
	 * - @Component(객체이름)
	 * [프로퍼티 값 설정]
	 * - <property name="프로퍼티일름" value="값"/>
	 * - @Autowired : 셋터 메서드 앞에 선언한다. 자동으로 객체 주입할 것을 선언한다.
	 *                셋터의 파라미터 타입과 일치하는 객체를 찾아서 넣어준다.
	 *                만약 못 찾으면 예외가 발생한다.
	 *                스프링 애노테이션이다.
	 *   @Autowired(required=false) : 있으면 넣고, 없으면 안 넣는다. 
	 *                값을 주입하는 것은 선택사항이다.
	 * - @Value("값") : 파라미터에 들어갈 값을 설정. 파라미터 변수 선언 앞에 넣는다.
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = 
				new FileSystemXmlApplicationContext("application-context03.xml");
		
		Member m1 = (Member)ctx.getBean("ohoraMember");
		System.out.println(m1.getName());
		System.out.println(m1.getAge());
	}
	
	/* [@Component를 이용하여 객체 자동 생성]
	 * - 자동으로 생성할 클래스를 찾기 위해서는 설정 파일에 선언해야 한다.
	 *   <conext:component-scan> 태그 사용
	 */
	public static void main02(String[] args) {
		ApplicationContext ctx = 
				new FileSystemXmlApplicationContext("application-context03.xml");
		
		System.out.println(ctx.getBeanDefinitionCount());
		for (String name : ctx.getBeanDefinitionNames()) {
			System.out.println(name);
		}
		
		try {
			Member m = ctx.getBean(Member.class);
		 	System.out.println("있다!");
		 	
		 	Member m2 = (Member)ctx.getBean("member");
		 	if (m == m2) {
		 		System.out.println("m == m2");
		 	} else {
		 		System.out.println("m != m2");
		 	}
		} catch (Exception e) {
			System.out.println("없다!");
		}
	}
	
}





