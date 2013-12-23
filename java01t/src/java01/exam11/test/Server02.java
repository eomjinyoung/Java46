package java01.exam11.test;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//2. 클라이언트 요청 반복 처리하기
public class Server02 {

	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(9090);
		
		while(true) {
			new Worker01(ss.accept()).service();
		}
	}

}













