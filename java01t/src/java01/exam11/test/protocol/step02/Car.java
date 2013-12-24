package java01.exam11.test.protocol.step02;

public class Car implements Movable {
	public void move() {
		System.out.println("간다...");
	}
	
	public void stop() {
		System.out.println("멈춘다...");
	}
}
