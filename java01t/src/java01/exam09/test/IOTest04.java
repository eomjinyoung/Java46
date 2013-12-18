package java01.exam09.test;

import java.io.FileInputStream;
import java.io.FileReader;

public class IOTest04 {

	public static void main(String[] args) throws Exception {
		FileInputStream in = new FileInputStream("test03.dat");
		
		int ch;
		while ( (ch = in.read()) != -1) {
			System.out.println( Integer.toHexString(ch) );
		}
		
		in.close();
	}
	
	public static void main01(String[] args) throws Exception {
		FileReader in = new FileReader("test03.dat");
		
		int ch;
		while ( (ch = in.read()) != -1) {
			System.out.println( Integer.toHexString(ch) );
		}
		
		in.close();
	}

}









