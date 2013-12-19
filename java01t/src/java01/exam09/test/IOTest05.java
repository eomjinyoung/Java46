package java01.exam09.test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

// 입력 시 버퍼의 사용 이점
// - 데이터 읽기 시간 = 평균 탐색 시간 + 데이터 전송 시간
// - 평균 탐색 시간이 많이 소요된다.
// - 가능한 읽을 때 한 번에 왕창 읽는 것이 좋다.
// - 이런 버퍼링을 처리하는 클래스 BufferedXXX 클래스
@SuppressWarnings("unused")
public class IOTest05 {

  public static void main(String[] args) throws Exception {
		FileInputStream in = new FileInputStream("aaa.zip");
		BufferedInputStream in2 = new BufferedInputStream(in);
		
		long startTime = System.currentTimeMillis(); // 1970.1.1 0:0:0 ms
		
		int b;
		while( (b = in2.read()) != -1) {}
		
		long endTime = System.currentTimeMillis();
		
		in2.close();
		in.close();
		
		System.out.println(endTime - startTime);
	}
	
	public static void main02(String[] args) throws Exception {
		FileInputStream in = new FileInputStream("aaa.zip");
		
		long startTime = System.currentTimeMillis(); // 1970.1.1 0:0:0 ms
		
		byte[] buf = new byte[4096];
		int len;
		while( (len = in.read(buf)) != -1) {}
		
		long endTime = System.currentTimeMillis();
		
		in.close();
		
		System.out.println(endTime - startTime);
		
	}
	
	public static void main01(String[] args) throws Exception {
		FileInputStream in = new FileInputStream("aaa.zip");
		
		long startTime = System.currentTimeMillis(); // 1970.1.1 0:0:0 ms
		
		int b;
		while( (b = in.read()) != -1) {}
		
		long endTime = System.currentTimeMillis();
		
		in.close();
		
		System.out.println(endTime - startTime);
		
	}

}



