package java01.exam10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import java01.exam10.vo.Project;

public class ProjectController {
	ArrayList<Project> projects;
	Scanner scanner;
	
	public ProjectController(Scanner scanner) {
		this.scanner = scanner;
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
				case "update": processUpdate(
													Integer.parseInt(command[1]) ); break;
				case "delete": processDelete( 
													Integer.parseInt(command[1]) ); break;
				case "read": processRead(Integer.parseInt(command[1]) ); break;
				case "quit": break loop;
				default:
					System.out.println("사용할 수 없는 명령어입니다.");
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("명령어 실행 중 오류가 발생했습니다!");
			}
		}
		save();
	}

	@SuppressWarnings("unchecked")
  private void load() {
		try {
			FileInputStream in = new FileInputStream("project04.dat");
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
			FileOutputStream out = new FileOutputStream("project04.dat");
			ObjectOutputStream out2 = new ObjectOutputStream(out);
			
			out2.writeObject(projects);
			
			out2.close();
			out.close();
		} catch (Exception e) {
			System.out.println("저장 중 오류발생!");
		}
  }

	private void processRead(int no) {
		for (Project project : projects) {
			if (no == project.getNo()) {
				System.out.println("제목:" + project.getTitle());
				System.out.println("시작일:" + project.getStartDate());
				System.out.println("종료일:" + project.getEndDate());
				System.out.println("상태:" + project.getState());
				System.out.println("설명:" + project.getDescription());
				return;
			}
		}
  }

	private void processDelete(int no) {
		for (Project project : projects) {
			if (no == project.getNo()) {
				System.out.print("정말 삭제하시겠습니까?(y/n)");
				String command = scanner.nextLine();
				if (command.toLowerCase().equals("y")) {
					projects.remove(project);
					System.out.println("삭제되었습니다.");
				} else {
					System.out.println("삭제 취소하였습니다.");
				}
				return;
			}
		}
		
		System.out.println("해당 이메일의 멤버를 찾을 수 없습니다!");
  }

	private void processUpdate(int no) {
		Project temp = new Project();
		Project project = null; 
		
		for (int i = 0; i < projects.size(); i++) {
			project = projects.get(i);
			if (no == project.getNo()) {
				
				System.out.print("제목(" + project.getTitle() + "):");
				String value = scanner.nextLine();
				if (!value.equals("")) {
					temp.setTitle(value);
				} else {
					temp.setTitle(project.getTitle());
				}
				
				System.out.print("시작일(" + project.getStartDate() + "):");
				value = scanner.nextLine();
				if (!value.equals("")) {
					temp.setStartDate( Date.valueOf(value) );
				} else {
					temp.setStartDate( project.getStartDate() );
				}
				
				System.out.print("종료일(" + project.getEndDate() + "):");
				value = scanner.nextLine();
				if (!value.equals("")) {
					temp.setEndDate( Date.valueOf(value) );
				} else {
					temp.setEndDate( project.getEndDate() );
				}
				
				System.out.print("상태(" + project.getState() + "):");
				value = scanner.nextLine();
				if (!value.equals("")) {
					temp.setState( Integer.parseInt(value) );
				} else {
					temp.setState(project.getState());
				}
				
				temp.setNo(project.getNo());
				
				System.out.print("변경하시겠습니까?(y/n)");
				value = scanner.nextLine();
				
				if (value.toLowerCase().equals("y")) {
					projects.set(i, temp);
					System.out.println("변경 성공입니다.");
				} else {
					System.out.println("변경 취소하였습니다.");
				}
				return;
			}
		}
		
		System.out.println("해당 이메일의 멤버를 찾을 수 없습니다.");
	  
  }

	private void processList() {
		System.out.println("----------------------------");
		System.out.println("번호 \t 프로젝트 \t 시작일 \t 종료일 \t 상태");
		System.out.println("----------------------------");
		
		for (Project project : projects) {
			System.out.print(project.getNo() + "\t");
			System.out.print(project.getTitle() + "\t");
			System.out.print(project.getStartDate() + "\t");
			System.out.print(project.getEndDate() + "\t");
			System.out.println(project.getState());
		}
  }

	private void processAdd() {
		Project project = null;
		String command = null;
		
		do {
			project = new Project();
			
			System.out.print("번호:");
			project.setNo(Integer.parseInt(scanner.nextLine()));
			
			System.out.print("제목:");
			project.setTitle(scanner.nextLine());
			
			System.out.print("시작일:");
			project.setStartDate( Date.valueOf(scanner.nextLine()) );
					
			System.out.print("종료일:");
			project.setEndDate( Date.valueOf(scanner.nextLine()) );
			
			System.out.print("상태:");
			project.setState(Integer.parseInt(scanner.nextLine()));
			
			System.out.print("내용:");
			project.setDescription( scanner.nextLine() );
			
			System.out.print("등록하시겠습니까?(y/n)");
			command = scanner.nextLine();
			
			if (command.toLowerCase().equals("y")) {
				projects.add(project);
				System.out.println("등록 성공입니다.");
			} else {
				System.out.println("등록 취소하였습니다.");
			}
			
			System.out.print("계속하시겠습니까?(y/n)");
			command = scanner.nextLine();
		} while (command.toLowerCase().equals("y"));
  }

	private String[] prompt() {
	  System.out.print("프로젝트관리>");
	  return scanner.nextLine().split(" ");
  }	
}
