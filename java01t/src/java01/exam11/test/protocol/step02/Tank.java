package java01.exam11.test.protocol.step02;

public class Tank implements Movable{
	public void move() {
		System.out.println(">> 간다..");
	}
	
	public void stop() {
		System.out.println(">> 멈춘다..");
	}
}
