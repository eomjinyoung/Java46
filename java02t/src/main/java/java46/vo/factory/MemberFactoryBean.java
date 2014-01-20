package java46.vo.factory;

import java46.vo.Member;

import org.springframework.beans.factory.config.AbstractFactoryBean;

public class MemberFactoryBean extends AbstractFactoryBean<Member> {
	String 	name;
	int			age;
	
	@Override
  public Class<?> getObjectType() {
	  return Member.class;
  }

	@Override
  protected Member createInstance() throws Exception {
		Member temp = new Member();
		temp.setName("*" + this.name + "*");
		if (this.age < 0 || this.age > 100)
			temp.setAge(20);
		else 
			temp.setAge(this.age);
		
	  return temp;
  }

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
	
	


	
}





