package java01.test;

import java01.exam03.Calculator;

public class Test04 {

	public static void main(String[] args) {
		// 1) 20 + 30 * 3 = ?
		// 2) 10 / 2 + 45 = ?
		
		// 계산기 변수를 개별적으로 생성
		Calculator c1 = new Calculator(); 
		                  // JVM아, Calculator에 선언된 변수 중에서 인스턴스 변수를 
											// Heap 메모리 영역에 생성하라! 시작 주소를 리턴하라!
		Calculator c2 = new Calculator();
		
		c1.compute("", 20);
		c2.compute("", 10);
		
		c1.compute("+", 30);
		c2.compute("/", 2);
		
		c1.compute("*", 3);
		c2.compute("+", 45);
		
		c1.printResult();
		c2.printResult();
	}

}
