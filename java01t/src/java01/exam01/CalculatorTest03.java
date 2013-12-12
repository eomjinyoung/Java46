package java01.exam01;

public class CalculatorTest03 {
	static double result = 0;
	static String calcPath = "";
	
	public static void main(String[] args) {
		//20 * 30 + 2 - 13 / 4 = ?
		compute("", 20);
		compute("*", 30);
		compute("+", 2);
		compute("-", 13);
		compute("/", 4);
		printResult();
		
		//30 / 2 - 4 * 3 = ?
		compute("", 30);
		compute("/", 2);
		compute("-", 4);
		compute("*", 3);
		printResult();
		
	}
	
	static void compute(String op, double value) {
		switch(op) {
		case "":
			calcPath = "" + value;
			result = value;
			break;
		case "+":
			calcPath += "+ " + value;
			result += value;
			break;
		case "-":
			calcPath += "- " + value;
			result -= value;
			break;
		case "*":
			calcPath += "* " + value;
			result *= value;
			break;
		case "/":
			calcPath += "/ " + value;
			result /= value;
			break;
		}
		calcPath += " ";
	}
	
	
	static void printResult() {
		System.out.println("------------------------");
		System.out.println(calcPath);
		System.out.println("계산 결과는:" + result);
		System.out.println("***********************");
	}
}





















