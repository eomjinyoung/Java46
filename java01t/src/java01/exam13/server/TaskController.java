package java01.exam13.server;

import java.io.PrintStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import java01.exam13.server.dao.TaskDao;
import java01.exam13.server.vo.Task;

public class TaskController {
	TaskDao taskDao;
	PrintStream out;
	Scanner in;

	public TaskController(Scanner in, PrintStream out) {
		taskDao = new TaskDao();
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
	}

	private String[] prompt() {
		out.println("작업관리>");
		out.println();
		return in.nextLine().split(" ");
	}

	private void processRead(int no) throws Exception {
		Task task = taskDao.selectOne(no);
		if (task != null) {
			out.println("작업번호:" + task.getNo());
			out.println("작업명:" + task.getTitle());
			out.println("시작일:" + task.getStartDate());
			out.println("종료일:" + task.getEndDate());
			out.println("상태:" + task.getState());
			out.println("태그들:" + task.getTags());
			out.println("프로젝트번호:" + task.getProjectNo());
			out.println("작업자:");
			return;
		}
	}

	private void processDelete(int no) throws Exception {
		Task task = taskDao.selectOne(no);

		if (task != null) {
			out.println("정말 삭제하시겠습니까?(y/n)");
			out.println();
			String command = in.nextLine();
			if (command.toLowerCase().equals("y")) {
				taskDao.delete(no);
				out.println("삭제되었습니다.");
			} else {
				out.println("삭제 취소하였습니다.");
			}
			return;
		}
		out.println("해당 번호의 작업을 찾을 수 없습니다!");
	}

	private void processUpdate(int no) throws Exception {
		Task temp = new Task();
		Task task = taskDao.selectOne(no); 

		if (task != null) {
			out.println("작업명(" + task.getTitle() + "):");
			out.println();
			String value = in.nextLine();
			if (!value.equals("")) {
				temp.setTitle(value);
			} else {
				temp.setTitle(task.getTitle());
			}
			
			out.println("시작일(" + task.getStartDate() + "):");
			out.println();
			value = in.nextLine();
			if (!value.equals("")) {
				temp.setStartDate(Date.valueOf(value));
			} else {
				temp.setStartDate(task.getStartDate());
			}
			
			out.println("종료일(" + task.getEndDate() + "):");
			out.println();
			value = in.nextLine();
			if (!value.equals("")) {
				temp.setEndDate(Date.valueOf(value));
			} else {
				temp.setEndDate(task.getEndDate());
			}

			out.println("상태(" + task.getState() + "):");
			out.println();
			value = in.nextLine();
			if (!value.equals("")) {
				temp.setState( Integer.parseInt(value) );
			} else {
				temp.setState(task.getState());
			}
			
			out.println("태그들(" + task.getTags() + "):");
			out.println();
			value = in.nextLine();
			if (!value.equals("")) {
				temp.setTags(value);
			} else {
				temp.setTags(task.getTags());
			}

			out.println("프로젝트번호(" + task.getProjectNo() + "):");
			out.println();
			value = in.nextLine();
			if (!value.equals("")) {
				temp.setProjectNo( Integer.parseInt(value) );
			} else {
				temp.setProjectNo(task.getProjectNo());
			}

			temp.setNo(task.getNo());

			out.println("변경하시겠습니까?(y/n)");
			out.println();
			value = in.nextLine();

			if (value.toLowerCase().equals("y")) {
				taskDao.update(temp);
				out.println("변경 성공입니다.");
			} else {
				out.println("변경 취소하였습니다.");
			}
			return;
		}

		out.println("해당 번호의 작업을 찾을 수 없습니다.");

	}

	private void processList() throws Exception {
		ArrayList<Task> tasks = taskDao.selectList();

		out.println("----------------------------");
		out.println("번호 \t 작업명 \t 상태 \t 프로젝트번호");
		out.println("----------------------------");

		for (Task task : tasks) {
			out.print(task.getNo() + "\t");
			out.print(task.getTitle() + "\t");
			out.print(task.getState() + "\t");
			out.println(task.getProjectNo());
		}
	}

	private void processAdd() throws Exception {
		Task task = null;
		String command = null;

		do {
			task = new Task();

			out.println("프로젝트 번호:");
			out.println();
			task.setProjectNo(Integer.parseInt(in.nextLine()));

			out.println("작업명:");
			out.println();
			task.setTitle(in.nextLine());
			
			out.println("시작일:");
			out.println();
			task.setStartDate(Date.valueOf(in.nextLine()));
			
			out.println("종료일:");
			out.println();
			task.setEndDate(Date.valueOf(in.nextLine()));
			
			out.println("태그들:");
			out.println();
			task.setTags(in.nextLine());

			out.println("등록하시겠습니까?(y/n)");
			out.println();
			command = in.nextLine();

			if (command.toLowerCase().equals("y")) {
				taskDao.insert(task);
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
