package java01.test;

import java01.exam01.Calculator;

public class Test01 {

	public static void main(String[] args) {
		//20 + 3 * 7 = ?
		Calculator.compute("", 20);
		Calculator.compute("+", 3);
		Calculator.compute("*", 7);
		Calculator.printResult();

	}

}
