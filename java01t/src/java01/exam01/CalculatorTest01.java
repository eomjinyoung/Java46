package java01.exam01;

public class CalculatorTest01 {

	public static void main(String[] args) {
		//20 * 30 + 2 - 13 / 4 = ?
		double result = 0;
		String calcPath = ""; // 
		
		result = 20;
		calcPath += result + " "; // 20 
		
		result *= 30;
		calcPath += "* " + 30 + " "; // 20 * 30 
		
		result += 2;
		calcPath += "+ " + 2 + " "; // 20 * 30 + 2 
		
		result -= 13;
		calcPath += "- " + 13 + " "; // 20 * 30 + 2 - 13
		
		result /= 4;
		calcPath += "/ " + 4;
		
		System.out.println("***********************");
		System.out.println(calcPath);
		System.out.println("계산 결과는:" + result);
		System.out.println("***********************");
		
		//30 / 2 - 4 * 3 = ?
		result = 0;
		calcPath = "";
		
		result = 30;
		calcPath += 30 + " ";
		
		result /= 2;
		calcPath += "/ " + 2 + " ";
		
		result -= 4;
		calcPath += "- " + 4 + " ";
		
		result *= 3;
		calcPath += "* " + 3 + " ";
		
		System.out.println("***********************");
		System.out.println(calcPath);
		System.out.println("계산 결과는:" + result);
		System.out.println("***********************");
		
	}

}





















