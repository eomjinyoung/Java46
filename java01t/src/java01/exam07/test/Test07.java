package java01.exam07.test;

import java.util.ArrayList;

public class Test07 {

	//1. Wrapper 클래스
	// - 기본 데이터형을 좀 더 정교하게 다루기 위해 만든 클래스
	// - 기본 데이터형은 기껏 연산자를 사용해 데이터를 다룬다.
	// - 기본 데이터형의 값을 객체로 다루고자 할 때.
	// byte 		=> java.lang.Byte
	// short 	=> java.lang.Short 
	// int 		=> java.lang.Integer
	// long		=> java.lang.Long
	// float		=> java.lang.Float
	// double	=> java.lang.Double
	// char		=> java.lang.Character
	// boolean	=> java.lang.Boolean
	public static void main(String[] args) {
		Integer i = new Integer(10);
		Character c = new Character('c');
		
		// Auto-boxing
		Integer i2 = 10; // 상수풀에 인스턴스 자동 생성: new Integer(10);
		
		Integer i3 = new Integer(10);
		Integer i4 = 10; // 상수풀에 인스턴스 자동 생성: new Integer(10);
		
		if (i2 == i4) {
			System.out.println("i2 == i4");
		}

		// Auto-unboxing
		int i5 = i; // i.intValue() 자동 호출하여 int 값 반환함
		System.out.println(i5);
		
		Object obj = 10; //new Integer(10);
		
	}

}

















