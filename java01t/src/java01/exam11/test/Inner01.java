package java01.exam11.test;

// 클래스의 종류 : 패키지 멤버 클래스와 inner 클래스 
// 중첩(inner) 클래스
// - 다른 클래스 안에 선언되는 클래스
// - 패키지 멤버 클래스는 전체 공개가 목적.
// - 중첩 클래스는 오로지 해당 클래스에서만 사용하기 위함.
// 1) top level inner class
//			- static 으로 선언
//			- 자잘한 상수 값들을 묶을 경우 주로 사용 
//			- 패키지 멤버 클래스로 상수를 관리하는 것 보다 편함.
// 2) member inner class
//			- instance 로 선언
// 3) local inner class
//			- 메서드 안에 선언
// 4) anonymous inner class
//			- 이름이 없는 클래스
// 		- 딱 한 번 만 사용되는 경우

import static java01.exam11.test.Constants.IconSizes.*;

import java.lang.reflect.Method;

class Outer {
	//1) top level inner class
	static class A {
		public void m() {
			System.out.println("top level inner class....");
		}
	}
	
	//2) member inner class
	class B {
		public void m() {
			System.out.println("member inner class....");
		}
	}
	
	public void test() {
		int i;
		
		class C {
			public void m2() {
				System.out.println("C의 m2()");
			}
		}
		
		C p = new C();
		p.m2();
	}
	
	public void test2() {
		class D {
			public void m2() {
				System.out.println("C의 m2()");
			}
		}
		//C p = new C();
	}
	
	public void test3() {
		Object p = new Object() {
			public void m3() {
				System.out.println("이름이 없다...");
			}
			
			@Override
			public String toString() {
			  return "okok";
			}
		};
		
		System.out.println(p);
		
		try {
			Class c = p.getClass();
			Method m = c.getMethod("m3");
			m.invoke(p);
		} catch (Exception e) {}
		
		
	}
}

public class Inner01 {
	public static void main(String[] args) {
		Outer obj = new Outer();
		//obj.test();
		obj.test3();
	}
	
	public static void main02(String[] args) {
		Outer obj = new Outer();
		Outer.B p = obj.new B();
		
	}
	
	public static void main01(String[] args) {
		Outer.A p = new Outer.A();
		p.m();
		
		int size = MAX_ICON;
	}

}














