package java01.exam11.test;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//1. 서버 만들기
public class Server01 {

	public static void main(String[] args) throws Exception {
		//1) 서버 소켓 생성
		// - 클라이언트의 접속 요청을 받는 역할.
		// - 승인 후 클라이언트와 통신할 소켓을 생성하는 역할.
		ServerSocket ss = new ServerSocket(9090);
		
		//2) 클라이언트 대기자 목록에서 하나를 승인 
		// - 대기하고 있는 클라이언트가 없다면 블록킹(기다린다) 됨.
		// - 승인되면 클라이언트와 대화를 나눌 수 있는 소켓을 리턴함.
		Socket s = ss.accept();
		
		//3) 입력, 출력을 위한 도구 준비
		OutputStream out = s.getOutputStream();
		PrintStream out2 = new PrintStream(out);
	  
		InputStream in = s.getInputStream();
		Scanner in2 = new Scanner(in);
		
		//4) 클라이언트 요청 내용 읽기
		String[] command = in2.nextLine().split(" ");
		System.out.println(command[1] + " 접속!"); // 서버 콘솔 창에 출력 
		out2.println(command[1] + "님 환영합니다!"); // 클라이언트에 출력
		
		in2.close();
		in.close();
		out2.close();
		out.close();
		s.close();
		ss.close();
	}

}













