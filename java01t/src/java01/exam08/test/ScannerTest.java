package java01.exam08.test;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("당은 무슨 꽃을 좋아 하나요?");
		String flower = scanner.nextLine();
		System.out.println(flower);
		
		System.out.print("좋아하는 텔런트?");
		String talent = scanner.nextLine();
		System.out.println(talent);
	}

}
