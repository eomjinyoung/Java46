package java01.exam14;

public class RoleTest {

	public static void main(String[] args) {
		Role r1 = Role.GENERAL;
		Role r2 = Role.GUEST;
		Role r3 = Role.MANAGER;


		System.out.println(r1.value());
		System.out.println(r2.value());
		System.out.println(r3.value());
		
	}

}
