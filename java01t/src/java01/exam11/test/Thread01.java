package java01.exam11.test;

//1. 스레드 생성
//1) Thread 클래스 상속
// - 문제점 : 스레드를 만들고자 하는 클래스가 이미 다른 클래스를 상속할 경우
public class Thread01 {
	static class MyThread extends Thread {
		String name;
		
		public MyThread(String name) {
			this.name = name;
		}
		
		@Override
		public void run() {
		  for (int i = 0; i < 10000; i++) {
		  		System.out.println(this.name + ": " + i);
		  }
		}
	}
	
	public static void main(String[] args) {
		MyThread t1 = new MyThread("t1");
		MyThread t2 = new MyThread("t2");
		
		t1.start();
		t2.start();
		
		for (int i = 0; i < 10000; i++) {
  			System.out.println("main(): " + i);
		}
	}

}

















