package java01.exam13.server;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import java01.exam12.server.vo.Task;

public class TaskController {
	ArrayList<Task> tasks;
	PrintStream out;
	Scanner in;
	
	public TaskController(Scanner in, PrintStream out) {
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
				case "update": processUpdate(
													Integer.parseInt(command[1]) ); break;
				case "delete": processDelete( 
													Integer.parseInt(command[1]) ); break;
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

	@SuppressWarnings("unchecked")
  private void load() {
		try {
			FileInputStream in = new FileInputStream("spms_task1226.dat");
			ObjectInputStream in2 = new ObjectInputStream(in);
			
			tasks = (ArrayList<Task>)in2.readObject();
			
			in2.close();
			in.close();
		} catch (Exception e) {
			out.println("파일 로딩 중 오류발생!");
			tasks = new ArrayList<Task>();
    }
	}

	private void save() {
		try {
			FileOutputStream out = new FileOutputStream("spms_task1226.dat");
			ObjectOutputStream out2 = new ObjectOutputStream(out);
			
			out2.writeObject(tasks);
			
			out2.close();
			out.close();
		} catch (Exception e) {
			out.println("저장 중 오류발생!");
		}
  }

	private String[] prompt() {
	  out.println("작업관리>");
	  out.println();
	  return in.nextLine().split(" ");
  }
	
	private void processRead(int no) {
		for (Task task : tasks) {
			if (no == task.getNo()) {
				out.println("제목:" + task.getTitle());
				out.println("상태:" + task.getState());
				return;
			}
		}
  }

	private void processDelete(int no) {
		for (Task task : tasks) {
			if (no == task.getNo()) {
				out.println("정말 삭제하시겠습니까?(y/n)");
				out.println();
				String command = in.nextLine();
				if (command.toLowerCase().equals("y")) {
					tasks.remove(task);
					out.println("삭제되었습니다.");
				} else {
					out.println("삭제 취소하였습니다.");
				}
				return;
			}
		}
		
		out.println("해당 번호의 작업을 찾을 수 없습니다!");
  }

	private void processUpdate(int no) {
		Task temp = new Task();
		Task task = null; 
		
		for (int i = 0; i < tasks.size(); i++) {
			task = tasks.get(i);
			if (no == task.getNo()) {
				
				out.println("제목(" + task.getTitle() + "):");
				out.println();
				String value = in.nextLine();
				if (!value.equals("")) {
					temp.setTitle(value);
				} else {
					temp.setTitle(task.getTitle());
				}
				
				out.println("상태(" + task.getState() + "):");
				out.println();
				value = in.nextLine();
				if (!value.equals("")) {
					temp.setState( Integer.parseInt(value) );
				} else {
					temp.setState(task.getState());
				}
				
				temp.setNo(task.getNo());
				
				out.println("변경하시겠습니까?(y/n)");
				out.println();
				value = in.nextLine();
				
				if (value.toLowerCase().equals("y")) {
					tasks.set(i, temp);
					out.println("변경 성공입니다.");
				} else {
					out.println("변경 취소하였습니다.");
				}
				return;
			}
		}
		
		out.println("해당 번호의 작업을 찾을 수 없습니다.");
	  
  }

	private void processList() {
		out.println("----------------------------");
		out.println("번호 \t 작업명 \t 상태");
		out.println("----------------------------");
		
		for (Task task : tasks) {
			out.print(task.getNo() + "\t");
			out.print(task.getTitle() + "\t");
			out.println(task.getState());
		}
  }

	private void processAdd() {
		Task task = null;
		String command = null;
		
		do {
			task = new Task();
			
			out.println("번호:");
			out.println();
			task.setNo(Integer.parseInt(in.nextLine()));
			
			out.println("제목:");
			out.println();
			task.setTitle(in.nextLine());
			
			out.println("상태:");
			out.println();
			task.setState(Integer.parseInt(in.nextLine()));
			
			out.println("등록하시겠습니까?(y/n)");
			out.println();
			command = in.nextLine();
			
			if (command.toLowerCase().equals("y")) {
				tasks.add(task);
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
