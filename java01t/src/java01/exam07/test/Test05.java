package java01.exam07.test;

import java01.exam07.vo.Member;

public class Test05 {
	public static void main(String[] args) {
		Member m1 = new Member();
		m1.setName("홍길동");
		m1.setAge(20);
		m1.setEmail("hong@test.com");
		m1.setTel("111-1111");
		
		Member m2 = new Member();
		m2.setName("홍길동");
		m2.setAge(20);
		m2.setEmail("hong@test.com");
		m2.setTel("111-1111");
		
		if (m1 == m2) 
			System.out.println("m1 == m2");
		
		if (m1.equals(m2))
			System.out.println("m1.equals(m2)");
		
	}
}
















