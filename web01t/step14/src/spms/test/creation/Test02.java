package spms.test.creation;

//1. Factory Method 패턴
class CarFactory {
	public Car createCar(String carName) {
		switch(carName) {
		case "tico":
			return new Tico();
		case "sonata":
			return new Sonata();
		default: return null;
		}
	}
}

public class Test02 {
	public static void main(String[] args) {
		CarFactory cf = new CarFactory();
		
		Car c1 = cf.createCar("tico");
		Car c2 = cf.createCar("sonata");
		
	}
}








