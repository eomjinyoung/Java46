package java01.exam09.test;

//3. 시스템 예외 다루기(Error, RuntimeException)
/*
  	 - RuntimeException은 Exception의 자식 클래스임에도 불구하고 Error 처럼 다뤄진다.
  	 - 시스템 예외를 던질 때는 메서드에 선언하지 않아도 된다.
  	 - 시스템 예외는 try...catch...로 처리하지 않아도 된다.
 */
public class ExceptionTest03 {

	public static int divide(int a, int b) /*throws Error*/ {
		if (b == 0) {
			throw new Error("0으로 나눌 수 없습니다.");
		}
		return a / b;
	}
	
	// 2) 예외 처리하기
	public static void main(String[] args) {
		try {
			int result = divide(9999, 0);
			System.out.println(result);
			
		} catch (Error e) {
			System.out.println(e.getMessage());
		}
	}

}








