package java01.exam09;

import java.util.ArrayList;
import java.util.Scanner;

import java01.exam08.vo.Member;

public class SpmsApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] command = null;
		
		loop:
		while(true) {
			command = prompt(scanner);
			
			switch(command[0]) {
			case "add":
				System.out.println("add 처리");
				break;
			case "list":
				System.out.println("list 처리");
				break;
			case "update":
				System.out.println("update 처리");
				break;
			case "delete":
				System.out.println("delete 처리");
				break;
			case "read":
				System.out.println("read 처리");
				break;
			case "quit":
				break loop;
			default:
				System.out.println("사용할 수 없는 명령어입니다.");
			}
		}
		scanner.close();
	}

	private static String[] prompt(Scanner scanner) {
	  System.out.print("명령>");
	  return scanner.nextLine().split(" ");
  }
	
	public static void main01(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String command = null;
		ArrayList members = new ArrayList();
		Member member = null;
		
		do {
			member = new Member();
			
			System.out.print("이름:");
			member.setName(scanner.nextLine());
			
			System.out.print("나이:");
			member.setAge( Integer.parseInt(scanner.nextLine()) );
					
			System.out.print("이메일:");
			member.setEmail(scanner.nextLine());
			
			System.out.print("전화:");
			member.setTel(scanner.nextLine());
			
			System.out.print("등록하시겠습니까?(y/n)");
			command = scanner.nextLine();
			
			if (command.toLowerCase().equals("y")) {
				members.add(member);
				System.out.println("등록 성공입니다.");
			} else {
				System.out.println("등록 취소하였습니다.");
			}
			
			System.out.print("계속하시겠습니까?(y/n)");
			command = scanner.nextLine();
		} while (command.toLowerCase().equals("y"));
		
		System.out.println("----------------------------");
		System.out.println("이름 \t 나이 \t 전화");
		System.out.println("----------------------------");
		for (int i = 0; i < members.size(); i++) {
			member = (Member)members.get(i);
			System.out.print(member.getName() + "\t");
			System.out.print(member.getAge() + "\t");
			System.out.println(member.getTel());
		}
	}

}















