package java01.exam07.vo;

// 2. 캡슐화 : 
// - 데이터를 외부에서 직접 접근하는 것을 제한
// - 외부에서 값을 할당하고 꺼낼 때 사용할 메서드를 정의
// - 값을 할당하는 메서드 => setXXX() => setter 메서드
// - 값을 꺼내는 메서드 => getXXX() => getter 메서드
// - 꺼내는 값이 boolean =>  isXXX() => getter 메서드
public class Member {
	protected String name;
	protected int age;
	protected String email;
	protected String tel;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setAge(int age) {
		if (age >= 8 && age <= 100) {
			this.age = age;
		} else {
			this.age = 20;
		}
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getTel() {
		return this.tel;
	}
}







