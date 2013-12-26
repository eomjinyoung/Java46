package java01.exam12.client;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

//2. Server03과 연동하는 클라이언트
public class SpmsClient {

	public static void main(String[] args) throws Exception {
		Socket s = new Socket("localhost", 9090);
		PrintStream out = new PrintStream(s.getOutputStream());
		Scanner in = new Scanner(s.getInputStream());
		Scanner keyboard = new Scanner(System.in);
		
		out.println("hello");
		
		String  serverMessage = null;
		while(true) {
			serverMessage = in.nextLine();
			if (serverMessage.equals("")) {
				out.println(keyboard.nextLine());
				
			} if (serverMessage.equals("goodbye")) {
				break;
				
			} else {
				System.out.println(serverMessage);
			}
		}
		
		keyboard.close();
		in.close();
		out.close();
		s.close();
	}

}









