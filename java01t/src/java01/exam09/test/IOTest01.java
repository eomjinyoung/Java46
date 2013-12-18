package java01.exam09.test;

import java.io.FileOutputStream;

public class IOTest01 {

	public static void main(String[] args) throws Exception {
		FileOutputStream out = new FileOutputStream("test02.dat");
		byte[] bytes = new byte[]{10,20,30,40};
		out.write(bytes);
		out.close();

	}
	
	public static void main01(String[] args) throws Exception {
		FileOutputStream out = new FileOutputStream("test01.dat");
		out.write(10);
		out.write(20);
		out.write(30);
		out.write(40);
		out.close();

	}

}
