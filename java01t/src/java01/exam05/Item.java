package java01.exam05;

// 추상 클래스 
// - 공통 기능을 상속해주는 용도의 클래스
// - 직접 인스턴스를 사용하지 못하게 막는다.
abstract public class Item {
	public static final int NORTH = 1;
	public static final int EAST = 2;
	public static final int SOUTH = 3;
	public static final int WEST = 4;
	
	protected char flag;
	protected int x = 0;
	protected int y = 0;	
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public char getFlag() {
		return this.flag;
	}	
	
	public void setFlag(char flag) {
		this.flag = flag;
	}
}










