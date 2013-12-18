package java01.exam09.test;

import java.io.FileWriter;

public class IOTest03 {

	public static void main(String[] args) throws Exception {
		FileWriter out = new FileWriter("test03.dat");
		out.write('A');
		out.write('B');
		out.write('C');
		out.write('가');
		out.write('각');
		out.write('간');

		out.close();
	}

}
