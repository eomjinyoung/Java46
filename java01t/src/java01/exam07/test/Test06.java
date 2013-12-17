package java01.exam07.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.SynchronousQueue;

// Collection 다루기
public class Test06 {
	//6. Map: Hashtable
	// - key 또는 value에 null을 허용 안함.
	// - 동기화시킴. => 데이터를 꺼내는 중에도 새로 입력된 데이터를 꺼낼 수 있다.
	// - HashMap 보다 속도 느리다.
	public static void main(String[] args) {
		Hashtable names = new Hashtable();
		names.put("100", "홍길동");
		names.put("200", "일지매");
		names.put("300", "똘이장군");
		names.put("400", "주먹대장");
		names.put("500", "홍길동");
		names.put("600", "일지매");
		names.put("700", null);
		
		System.out.println( names.get("100") );
		System.out.println( names.get("600") );
		System.out.println( names.get("700") );
	}
	
	//5. Map
	// - key 또는 value에 null 허용
	// - 데이터를 꺼내는 중에는 새로운 데이터가 추가되더라도 무시한다.
	public static void main05(String[] args) {
		HashMap names = new HashMap();
		names.put("100", "홍길동");
		names.put("200", "일지매");
		names.put("300", "똘이장군");
		names.put("400", "주먹대장");
		names.put("500", "홍길동");
		names.put("600", "일지매");
		names.put("700", null);
		
		System.out.println( names.get("100") );
		System.out.println( names.get("600") );
		System.out.println( names.get("700") );
	}
	
	//4. Queue
	public static void main04(String[] args) {
		ConcurrentLinkedQueue names = new ConcurrentLinkedQueue();
		names.add("홍길동");
		names.add("일지매");
		names.add("똘이장군");
		names.add("주먹대장");
		names.add("홍길동");
		names.add("일지매");
		
		while (0 < names.size()) {
			System.out.println(names.poll());
		}
	}
	
	//3. Stack
	public static void main03(String[] args) {
		Stack names = new Stack();
		names.push("홍길동");
		names.push("일지매");
		names.push("똘이장군");
		names.push("주먹대장");
		names.push("홍길동");
		names.push("일지매");
		
		while (0 < names.size()) {
			System.out.println(names.pop());
		}
	}
	
	//2. HashSet
	public static void main02(String[] args) {
		HashSet names = new HashSet();
		names.add("홍길동");
		names.add("일지매");
		names.add("똘이장군");
		names.add("주먹대장");
		names.add("홍길동");
		names.add("일지매");
		
		Object[] nameList = names.toArray();
		for (int i = 0; i < nameList.length; i++) {
			System.out.println(nameList[i]);
		}
		
	}
	
	//1. ArrayList
	public static void main01(String[] args) {
		ArrayList names = new ArrayList();
		names.add("홍길동");
		names.add("일지매");
		names.add("똘이장군");
		names.add("주먹대장");
		names.add("홍길동");
		names.add("일지매");
		
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
		
	}

}
