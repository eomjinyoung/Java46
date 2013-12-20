package java01.exam10.test;

//1. 클래스 앞에 붙는 final
// - 상속 불가!
//	 - 객체 지향의 다형성의 문제점을 보완
//   다형성 => 대체가능 => 기존 기능을 무력화 => 보안에 위협 
//		 상속불가 => 그 객체의 자리를 다른 클래스가 대체할 수 없다.
// A p = new A(); //ok
// A p2 = new B(); //ok
final class A {
	
}

/*
class B extends A {
	
}*/

//2. 메서드에 붙이는 final
// - 변경해서는 안되는 중요 메서드에 대해 붙인다.
// - 재정의(Overriding) 불가!
class C {
	void m() {}
	final void m2() {}
	void m3() {}
}

class D extends C {
	void m() {}
	//void m2() {} // overriding 불가!
}

//3. 인스턴스 또는 클래스 변수에 대해 붙이는 final
// - 보통 상수를 만들 때 사용
// - 값을 한 번만 할당 가능.
// - 클래스 변수에 대해 사용함.
//		ex) 	public static final int A = 20;
class K {
	public static final int MAX_VALUE = 20;
}

//3. 파라미터 변수에 붙이는 final
// - 파라미터 변수를 다른 용도로 오용하지 않도록 보안 장치.
class M {
	void m(final Object obj, Object obj2) {
		//obj = new String("nono");
		obj2 = new String("okok");
	}
}

public class FinalTest {
	public static void main(String[] args) {
		
	}

}
