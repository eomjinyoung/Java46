package java01.exam14;

public enum Role {
	GUEST(0), GENERAL(1), MANAGER(9);
	
	private int i;
	Role(int i) {
		this.i = i;
	}
	
	public int value() {
		return i;
	}
}


