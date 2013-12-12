package java01.exam03;

public class Calculator {
	double result = 0;
	String calcPath = "";
	
	public void compute(/*Calculator this,*/ String op, double value) {
		switch(op) {
		case "":
			this.calcPath = "" + value;
			this.result = value;
			break;
		case "+":
			this.calcPath += "+ " + value;
			this.result += value;
			break;
		case "-":
			this.calcPath += "- " + value;
			this.result -= value;
			break;
		case "*":
			this.calcPath += "* " + value;
			this.result *= value;
			break;
		case "/":
			this.calcPath += "/ " + value;
			this.result /= value;
			break;
		}
		this.calcPath += " ";
	}
	
	
	public void printResult(/*Calculator this*/) {
		System.out.println("------------------------");
		System.out.println(this.calcPath);
		System.out.println("계산 결과는:" + this.result);
		System.out.println("***********************");
	}	
}









