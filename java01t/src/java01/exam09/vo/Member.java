package java01.exam09.vo;

import java.io.Serializable;

// 
public class Member implements Serializable {
  // 바이트 배열로 만들 때 버전 명시 -> 나중에 읽을 때 검사
	private static final long serialVersionUID = 1L;

  protected String name;
	protected int age;
	protected String email;
	protected String tel;
	
	public Member() {}
	
	public Member(String csv) {
		String[] items = csv.split(",");
		this.name = items[0];
		this.age = Integer.parseInt(items[1]);
		this.email = items[2];
		this.tel = items[3];
	}
	
	@Override
  public String toString() {
	  return name + "," + age + "," + email + "," + tel;
  }

	@Override
  public int hashCode() {
	  final int prime = 31;
	  int result = 1;
	  result = prime * result + age;
	  result = prime * result + ((email == null) ? 0 : email.hashCode());
	  result = prime * result + ((name == null) ? 0 : name.hashCode());
	  result = prime * result + ((tel == null) ? 0 : tel.hashCode());
	  return result;
  }

	@Override
  public boolean equals(Object obj) {
	  if (this == obj)
		  return true;
	  if (obj == null)
		  return false;
	  if (getClass() != obj.getClass())
		  return false;
	  Member other = (Member) obj;
	  if (age != other.age)
		  return false;
	  if (email == null) {
		  if (other.email != null)
			  return false;
	  } else if (!email.equals(other.email))
		  return false;
	  if (name == null) {
		  if (other.name != null)
			  return false;
	  } else if (!name.equals(other.name))
		  return false;
	  if (tel == null) {
		  if (other.tel != null)
			  return false;
	  } else if (!tel.equals(other.tel))
		  return false;
	  return true;
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
		if(age > 7 && age < 101) {
			this.age = age;
		} else { 
			this.age = 20;
		}
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	

}







