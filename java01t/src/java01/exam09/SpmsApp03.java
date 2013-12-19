package java01.exam09;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import java01.exam09.vo.Member;

public class SpmsApp03 {
	static ArrayList<Member> members = new ArrayList<Member>();
	
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		String[] command = null;
		
		load();
		
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
		
		save();
	}

	private static void load() throws Exception {
		FileInputStream in = new FileInputStream("member02.dat");
		ObjectInputStream in2 = new ObjectInputStream(in);
		
		int len = in2.readInt();
		
		Member member = null;
		for (int i = 0; i < len; i++) {
			member = (Member)in2.readObject();
			System.out.println(member);
		}
		
		in2.close();
		in.close();
	}

	private static void save() throws Exception {
		FileOutputStream out = new FileOutputStream("member02.dat");
		ObjectOutputStream out2 = new ObjectOutputStream(out);
		
		out2.writeInt(members.size());
		
		for (Member member : members) {
			out2.writeObject(member);
		}
		
		out2.close();
		out.close();
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
		for (Member member : members) {
			if (email.equals(member.getEmail())) {
				System.out.print("정말 삭제하시겠습니까?(y/n)");
				String command = scanner.nextLine();
				if (command.toLowerCase().equals("y")) {
					members.remove(member);
					System.out.println("삭제되었습니다.");
				} else {
					System.out.println("삭제 취소하였습니다.");
				}
				return;
			}
		}
		
		System.out.println("해당 이메일의 멤버를 찾을 수 없습니다!");
  }

	private static void processUpdate(Scanner scanner, String email) {
		Member temp = new Member();
		Member member = null; 
		
		for (int i = 0; i < members.size(); i++) {
			member = members.get(i);
			if (email.equals(member.getEmail())) {
				System.out.print("이름(" + member.getName() + "):");
				String value = scanner.nextLine();
				if (!value.equals("")) {
					temp.setName(value);
				} else {
					temp.setName(member.getName());
				}
				System.out.print("나이(" + member.getAge() + "):");
				value = scanner.nextLine();
				if (!value.equals("")) {
					temp.setAge( Integer.parseInt(value) );
				} else {
					temp.setAge( member.getAge() );
				}
				System.out.print("전화(" + member.getTel() + "):");
				value = scanner.nextLine();
				if (!value.equals("")) {
					temp.setTel(value);
				} else {
					temp.setTel(member.getTel());
				}
				
				temp.setEmail(member.getEmail());
				
				System.out.print("변경하시겠습니까?(y/n)");
				value = scanner.nextLine();
				
				if (value.toLowerCase().equals("y")) {
					members.set(i, temp);
					System.out.println("변경 성공입니다.");
				} else {
					System.out.println("변경 취소하였습니다.");
				}
				return;
			}
		}
		
		System.out.println("해당 이메일의 멤버를 찾을 수 없습니다.");
	  
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















