package java01.exam11.test.protocol.step02;

public class Driver {
	public void drive(Movable mover) {
		mover.move();
	}
	
	public static void main(String[] args) {
		Tank tank = new Tank();
		Car car = new Car();
		Driver driver = new Driver();
		
		driver.drive(car);
		driver.drive(tank);
	}
}








