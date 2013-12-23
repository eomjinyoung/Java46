package java01.exam11.test;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//3. 채팅 기능 추가
public class Server03 {

	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(9090);
		
		while(true) {
			new Worker02(ss.accept()).service();
		}
	}

}













