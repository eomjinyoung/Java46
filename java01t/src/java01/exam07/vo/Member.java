package java01.exam07.vo;

// 3. Object 클래스의 메서드 재정의 
// - equals()
// - toString()
// - finalize() : 가비지 컬렉터가 객체를 해제하기 전에 호출하는 메서드
//						가비지 컬렉터 언제 호출하는지 보장 못함.
// - hashCode() : 인스턴스 마다 고유의 정수 값 반환
//				같은 값을 가지는 객체는 같은 해시코드를 리턴하게 해야 한다.
//				해시 값은 인스턴스를 구분하는 값
//				예) 공인인증서 코드
public class Member /*extends Object*/ {
	protected String name;
	protected int age;
	protected String email;
	protected String tel;
	
	@Override
  public String toString() {
	  return "Member [name=" + name + ", age=" + age + ", email=" + email
	      + ", tel=" + tel + "]";
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
		if(this.age > 7 && this.age < 101) {
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







