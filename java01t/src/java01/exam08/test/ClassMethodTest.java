package java01.exam08.test;

public class ClassMethodTest {
	public static void m1() {
		System.out.println("m1()");
	}
	
	public void m2() {
		System.out.println("m1()");
		m1();
		this.m3();
	}
	
	public void m3() {
		
	}
	
	public static void main(String[] args) {
		m1();
		
		ClassMethodTest p = new ClassMethodTest();
		p.m2();
	}

}
