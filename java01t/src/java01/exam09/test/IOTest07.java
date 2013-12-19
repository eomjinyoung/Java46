package java01.exam09.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java01.exam09.vo.Member;

// 객체를 Serialize/Deserialize 하기
// - 자바는 보안을 위해서 Serialize 할 수 있다고 선언된 객체만 Serialize 시킨다.
// - 일반 클래스에 Serialize 할 수 있게 만들고 싶다면, 다음 문법을 따른다.
//   class MyObject implments Serializable { ... }
public class IOTest07 {

	public static void main(String[] args) throws Exception {
		FileInputStream in = new FileInputStream("test07.dat");
		ObjectInputStream in2 = new ObjectInputStream(in);
		
		Member m = (Member)in2.readObject();
		System.out.println(m);
		
		in2.close();
		in.close();
	}
	
	public static void main01(String[] args) throws Exception {
		Member m = new Member();
		m.setName("홍길동");
		m.setAge(25);
		m.setEmail("hong@test.com");
		m.setTel("111-1111");
		
		FileOutputStream out = new FileOutputStream("test07.dat");
		ObjectOutputStream out2 = new ObjectOutputStream(out);
		
		out2.writeObject(m);
		
		out2.close();
		out.close();
	}

}












