package java01.exam12.server;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java01.exam12.server.vo.Member;

public class MemberController {
	ArrayList<Member> members;
	PrintStream out;
	Scanner in;
	
	public MemberController(Scanner in, PrintStream out) {
		this.in = in;
		this.out = out;
	}
	
	public void execute() {
		String[] command = null;
		
		load();
		
		loop:
		while(true) {
			command = prompt();
			
			try {
				switch(command[0]) {
				case "add": processAdd(); break;
				case "list": processList(); break;
				case "update": processUpdate( command[1]); break;
				case "delete": processDelete( command[1]); break;
				case "read": processRead(command[1]); break;
				case "quit": break loop;
				default:
					out.println("사용할 수 없는 명령어입니다.");
				}
			} catch (Exception e) {
				e.printStackTrace();
				out.println("명령어 실행 중 오류가 발생했습니다!");
			}
		}
		save();
	}

	@SuppressWarnings("unchecked")
  private void load() {
		try {
			FileInputStream in = new FileInputStream("spms_member1226.dat");
			ObjectInputStream in2 = new ObjectInputStream(in);
			
			members = (ArrayList<Member>)in2.readObject();
			
			in2.close();
			in.close();
		} catch (Exception e) {
			out.println("파일 로딩 중 오류발생!");
			members = new ArrayList<Member>();
    }
	}

	private void save() {
		try {
			FileOutputStream out = new FileOutputStream("spms_member1226.dat");
			ObjectOutputStream out2 = new ObjectOutputStream(out);
			
			out2.writeObject(members);
			
			out2.close();
			out.close();
		} catch (Exception e) {
			out.println("저장 중 오류발생!");
		}
  }

	private String[] prompt() {
	  out.println("멤버관리>");
	  out.println();
	  return in.nextLine().split(" ");
  }
	
	private void processRead(String email) {
		for (Member member : members) {
			if (email.equals(member.getEmail())) {
				out.println("이름:" + member.getName());
				out.println("나이:" + member.getAge());
				out.println("이메일:" + member.getEmail());
				out.println("전화:" + member.getTel());
				return;
			}
		}
  }

	private void processDelete(String email) {
		for (Member member : members) {
			if (email.equals(member.getEmail())) {
				out.println("정말 삭제하시겠습니까?(y/n)");
				out.println();
				String command = in.nextLine();
				if (command.toLowerCase().equals("y")) {
					members.remove(member);
					out.println("삭제되었습니다.");
				} else {
					out.println("삭제 취소하였습니다.");
				}
				return;
			}
		}
		
		out.println("해당 이메일의 멤버를 찾을 수 없습니다!");
  }

	private void processUpdate(String email) {
		Member temp = new Member();
		Member member = null; 
		
		for (int i = 0; i < members.size(); i++) {
			member = members.get(i);
			if (email.equals(member.getEmail())) {
				out.println("이름(" + member.getName() + "):");
				out.println();
				String value = in.nextLine();
				if (!value.equals("")) {
					temp.setName(value);
				} else {
					temp.setName(member.getName());
				}
				out.println("나이(" + member.getAge() + "):");
				out.println();
				value = in.nextLine();
				if (!value.equals("")) {
					temp.setAge( Integer.parseInt(value) );
				} else {
					temp.setAge( member.getAge() );
				}
				out.println("전화(" + member.getTel() + "):");
				out.println();
				value = in.nextLine();
				if (!value.equals("")) {
					temp.setTel(value);
				} else {
					temp.setTel(member.getTel());
				}
				
				temp.setEmail(member.getEmail());
				
				out.println("변경하시겠습니까?(y/n)");
				out.println();
				value = in.nextLine();
				
				if (value.toLowerCase().equals("y")) {
					members.set(i, temp);
					out.println("변경 성공입니다.");
				} else {
					out.println("변경 취소하였습니다.");
				}
				return;
			}
		}
		
		out.println("해당 이메일의 멤버를 찾을 수 없습니다.");
  }

	private void processList() {
		out.println("----------------------------");
		out.println("이름 \t 나이 \t 전화");
		out.println("----------------------------");
		
		for (Member member : members) {
			out.print(member.getName() + "\t");
			out.print(member.getAge() + "\t");
			out.println(member.getTel());
		}
	  
  }

	private void processAdd() {
		Member member = null;
		String command = null;
		
		do {
			member = new Member();
			
			out.println("이름:");
			out.println();
			member.setName(in.nextLine());
			
			out.println("나이:");
			out.println();
			member.setAge( Integer.parseInt(in.nextLine()) );
					
			out.println("이메일:");
			out.println();
			member.setEmail(in.nextLine());
			
			out.println("전화:");
			out.println();
			member.setTel(in.nextLine());
			
			out.println("등록하시겠습니까?(y/n)");
			out.println();
			command = in.nextLine();
			
			if (command.toLowerCase().equals("y")) {
				members.add(member);
				out.println("등록 성공입니다.");
			} else {
				out.println("등록 취소하였습니다.");
			}
			
			out.println("계속하시겠습니까?(y/n)");
			out.println();
			command = in.nextLine();
		} while (command.toLowerCase().equals("y"));
  }
}
