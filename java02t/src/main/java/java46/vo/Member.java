package java46.vo;

import java.util.Map;
import java.util.Properties;

public class Member {
	String 	name;
	int			age;
	Map<String,String> tels;
	Properties emails;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Map<String, String> getTels() {
		return tels;
	}
	public void setTels(Map<String, String> tels) {
		this.tels = tels;
	}
	public Properties getEmails() {
		return emails;
	}
	public void setEmails(Properties emails) {
		this.emails = emails;
	}
	
	
}
