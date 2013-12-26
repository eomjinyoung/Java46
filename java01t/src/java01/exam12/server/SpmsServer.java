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
	
	public SpmsServer(Socket s) {
		
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println("Spms 서버가 실행되었습니다.");
		ServerSocket ss = new ServerSocket(9090);
		
		s = ss.accept();
		out = new PrintStream(s.getOutputStream());
		in = new Scanner(s.getInputStream());
		
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
			case "server quit":
				out.println("goodbye");
				break loop;
			default:
				printError();	
			}
		}
		
		out.close();
		in.close();
		s.close();
		ss.close();
		System.out.println(">> Spms 서버가 종료되었습니다.");
	}

	private static void printError() {
		out.println("명령어가 잘못되었습니다!");
		out.println("메뉴>");
	  out.println();	 
  }

	private static void processProject() {
	  ProjectController controller = new ProjectController(in, out);
	  try {
	  		controller.execute();
	  } catch (Exception e) {}
	  printMenu();
  }

	private static void printMenu() {
	  out.println("[메뉴]");
	  out.println("1. 프로젝트관리");
	  out.println("2. 멤버관리");
	  out.println("3. 작업관리");
	  out.println("0. 종료");
	  out.println("메뉴>");
	  out.println();
  }
	
	
}















