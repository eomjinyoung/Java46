package java01.exam04;

public class AngryBird {
	public static final int NORTH = 1;
	public static final int EAST = 2;
	public static final int SOUTH = 3;
	public static final int WEST = 4;
	
	private int direction = 1; // north(1), east(2), south(3), west(4)
	private int x = 0;
	private int y = 0;
	
	public void init(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void move() {
		switch(direction) {
		case NORTH: if (y > 0) y--; break;
		case EAST: if (x < 6) x++; break;
		case SOUTH: if (y < 6) y++; break;
		case WEST: if (x > 0) x--; break;
		}
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
}









