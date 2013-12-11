package java01.basic;

public class Test01 {
	public static void main(String[] args) {
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








