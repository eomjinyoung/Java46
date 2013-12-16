package java01.exam07.test;

// 다형성
// - Overloading: 같은 기능을 하는 메서드에 대해 같은 이름 부여
//   							프로그래밍의 일관성 확보
// - Overriding: 상속 받은 메서드를 서브 클래스의 역할에 맞게 변경 또는 재작성
// - Polymorphic Variable: 어떤 참조 변수는 그 하위 객체의 주소를 담을 수 있다.
//					=> 객체의 교체를 원활히 한다.

class Calculator {
	public int plus(int a, int b) {
		return a + b;
	}
	
	public float plus(float a, float b) {
		return a + b;
	}
}

class Calculator2 extends Calculator {
	public int plus(int a) { // Overloading : 같은 이름이 메서드 추가
		return a * 2;
	}
	
	public int plus(int a, int b) { // Overriding: 상속 받은 메서드 재정의
		return a + b + 3;
	}
}

public class Test03 {
	public static void main(String[] args) {
		Calculator2 c1 = new Calculator2();
		int r1 = c1.plus(20, 30);
		System.out.println(r1);
	}
	
	public static void main01(String[] args) {
		Calculator c1 = new Calculator();
		int r1 = c1.plus(20, 30);
		float r2 = c1.plus(20.1f, 30.2f);
		
		System.out.println(r1);
		System.out.println(r2);
	}

}







