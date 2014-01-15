package spms.test.annotation;

import java.lang.annotation.Annotation;


//@Component("오호라") // value 속성 이름은 생략 가능(단, value 값만 설정할 때)
//@Component(value="오호라",name="nono",no=3)
//@Component(value="오호라",no=3,nicknames="우뢰매") // 배열에 값을 한 개 넣을 때는 그냥 문자열 작성 가능
//@Component(value="오호라",no=3,nicknames={"우뢰매"})
@Component(value="오호라",no=3,nicknames={"우뢰매","독수리1호"})
class MyClass {} 

public class AnnotationTest {
	public static void main(String[] args) throws Exception {
		MyClass obj = new MyClass();
		
		System.out.println("----------------------------------");
		// 클래스 객체를 얻는 방법 
		//1) Class.forName()을 통해서
		Class c1 = Class.forName("spms.test.annotation.MyClass");
		System.out.println("c1:" + c1.getName());
		
		//2) 인스턴스의 getClass()
		Class c2 = obj.getClass();
		System.out.println("c2:" + c2.getName());
		
		//3) 클래스 객체를 직접 표현
		//Class c3 = MyClass.class;
		System.out.println("c3:" + MyClass.class.getName());
		
		System.out.println("----------------------------------");
		// 클래스의 정보를 조사하는 도구를 얻기.
		Class c = obj.getClass();
		//c.getAnnotation( Class.forName("spms.test.annotation.Component") );
		Component compAnno = (Component)c.getAnnotation(Component.class);
		System.out.println(compAnno.name());
		System.out.println(compAnno.value());
		System.out.println(compAnno.no());
		System.out.println(compAnno.count());
		for (String n : compAnno.nicknames()) {
			System.out.println(n);
		}
	}

}






