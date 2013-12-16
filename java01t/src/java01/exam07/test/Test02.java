package java01.exam07.test;

//상속
// - 인스턴스 변수의 생성과 초기화
// - 생성자 호출의 순서
// - super 클래스의 생성자 호출
// - overloading: 같은 기능을 수행하는 메서드에 대해 같은 이름 부여
//                프로그래밍의 일관성 확보

class Car {
	int cc;
	String model;
	String maker;
	
	public Car() {
		cc = 2000;
	}
	
	public Car(int cc) {
		this.cc = cc;
	}
}

class SUV extends Car {
	int seats = 5;
	
	public SUV() {
		seats = 4;
	}
	
	public SUV(int cc, int seats) {
		super(cc);
		//this.cc = cc;
		this.seats = seats;
	}
}

class Truck extends Car {
	int weight = 10;
	
	public Truck() {
		weight = 8;
	}
}

public class Test02 {
	public static void main(String[] args) {
		SUV c1 = new SUV();
		SUV c2 = new SUV(2000, 3);
		
		
	}
	
	public static void main01(String[] args) {
		SUV c1 = new SUV();
		Truck c2 = new Truck();
		
		c1.cc = 2000;
		c1.model = "소나타";
		c1.maker = "현대";
		c1.seats = 5;
		
		c2.cc = 8000;
		c2.model = "골리앗";
		c2.maker = "기아";
		c2.weight = 15;

	}

}











