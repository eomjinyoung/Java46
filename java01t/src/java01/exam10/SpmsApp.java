package java01.exam10;

import java.util.Scanner;

public class SpmsApp {
	public static final int MENU_QUIT = 0;
	public static final int MENU_PROJECT = 1;
	public static final int MENU_MEMBER = 2;
	public static final int MENU_TASK = 3;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		ProjectController projectController = new ProjectController(scanner);
		MemberController memberController = new MemberController(scanner);
		
		loop:
		while(true) {
			printMenu();
			
			try {
				switch(prompt(scanner)) {
				case MENU_PROJECT: projectController.execute(); break;
				case MENU_MEMBER: memberController.execute(); break;
				case MENU_QUIT: break loop;
				default:
					System.out.println("그런 메뉴 없습니다.");
				}
			} catch (Exception e) {
				System.out.println("명령어 실행 중 오류가 발생했습니다!");
			}
		}
		scanner.close();
	}

	private static void printMenu() {
	  System.out.println("[메뉴]");
	  System.out.println("1. 프로젝트관리");
	  System.out.println("2. 멤버관리");
	  System.out.println("3. 작업관리");
	  System.out.println("0. 종료");
  }

	private static int prompt(Scanner scanner) {
	  System.out.print("선택>");
	  return Integer.parseInt(scanner.nextLine());
  }
}















