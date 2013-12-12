package java01.exam02;

public class Calculator {
	double result = 0;
	String calcPath = "";
	
	public static void compute(Calculator p, String op, double value) {
		switch(op) {
		case "":
			p.calcPath = "" + value;
			p.result = value;
			break;
		case "+":
			p.calcPath += "+ " + value;
			p.result += value;
			break;
		case "-":
			p.calcPath += "- " + value;
			p.result -= value;
			break;
		case "*":
			p.calcPath += "* " + value;
			p.result *= value;
			break;
		case "/":
			p.calcPath += "/ " + value;
			p.result /= value;
			break;
		}
		p.calcPath += " ";
	}
	
	
	public static void printResult(Calculator p) {
		System.out.println("------------------------");
		System.out.println(p.calcPath);
		System.out.println("계산 결과는:" + p.result);
		System.out.println("***********************");
	}	
}
