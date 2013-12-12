package java01.exam01;

public class CalculatorTest {
	public static void main(String[] args) {
		//20 * 30 + 2 - 13 / 4 = ?
		Calculator.compute("", 20);
		Calculator.compute("*", 30);
		Calculator.compute("+", 2);
		Calculator.compute("-", 13);
		Calculator.compute("/", 4);
		Calculator.printResult();
		
		//30 / 2 - 4 * 3 = ?
		Calculator.compute("", 30);
		Calculator.compute("/", 2);
		Calculator.compute("-", 4);
		Calculator.compute("*", 3);
		Calculator.printResult();
	}
}





















