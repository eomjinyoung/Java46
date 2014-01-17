package org.gradle;

public class RegTest01 {

	public static void main(String[] args) {
		String content = "DEBUG     [abcdefg]  dkdk   2013-01-1 ddddd";
		String[] words = content.split("\\s+");
		for (String w : words) {
			if (w.matches("\\d{4}-\\d{1,2}-\\d{1,2}")) {
				System.out.println(w);
			}
		}
	}
	
	public static void main01(String[] args) {
		String content = "DEBUG [abcdefg] dkdk 2013-1-1 ddddd";
		int s = content.indexOf("[");
		int e = content.indexOf("]", s);
		System.out.println(content.substring(s+1, e));

	}

}
