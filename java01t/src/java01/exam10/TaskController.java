package java01.exam10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java01.exam10.vo.Task;

public class TaskController {
	ArrayList<Task> tasks;
	Scanner scanner;
	
	public TaskController(Scanner scanner) {
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
			FileInputStream in = new FileInputStream("task04.dat");
			ObjectInputStream in2 = new ObjectInputStream(in);
			
			tasks = (ArrayList<Task>)in2.readObject();
			
			in2.close();
			in.close();
		} catch (Exception e) {
			System.out.println("파일 로딩 중 오류발생!");
			tasks = new ArrayList<Task>();
    }
	}

	private void save() {
		try {
			FileOutputStream out = new FileOutputStream("task04.dat");
			ObjectOutputStream out2 = new ObjectOutputStream(out);
			
			out2.writeObject(tasks);
			
			out2.close();
			out.close();
		} catch (Exception e) {
			System.out.println("저장 중 오류발생!");
		}
  }

	private void processRead(int no) {
		for (Task task : tasks) {
			if (no == task.getNo()) {
				System.out.println("제목:" + task.getTitle());
				System.out.println("상태:" + task.getState());
				return;
			}
		}
  }

	private void processDelete(int no) {
		for (Task task : tasks) {
			if (no == task.getNo()) {
				System.out.print("정말 삭제하시겠습니까?(y/n)");
				String command = scanner.nextLine();
				if (command.toLowerCase().equals("y")) {
					tasks.remove(task);
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
		Task temp = new Task();
		Task task = null; 
		
		for (int i = 0; i < tasks.size(); i++) {
			task = tasks.get(i);
			if (no == task.getNo()) {
				
				System.out.print("제목(" + task.getTitle() + "):");
				String value = scanner.nextLine();
				if (!value.equals("")) {
					temp.setTitle(value);
				} else {
					temp.setTitle(task.getTitle());
				}
				
				System.out.print("상태(" + task.getState() + "):");
				value = scanner.nextLine();
				if (!value.equals("")) {
					temp.setState( Integer.parseInt(value) );
				} else {
					temp.setState(task.getState());
				}
				
				temp.setNo(task.getNo());
				
				System.out.print("변경하시겠습니까?(y/n)");
				value = scanner.nextLine();
				
				if (value.toLowerCase().equals("y")) {
					tasks.set(i, temp);
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
		System.out.println("번호 \t 작업명 \t 상태");
		System.out.println("----------------------------");
		
		for (Task task : tasks) {
			System.out.print(task.getNo() + "\t");
			System.out.print(task.getTitle() + "\t");
			System.out.println(task.getState());
		}
  }

	private void processAdd() {
		Task task = null;
		String command = null;
		
		do {
			task = new Task();
			
			System.out.print("번호:");
			task.setNo(Integer.parseInt(scanner.nextLine()));
			
			System.out.print("제목:");
			task.setTitle(scanner.nextLine());
			
			System.out.print("상태:");
			task.setState(Integer.parseInt(scanner.nextLine()));
			
			System.out.print("등록하시겠습니까?(y/n)");
			command = scanner.nextLine();
			
			if (command.toLowerCase().equals("y")) {
				tasks.add(task);
				System.out.println("등록 성공입니다.");
			} else {
				System.out.println("등록 취소하였습니다.");
			}
			
			System.out.print("계속하시겠습니까?(y/n)");
			command = scanner.nextLine();
		} while (command.toLowerCase().equals("y"));
  }

	private String[] prompt() {
	  System.out.print("명령>");
	  return scanner.nextLine().split(" ");
  }	
}
