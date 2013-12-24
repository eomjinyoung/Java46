package java01.exam11.test;

//2. 스레드 생성 : Runnable 인터페이스 구현
// - 이점 : 다른 클래스를 상속 받더라도 스레드를 만들 수 있다.
public class Thread02 {
	// Runnable 인터페이스
	// - 독립적으로 실행할 코드를 가진 객체임을 선언 
	// - MyObject는 스레드가 실행할 run() 메서드를 가지고 있다 라고 선언!
	// - MyObject는 스레드가 아님. 
	// - MyObject는 스레드가 호출할 run() 메서드를 가지고 있는 객체.
	static class MyObject implements Runnable {
		String name;
		
		public MyObject(String name) {
			this.name = name;
		}
		
		public void run() {
		  for (int i = 0; i < 10000; i++) {
		  		System.out.println(this.name + ": " + i);
		  }
		}
	}
	
	public static void main(String[] args) {
		new Thread(new MyObject("t1")).start();
		new Thread(new MyObject("t2")).start();
		
		for (int i = 0; i < 10000; i++) {
  			System.out.println("main(): " + i);
		}
	}

}

















