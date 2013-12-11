package java01.basic;

public class Test01 {
	public static void main(String[] args) {
		int i = 2, j = 1;
		
		while (i < 10) {
			j = 1;
			while (j < 10) {
				if ((j % 2) == 0) {
					j++;
					continue;
				}
				
				if (j > 7) {
					break;
				}
				
				System.out.println(i + "*" + j + "=" + (i*j));
				j++;
			}
			i++;
		}
	}
	
	public static void main06(String[] args) {
		int level = 2;
		
		// switch value : 4byte 정수 값, 문자열 가능
		switch(level) {
		case 1:
			System.out.println("관리자입니다.");
			break;
		case 2:
			System.out.println("정회원입니다.");
			break;
		case 3:
			System.out.println("일반회원입니다.");
			break;
		case 4:
			System.out.println("손님입니다.");
			break;
		default:
			System.out.println("권한이 없습니다.");
		}
	}
	
	public static void main05(String[] args) {
		int a = 20;
		if (a > 20) 
			if (a == 20)
				System.out.println("20");
		else
			System.out.println("ok");
	}
	
	public static void main04(String[] args) {
		int age = 43;
		
		if (age > 0 && age <= 18) {
			System.out.println("청소년!");
		} else if (age > 18 && age <= 30) {
			System.out.println("청년!");
		} else if (age > 30 && age <= 50) {
			System.out.println("장년!");
		} else if (age > 50 && age <= 60) {
			System.out.println("중년!");
		} else {
			System.out.println("노인!");
		}
	}
	
	public static void main03(String[] args) {
		int age = 43;
		
		if (age > 0 && age <= 18) {
			System.out.println("청소년!");
		} else {
			if (age > 18 && age <= 30) {
				System.out.println("청년!");
			} else {
				if (age > 30 && age <= 50) {
					System.out.println("장년!");
				} else {
					if (age > 50 && age <= 60) {
						System.out.println("중년!");
					} else {
						System.out.println("노인!");
					}
				}
			}
		}
	}
	
	public static void main02(String[] args) {
		int a = 3;
    if ( a > 4) {
            System.out.println("a > 4 입니다.");
            System.out.println("종료합니다!");
    }
  }
	
	public static void main01(String[] args) {
    final int READ = 0x01;		// ... 0001
    final int WRITE = 0x02; 	// ... 0010
    final int DEL = 0x04;		// ... 0100
    
    int p1 = READ; 
    int p2 = READ | WRITE;
    int p3 = READ | DEL;
    int p4 = READ | WRITE | DEL;
    
    int x = p4;
    
    if ((x & READ) == READ) {
    		System.out.println("읽기OK");
    } 
    
    if ((x & WRITE) == WRITE) {
  			System.out.println("쓰기OK");
    } 
    
    if ((x & DEL) == DEL) {
			System.out.println("삭제OK");
    }
    
    
	}

}








