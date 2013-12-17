package java01.exam08;

import java.util.Scanner;
import java01.exam08.vo.Member;

public class SpmsApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Member member = new Member();
		
		System.out.print("이름:");
		member.setName(scanner.nextLine());
		
		System.out.print("나이:");
		member.setAge( Integer.parseInt(scanner.nextLine()) );
		
		System.out.print("이메일:");
		member.setEmail(scanner.nextLine());
		
		System.out.print("전화:");
		member.setTel(scanner.nextLine());
		
		System.out.print("등록하시겠습니까?(y/n)");
		String command = scanner.nextLine();
		
		if (command.toLowerCase().equals("y")) {
			System.out.println("등록 성공입니다.");
		} else {
			System.out.println("등록 취소하였습니다.");
		}
		
		System.out.println("----------------------------");
		System.out.println("이름 \t 나이 \t 전화");
		System.out.println("----------------------------");
		System.out.print(member.getName() + "\t");
		System.out.print(member.getAge() + "\t");
		System.out.print(member.getTel());
	}

}















