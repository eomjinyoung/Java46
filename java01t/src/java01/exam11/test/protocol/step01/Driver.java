package java01.exam11.test.protocol.step01;


public class Driver {
	public void drive(Object obj) {
		if (obj instanceof Car) {
			((Car) obj).move();
		} else {
			((Tank) obj).run();
		}
	}
	
	public static void main(String[] args) {
		Tank tank = new Tank();
		Car car = new Car();
		Driver driver = new Driver();
		driver.drive(car);
		driver.drive(tank);
	}
}








