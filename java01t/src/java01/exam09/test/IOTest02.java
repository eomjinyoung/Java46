package java01.exam09.test;

import java.io.FileInputStream;

public class IOTest02 {

	public static void main(String[] args) throws Exception {
		FileInputStream in = new FileInputStream("test02.dat");
		byte[] bytes = new byte[1024];
		
		int len = in.read(bytes);
		for (int i = 0; i < len; i++) {
			System.out.println(bytes[i]);
		}
		
		in.close();
	}
	
	public static void main01(String[] args) throws Exception {
		FileInputStream in = new FileInputStream("test01.dat");
		System.out.println(in.read());
		System.out.println(in.read());
		System.out.println(in.read());
		System.out.println(in.read());
		
		in.close();
	}

}
