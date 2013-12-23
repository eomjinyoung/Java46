package java01.exam11.test;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Worker01 {
	Socket s;
	PrintStream out;
	Scanner in;
	
	public Worker01(Socket s) throws Exception {
		this.s = s;
		out = new PrintStream(s.getOutputStream());
		in = new Scanner(s.getInputStream());
	}
	
	public void service() throws Exception {
		String[] command = in.nextLine().split(" ");
		System.out.println(command[1] + " 접속!"); // 서버 콘솔 창에 출력 
		out.println(command[1] + "님 환영합니다!"); // 클라이언트에 출력
		
		in.close();
		out.close();
		s.close();
	}
}















