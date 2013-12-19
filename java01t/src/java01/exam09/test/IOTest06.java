package java01.exam09.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java01.exam09.vo.Member;

// 기본 데이터형을 바이트 배열로 변환해 주는 클래스: 
// - DataOutputStream, DataInputStream
public class IOTest06 {

	public static void main02(String[] args) throws Exception {
		FileInputStream in = new FileInputStream("test06.dat");
		int value = 0;
		
		value |= in.read() << 24;
		value |= in.read() << 16;
		value |= in.read() << 8;
		value |= in.read();
				
		in.close();
		
		System.out.println(Integer.toHexString(value));
	}
	
	public static void main01(String[] args) throws Exception {
		FileOutputStream out = new FileOutputStream("test06.dat");
		int value = 0x74983B1A;
		
		out.write(value >> 24);
		out.write(value >> 16);
		out.write(value >> 8);
		out.write(value);
		
		out.close();
	}
	
	public static void main03(String[] args) throws Exception {
		Member m = new Member();
		m.setName("홍길동");
		m.setAge(25);
		m.setEmail("hong@test.com");
		m.setTel("111-1111");
		
		FileOutputStream out = new FileOutputStream("test06.dat");
		DataOutputStream out2 = new DataOutputStream(out);
		
		out2.writeUTF(m.getName());
		out2.writeInt(m.getAge());
		out2.writeUTF(m.getEmail());
		out2.writeUTF(m.getTel());
		
		out2.close();
		out.close();
	}

	public static void main(String[] args) throws Exception {
		FileInputStream in = new FileInputStream("test06.dat");
		DataInputStream in2 = new DataInputStream(in);
		
		Member m = new Member();
		m.setName( in2.readUTF() );
		m.setAge( in2.readInt() );
		m.setEmail( in2.readUTF() );
		m.setTel( in2.readUTF() );
		
		System.out.println(m);
		
		in2.close();
		in.close();
	}
}












