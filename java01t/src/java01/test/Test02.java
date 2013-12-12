package java01.test;

import java01.exam01.Calculator;

public class Test02 {

	public static void main(String[] args) {
		// 1) 20 + 30 * 3 = ?
		// 2) 10 / 2 + 45 = ?
		
		Calculator.compute("", 20);
		Calculator.compute("+", 30);
		Calculator.compute("*", 3);
		Calculator.printResult();
		
		Calculator.compute("", 10);
		Calculator.compute("/", 2);
		Calculator.compute("+", 45);
		Calculator.printResult();
		

	}

}
