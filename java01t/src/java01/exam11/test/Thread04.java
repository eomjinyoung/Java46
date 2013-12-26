package java01.exam11.test;

// 동기화 문제 
// - 여러 스레드가 같은 객체를 사용할 때 발생하는 문제
// - 서로 값을 변경하면서 간섭이 발생
// - Mutex: 스레드가 객체에 접근할 때 사용하는 키
// - Semaphore: 여러 개일 경우
// - Critical Region(Section): 
//				스레드가 동시에 접근했을 때 동기화 문제가 발생하는 코드들 
//	 - synchronized 
//			크리티컬 섹션을 지정하는 키워드
//			해당 블록에 오로지 하나의 스레드만 진입가능
//			관리 방식은 mutex이다.
// - Thread Safe
//			동시에 여러 스레드가 진입하더라도 문제되지 않는 코드들
//			크리티컬 섹션의 반대되는 개념
//			스레드가 공유하는 객체를 읽기 용도로만 사용.
public class Thread04 {
	
	class Account {
		double balance;
		
		public Account(double money) {
			balance = money;
		}
		
		synchronized public boolean withdraw(double money) throws Exception {
			double temp = this.balance;
			
			//int waitTime = (int)(Math.random() * 1000000);
			//for (int i = 0; i < waitTime; i++) ;
			
			temp -= money;
			
			if (temp >= 0) {
				this.balance = temp;
				return true;
				
			} else {
				return false;
			}
		}
	}
	
	class ATM extends Thread{
		String name;
		Account account;
		
		public ATM(String name, Account account) {
			this.name = name;
			this.account = account;
		}
		
		@Override
		public void run() {
			double total = 0;
			
			for (int i = 0; i < 1000; i++) {
				try {
					
	        if (account.withdraw(100))
	        		total += 100;
	        else 
	        		break;
	        	
        } catch (Exception e) {}
			}
			
			System.out.println(name + ":" + total);
		}
	}
	
	public void test() {
		Account account = new Account(100000);
		ATM a1 = new ATM("강남", account);
		ATM a2 = new ATM("양재", account);
		ATM a3 = new ATM("종로", account);
		
		a1.start();
		a2.start();
		a3.start();
	}
	
	public static void main(String[] args) {
		Thread04 app = new Thread04();
		app.test();
	}

}















