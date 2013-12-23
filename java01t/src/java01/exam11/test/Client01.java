package java01.exam11.test;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client01 {

	public static void main(String[] args) throws Exception {
		//1) 소켓 생성 및 서버에 접속
		// - localhost => 현재 App이 실행되고 있는 PC => 127.0.0.1
		// - 서버와 연결되면 리턴.
		Socket s = new Socket("localhost", 9090);
		
		//2) 입력, 출력을 위한 도구 준비
		OutputStream out = s.getOutputStream();
		PrintStream out2 = new PrintStream(out);
	  
		InputStream in = s.getInputStream();
		Scanner in2 = new Scanner(in);
		
		//3) 서버에 요청
		out2.println("hello 엄진영");
		
		//4) 서버에서 보낸 데이터 읽기
		String message = in2.nextLine();
		
		//5) 서버에서 보낸 데이터를 화면에 출력
		System.out.println(message);
		
		in2.close();
		in.close();
		out2.close();
		out.close();
		s.close();
		
	}

}









