package java01.exam06;

public class StringTest01 /*extends Object*/ {
	public static void main(String[] args) {
		StringBuffer s1 = new StringBuffer("Hello");
		StringBuffer s2 = new StringBuffer("Hello");
		
		if (s1 == s2) System.out.println("s1 == s2");
		if (s1.equals(s2)) System.out.println("s1.equals(s2)");
		
		String s3 = new String("Hello");
		String s4 = new String("Hello");
		if (s3 == s4) System.out.println("s3 == s4");
		if (s3.equals(s4)) System.out.println("s3.equals(s4)");
	}
	
	public static void main04(String[] args) {
		StringBuffer s1 = new StringBuffer("Hello");
		StringBuffer s2 = s1.replace(2, 4, "xxxxx");
		StringBuffer s3 = s1.append(", world!");
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		if (s1 == s2) System.out.println("s1 == s2");
	}
	
	public static void main03(String[] args) {
		String s1 = new String("Hello");
		String s2 = s1.replace('l', 'x');
		String s3 = s1.concat(", world!");
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	}
	
	public static void main02(String[] args) {
		String s1 = new String("Hello");
		String s2 = "Hello";
		String s3 = "Hello";
		String s4 = new String("Hello");
		
		if (s1 == s2) System.out.println("s1 == s2");//false
		if (s1 == s3) System.out.println("s1 == s3");//false
		if (s1 == s4) System.out.println("s1 == s4");//false
		if (s2 == s3) System.out.println("s2 == s3");//true
		if (s1.equals(s2)) System.out.println("s1.equals(s3)");//true
	}
	
	public static void main01(String[] args) {
		String s1 = new String("Hello");
		String s2 = new String("Hello");
		String s3 = s1;
		s1 = new String("Hello");
		s3 = s1;
		
		if (s1.equals(s2)) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
	}

}
