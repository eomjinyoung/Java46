package java01.exam01;

public class Calculator {
	static double result = 0;
	static String calcPath = "";
	
	public static void compute(String op, double value) {
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
	
	
	public static void printResult() {
		System.out.println("------------------------");
		System.out.println(calcPath);
		System.out.println("계산 결과는:" + result);
		System.out.println("***********************");
	}	
}
