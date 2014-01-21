package java46.test02;

import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component  //객체 이름을 지정하지 않으면, 클래스명(첫 알파벳은 소문자)이 된다. 
@Component("ohoraMember") //객체이름을 지정할 수 있다.
public class Member {
	String 	name;
	int			age;
	Map<String,String> tels;
	Properties emails;
	
	public String getName() {
		return name;
	}
	
	@Autowired
	public void setName(@Value("홍길동") String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	@Autowired(required=false)
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
