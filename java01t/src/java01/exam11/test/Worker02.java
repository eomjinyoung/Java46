package java01.exam11.test;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Worker02 {
	Socket 			s;
	PrintStream out;
	Scanner 			in;
	Scanner 			keyboard;
	String				peerName;
	String 			myName = "엄진영";
	
	public Worker02(Socket s) throws Exception {
		this.s = s;
		out = new PrintStream(s.getOutputStream());
		in = new Scanner(s.getInputStream());
		keyboard = new Scanner(System.in);
	}
	
	public void service() throws Exception {
		String[] command = in.nextLine().split(" ");
		processHello(command[1]);
		
		String message = null;
		
		loop:
		while(true) {
			message = in.nextLine();
			
			switch(message) {
			case "quit":
				processQuit();
				break loop;
			default:
				processMessage(message);	
			}
		}
		
		System.out.println(peerName + "님이 퇴장하셨습니다!");
		
		keyboard.close();
		in.close();
		out.close();
		s.close();
	}

	private void processMessage(String message) {
	  System.out.println(peerName + ":" + message);
	  System.out.print(">");
		String myMessage = keyboard.nextLine();
	  out.println(myMessage);
  }

	private void processQuit() {
	  out.println("goodbye");
  }

	private void processHello(String name) {
		this.peerName = name;
		System.out.println(peerName + "님이 입장하였습니다!");
	  out.println("hello " + myName);
  }
}















