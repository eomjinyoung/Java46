package java01.exam11.test;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Worker03 extends Thread {
	Socket 			s;
	PrintStream out;
	Scanner 			in;
	Scanner 			keyboard;
	String				peerName;
	String 			myName = "엄진영";
	
	public Worker03(Socket s) throws Exception {
		this.s = s;
		out = new PrintStream(s.getOutputStream());
		in = new Scanner(s.getInputStream());
		keyboard = new Scanner(System.in);
	}
	
	//run() 프로세스와는 별개로 실행되어야 하는 명령어를 묶음
	@Override
	public void run() {
		try {
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
			
		} catch (Exception e) {}
	}

	private void processMessage(String message) {
	  System.out.println(peerName + ":" + message);
	  //System.out.print(">");
		//String myMessage = keyboard.nextLine();
	  //out.println(myMessage);
	  out.println(message + ">>> 헐...그렇군요..");
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















