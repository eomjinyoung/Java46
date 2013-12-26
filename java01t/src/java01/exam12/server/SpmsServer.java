package java01.exam12.server;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SpmsServer extends Thread {
	public static final int MENU_QUIT = 0;
	public static final int MENU_PROJECT = 1;
	public static final int MENU_MEMBER = 2;
	public static final int MENU_TASK = 3;
	
	Socket s;
	PrintStream out;
	Scanner in;
	
	public SpmsServer(Socket s) throws Exception {
		this.s = s;
		out = new PrintStream(s.getOutputStream());
		in = new Scanner(s.getInputStream());
	}
	
	@Override
	public void run() {
		try {
			String command = null;
			loop:
			while(true) {
				command = in.nextLine();
				switch(command) {
				case "hello":
				case "help":
					printMenu();
					break;
				case "1":
					processProject();
					break;
				case "0":
					out.println("goodbye");
					break loop;
				default:
					printError();	
				}
			}
			
			out.close();
			in.close();
			s.close();
		} catch (Exception e) {}
	}
	
	@SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
		System.out.println("Spms 서버가 실행되었습니다.");
		ServerSocket ss = new ServerSocket(9090);
		
		while (true) {
			new SpmsServer(ss.accept()).start();
		}
	}

	private void printError() {
		out.println("명령어가 잘못되었습니다!");
		out.println("메뉴>");
	  out.println();	 
  }

	private void processProject() {
	  ProjectController controller = new ProjectController(in, out);
	  try {
	  		controller.execute();
	  } catch (Exception e) {}
	  printMenu();
  }

	private void printMenu() {
	  out.println("[메뉴]");
	  out.println("1. 프로젝트관리");
	  out.println("2. 멤버관리");
	  out.println("3. 작업관리");
	  out.println("0. 종료");
	  out.println("메뉴>");
	  out.println();
  }
	
	
}















