package spms.test.creation;

//2. Builder 패턴
class CarFactoryBuilder {
	public ICarFactory build(String loc, int capacity) {
		switch(loc) {
		case "강릉":
			return new SedanCarFactory();
		case "춘천":
			return new TruckCarFactory();
		default: 
			return null;
		}
	}
}

interface ICarFactory {
	Car createCar(String carName);
}

class SedanCarFactory implements ICarFactory {
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

class TruckCarFactory implements ICarFactory {
	public Car createCar(String carName) {
		switch(carName) {
		case "jumbo":
			return new Jumbo();
		case "titan":
			return new Titan();
		default: return null;
		}
	}
}

public class Test03 {
	public static void main(String[] args) {
		ICarFactory cf = new CarFactoryBuilder().build("강릉", 1400);
		
		Car c1 = cf.createCar("tico");
		Car c2 = cf.createCar("sonata");
		
		ICarFactory cf2 = new CarFactoryBuilder().build("춘천", 5000);
		Car c3 = cf2.createCar("jumbo");
		Car c4 = cf2.createCar("titan");
		
	
	}
}








