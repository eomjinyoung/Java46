package java01.exam07.test;

import java01.exam07.vo.Member;
import java01.exam07.vo.Member01;

// 캡슐화 의미 이해
// - 추상화를 무너지지 않게 하는 문법
// - Data를 직접 할당 => 무효한 데이터가 들어갈 수 있다.
//   => 추상화가 무너진다. => 직접 접근을 차단.
//   => 변수의 용도에 따라 접근 제한 문법이 필요
// - private, (default), protected, public 
// 
public class Test01 {
	public static void main(String[] args) {
		Member m = new Member();
		m.setName( "홍길동" );
		m.setAge( -30 );
		m.setEmail( "hong@test.com" );
		m.setTel( "010-1111-2222" );
		
		int a = 20;
		
		System.out.println(m.getName());
		System.out.println(m.getAge());
		System.out.println(m.getEmail());
		System.out.println(m.getTel());
	}
	
	public static void main01(String[] args) {
		Member01 m = new Member01();
		m.name = "홍길동";
		m.age = -30;
		m.email = "hong@test.com";
		m.tel = "010-1111-2222";
	}

}
