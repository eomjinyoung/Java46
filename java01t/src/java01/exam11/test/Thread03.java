package java01.exam11.test;

// ThreadGroup과 Thread
public class Thread03 {

	public static void main(String[] args) {
		Thread t = Thread.currentThread();
		System.out.println(t.getName());
		
		ThreadGroup mainTG = t.getThreadGroup();
		System.out.println(mainTG.getName());
		
		ThreadGroup systemTG = mainTG.getParent();
		System.out.println(systemTG.getName());
		
		ThreadGroup[] gl = new ThreadGroup[100];
		int len = systemTG.enumerate(gl, false);
		for (int i = 0; i < len; i++) {
			System.out.println("  (TG) " + gl[i].getName());
		}
		
		Thread[] tl = new Thread[100];
		len = systemTG.enumerate(tl, false);
		for (int i = 0; i < len; i++) {
			System.out.println("  [T] " + tl[i].getName());
		}
		
		len = mainTG.enumerate(tl, false);
		for (int i = 0; i < len; i++) {
			System.out.println("  mainTG: [T] " + tl[i].getName());
		}
	}

}







