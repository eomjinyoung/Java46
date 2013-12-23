package java01.exam11.test;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

//2. Server03과 연동하는 클라이언트
public class Client02 {

	public static void main(String[] args) throws Exception {
		Socket s = new Socket("localhost", 9090);
		PrintStream out = new PrintStream(s.getOutputStream());
		Scanner in = new Scanner(s.getInputStream());
		Scanner keyboard = new Scanner(System.in);
		
		out.println("hello 엄진영");
		String serverName = in.nextLine().split(" ")[1];
		
		String  serverMessage = null;
		while(true) {
			System.out.print(">");
			out.println(keyboard.nextLine());
			serverMessage = in.nextLine();
			System.out.println(serverName + ":" + serverMessage);
			if (serverMessage.equals("goodbye")) break;
		}
		
		keyboard.close();
		in.close();
		out.close();
		s.close();
	}

}









