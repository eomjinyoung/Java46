package java01.exam09;

import java.util.ArrayList;
import java.util.Scanner;

import java01.exam08.vo.Member;

public class SpmsApp {
	static ArrayList<Member> members = new ArrayList<Member>();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] command = null;
		
		loop:
		while(true) {
			command = prompt(scanner);
			
			switch(command[0]) {
			case "add": processAdd(scanner); break;
			case "list": processList(); break;
			case "update": processUpdate(scanner, command[1]); break;
			case "delete": processDelete(scanner, command[1]); break;
			case "read": processRead(command[1]); break;
			case "quit": break loop;
			default:
				System.out.println("사용할 수 없는 명령어입니다.");
			}
		}
		scanner.close();
	}

	private static void processRead(String email) {
		for (Member member : members) {
			if (email.equals(member.getEmail())) {
				System.out.println("이름:" + member.getName());
				System.out.println("나이:" + member.getAge());
				System.out.println("이메일:" + member.getEmail());
				System.out.println("전화:" + member.getTel());
				return;
			}
		}
  }

	private static void processDelete(Scanner scanner, String email) {
	  // TODO Auto-generated method stub
	  
  }

	private static void processUpdate(Scanner scanner, String email) {
	  // TODO Auto-generated method stub
	  
  }

	private static void processList() {
		System.out.println("----------------------------");
		System.out.println("이름 \t 나이 \t 전화");
		System.out.println("----------------------------");
		
		for (Member member : members) {
			System.out.print(member.getName() + "\t");
			System.out.print(member.getAge() + "\t");
			System.out.println(member.getTel());
		}
	  
  }

	private static void processAdd(Scanner scanner) {
		Member member = null;
		String command = null;
		
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
  }

	private static String[] prompt(Scanner scanner) {
	  System.out.print("명령>");
	  return scanner.nextLine().split(" ");
  }
}















