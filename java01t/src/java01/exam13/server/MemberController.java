package java01.exam13.server;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java01.exam13.server.dao.MemberDao;
import java01.exam13.server.vo.Member;

public class MemberController {
	MemberDao memberDao;
	PrintStream out;
	Scanner in;
	
	public MemberController(Scanner in, PrintStream out) {
		memberDao = new MemberDao();
		this.in = in;
		this.out = out;
	}
	
	public void execute() {
		String[] command = null;
		
		loop:
		while(true) {
			command = prompt();
			
			try {
				switch(command[0]) {
				case "add": processAdd(); break;
				case "list": processList(); break;
				case "update": 
					processUpdate( Integer.parseInt(command[1]) ); 
					break;
				case "delete": 
					processDelete( Integer.parseInt(command[1]) ); 
					break;
				case "read": 
					processRead( Integer.parseInt(command[1]) ); 
					break;
				case "quit": break loop;
				default:
					out.println("사용할 수 없는 명령어입니다.");
				}
			} catch (Exception e) {
				e.printStackTrace();
				out.println("명령어 실행 중 오류가 발생했습니다!");
			}
		}
	}

	private String[] prompt() {
	  out.println("멤버관리>");
	  out.println();
	  return in.nextLine().split(" ");
  }
	
	private void processRead(int no) throws Exception {
		Member member = memberDao.selectOne(no);
		
		if (member != null) {
			out.println("번호:" + member.getNo());
			out.println("이름:" + member.getName());
			out.println("나이:" + member.getAge());
			out.println("이메일:" + member.getEmail());
			out.println("전화:" + member.getTel());
			return;
		}
		
		out.println("해당 번호의 멤버를 찾을 수 없습니다!");
  }

	private void processDelete(int no) throws Exception {
		Member member = memberDao.selectOne(no);
		
		if (member != null) {
			out.println("정말 삭제하시겠습니까?(y/n)");
			out.println();
			String command = in.nextLine();
			if (command.toLowerCase().equals("y")) {
				memberDao.delete(no);
				out.println("삭제되었습니다.");
			} else {
				out.println("삭제 취소하였습니다.");
			}
			return;
		}
		
		out.println("해당 번호의 멤버를 찾을 수 없습니다!");
  }

	private void processUpdate(int no) throws Exception {
		Member temp = new Member();
		Member member = memberDao.selectOne(no);
		
		if (member != null) {
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
			temp.setNo(no);
			
			out.println("변경하시겠습니까?(y/n)");
			out.println();
			value = in.nextLine();
			
			if (value.toLowerCase().equals("y")) {
				memberDao.update(temp);
				out.println("변경 성공입니다.");
			} else {
				out.println("변경 취소하였습니다.");
			}
			return;
		}
		
		out.println("해당 번호의 멤버를 찾을 수 없습니다.");
  }

	private void processList() throws Exception {
		ArrayList<Member> members = memberDao.selectList();
		out.println("----------------------------");
		out.println("번호 \t 이름 \t 나이 \t 전화");
		out.println("----------------------------");
		
		for (Member member : members) {
			out.print(member.getNo() + "\t");
			out.print(member.getName() + "\t");
			out.print(member.getAge() + "\t");
			out.println(member.getTel());
		}
  }

	private void processAdd() throws Exception {
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
				memberDao.insert(member);
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
