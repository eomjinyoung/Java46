package java01.exam09.test;

import java.io.FileOutputStream;

public class IOTest01 {

	public static void main(String[] args) throws Exception {
		FileOutputStream out = new FileOutputStream("test01.dat");
		out.write(10);
		out.write(20);
		out.write(30);
		out.write(40);
		out.close();

	}

}
