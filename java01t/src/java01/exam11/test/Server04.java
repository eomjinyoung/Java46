package java01.exam11.test;

import java.net.ServerSocket;

//3. 채팅 기능 추가
public class Server04 {

	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(9090);
		
		while(true) {
			new Worker03(ss.accept()).start();
		}
	}

}













