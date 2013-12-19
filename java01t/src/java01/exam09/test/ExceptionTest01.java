package java01.exam09.test;

//1. 오류 처리 예전 방식
// 문제점:
// - 오류가 발생했을 때 반환하는 값이 정상 값일 수도 있다.
// - 코드 중간 중간에 오류 처리를 위한 검사 코드가 들어감으로
//   오류 검사 및 처리 코드와 일반 코드가 섞여 있다. 
//   => 코드의 가독성을 낮춘다.
public class ExceptionTest01 {

	// 1) 오류를 알려 주는 방법
	// - 특별한 값을 반환한다.
	public static int divide(int a, int b) {
		if (b == 0) {
			return -9999;
		}
		return a / b;
	}
	
	// 2) 오류를 처리하는 방법
	// - 조건문을 통해 반환한 값이 오류 코드와 일치하는지 여부검사
	public static void main(String[] args) {
		int result = divide(9999, -1);
		
		if (result == -9999) {
			System.out.println("나누기 오류입니다!");
		} else {
			System.out.println(result);
		}
	}

}








