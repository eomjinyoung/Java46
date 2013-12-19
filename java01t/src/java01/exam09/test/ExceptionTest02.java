package java01.exam09.test;

//2. 예외 처리 문법 도입
// - 이점
//		1) 리턴 값으로 예외 상황을 알리는 것 보다 더 정확하다.
//  2) 일반 코드와 예외 처리코드를 분리 => 코드 가독성이 좋아진다.
//  3) *** 예외가 발생하더라도 계속 실행할 수 있게 한다.
//
// - 예외가 발생했을 때 오류 정보를 담은 객체를 생성하여 호출자에게 던진다.
//   문법) throw new Exception("0으로 나눌 수 없습니다!");
//
// - 오류 검사 및 처리 코드를 일반 코드와 분리한다.
//   문법) 
/*
 * 	 try {
 * 			일반 코드 작성
 * 	 } catch (Exception e) { // throw에서 던진 오류 객체를 받는다.
 * 		  오류 처리 코드 작성 
 *   } finally {
 *      오류가 발생하든 아니든 무조건 마무리할 작업이 있다면 여기에 그 코드를 작성한다.
 *      물론, 이 블록이 없어도 된다.
 *   }
 */
public class ExceptionTest02 {

	// 1) 예외 발생을 호출자에게 알리기
	// - throw 명령을 통해 예외 정보를 던진다.
	// - 문법) throw {Throwable의 인스턴스}
	// - 예외를 던지는 메서드는 반드시 메서드 선언부에 어떤 예외를 던지는지 선언해야 한다.
	// - 문법) void 메서드명 throws 예외클래스1, 예외클래스2, ... { ... }
	public static int divide(int a, int b) throws Exception {
		if (b == 0) {
			throw new Exception("0으로 나눌 수 없습니다.");
		}
		return a / b;
	}
	
	// 2) 예외 처리하기
	public static void main(String[] args) {
		try {
			int result = divide(9999, 0);
			System.out.println(result);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}








