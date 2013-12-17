package java01.exam07.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.SynchronousQueue;

// Collection 다루기
public class Test06 {
	//4. Queue
	public static void main(String[] args) {
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
