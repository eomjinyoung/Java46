package java46.test03;

import java.util.Map;
import java.util.Properties;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("ohoraMember") //객체이름을 지정할 수 있다.
public class Member {
	@Inject 	@Value("홍길동")
	private String 	name;
	
	@Inject @Value("20")
	private int			age;
	
	Map<String,String> tels;
	Properties emails;
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	
	
	
}
