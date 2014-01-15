package spms.test;

class Car {
	
}

public class InstanceTest {
	public static void main(String[] args) {
		Car c = new Car();
		m(c);
	}
	
	public static void m(Car c) {
		m2(c);
	}
	
	public static void m2(Car c) {
		m3(c);
	}
	
	public static void m3(Car c) {
		
	}

}
