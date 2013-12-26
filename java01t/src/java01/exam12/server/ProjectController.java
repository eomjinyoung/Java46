package java01.exam12.server;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;
import java01.exam12.server.vo.Project;

public class ProjectController {
	ArrayList<Project> projects;
	PrintStream out;
	Scanner in;
	
	public ProjectController(Scanner in, PrintStream out) {
		this.in = in;
		this.out = out;
	}
	
	public void execute() {
		load();
		
		String[] command = null;
		loop:
		while(true) {
			command = prompt();
			
			try {
				switch(command[0]) {
				case "add": processAdd(); break;
				case "list": processList(); break;
				case "update": 
					processUpdate(Integer.parseInt(command[1]) ); 
					break;
				case "delete": 
					processDelete(Integer.parseInt(command[1]) ); 
					break;
				case "read": processRead(Integer.parseInt(command[1]) ); break;
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

	private String[] prompt() {
	  out.println("프로젝트관리>");
	  out.println();
	  return in.nextLine().split(" ");
  }	

	@SuppressWarnings("unchecked")
  private void load() {
		try {
			FileInputStream in = new FileInputStream("spms_project1226.dat");
			ObjectInputStream in2 = new ObjectInputStream(in);
			
			projects = (ArrayList<Project>)in2.readObject();
			
			in2.close();
			in.close();
		} catch (Exception e) {
			System.out.println("파일 로딩 중 오류발생!");
			projects = new ArrayList<Project>();
    }
	}

	private void save() {
		try {
			FileOutputStream out = new FileOutputStream("spms_project1226.dat");
			ObjectOutputStream out2 = new ObjectOutputStream(out);
			
			out2.writeObject(projects);
			
			out2.close();
			out.close();
		} catch (Exception e) {
			System.out.println("저장 중 오류발생!");
		}
  }
	
	private void processList() {
		out.println("----------------------------");
		out.println("번호 \t 프로젝트 \t 시작일 \t 종료일 \t 상태");
		out.println("----------------------------");
		
		for (Project project : projects) {
			out.print(project.getNo() + "\t");
			out.print(project.getTitle() + "\t");
			out.print(project.getStartDate() + "\t");
			out.print(project.getEndDate() + "\t");
			out.println(project.getState());
		}
  }
	
	private void processAdd() {
		Project project = null;
		String command = null;
		
		do {
			project = new Project();
			
			out.println("번호:"); out.println();
			project.setNo(Integer.parseInt(in.nextLine()));
			
			out.println("제목:"); out.println();
			project.setTitle(in.nextLine());
			
			out.println("시작일:"); out.println();
			project.setStartDate( Date.valueOf(in.nextLine()) );
					
			out.println("종료일:"); out.println();
			project.setEndDate( Date.valueOf(in.nextLine()) );
			
			out.println("상태:"); out.println();
			project.setState(Integer.parseInt(in.nextLine()));
			
			out.println("내용:"); out.println();
			project.setDescription( in.nextLine() );
			
			out.println("등록하시겠습니까?(y/n)"); out.println();
			command = in.nextLine();
			
			if (command.toLowerCase().equals("y")) {
				projects.add(project);
				out.println("등록 성공입니다.");
			} else {
				out.println("등록 취소하였습니다.");
			}
			
			out.println("계속하시겠습니까?(y/n)"); out.println();
			command = in.nextLine();
		} while (command.toLowerCase().equals("y"));
  }
	
	private void processUpdate(int no) {
		Project temp = new Project();
		Project project = null; 
		
		for (int i = 0; i < projects.size(); i++) {
			project = projects.get(i);
			
			if (no == project.getNo()) {
				out.println("제목(" + project.getTitle() + "):");
				out.println();
				String value = in.nextLine();
				if (!value.equals("")) {
					temp.setTitle(value);
				} else {
					temp.setTitle(project.getTitle());
				}
				
				out.println("시작일(" + project.getStartDate() + "):");
				out.println();
				value = in.nextLine();
				if (!value.equals("")) {
					temp.setStartDate( Date.valueOf(value) );
				} else {
					temp.setStartDate( project.getStartDate() );
				}
				
				out.println("종료일(" + project.getEndDate() + "):");
				out.println();
				value = in.nextLine();
				if (!value.equals("")) {
					temp.setEndDate( Date.valueOf(value) );
				} else {
					temp.setEndDate( project.getEndDate() );
				}
				
				out.println("상태(" + project.getState() + "):");
				out.println();
				value = in.nextLine();
				if (!value.equals("")) {
					temp.setState( Integer.parseInt(value) );
				} else {
					temp.setState(project.getState());
				}
				
				out.println("내용(" + project.getDescription() + "):");
				out.println();
				value = in.nextLine();
				if (!value.equals("")) {
					temp.setDescription( value );
				} else {
					temp.setDescription(project.getDescription());
				}
				
				temp.setNo(project.getNo());
				
				out.println("변경하시겠습니까?(y/n)");
				out.println();
				value = in.nextLine();
				
				if (value.toLowerCase().equals("y")) {
					projects.set(i, temp);
					out.println("변경 성공입니다.");
				} else {
					out.println("변경 취소하였습니다.");
				}
				return;
			}
		}
		out.println("해당 번호의 프로젝트를 찾을 수 없습니다.");
  }

	private void processRead(int no) {
		for (Project project : projects) {
			if (no == project.getNo()) {
				out.println("제목:" + project.getTitle());
				out.println("시작일:" + project.getStartDate());
				out.println("종료일:" + project.getEndDate());
				out.println("상태:" + project.getState());
				out.println("내용:" + project.getDescription());
				return;
			}
		}
		out.println("해당 번호의 프로젝트를 찾을 수 없습니다.");
  }
	
	private void processDelete(int no) {
		for (Project project : projects) {
			if (no == project.getNo()) {
				out.println("정말 삭제하시겠습니까?(y/n)");
				out.println();
				String command = in.nextLine();
				if (command.toLowerCase().equals("y")) {
					projects.remove(project);
					out.println("삭제되었습니다.");
				} else {
					out.println("삭제 취소하였습니다.");
				}
				return;
			}
		}
		
		out.println("해당 번호의 프로젝트를 찾을 수 없습니다!");
  }

}












