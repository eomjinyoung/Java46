package java01.exam05;

public class AngryBird extends Item {
	protected int direction = 1;
	
	public AngryBird() {
		this('V');
	}
	
	public AngryBird(char flag) {
		this.flag = flag;
	}
	
	public void move() {
		switch(direction) {
		case NORTH: if (y > 0) y--; break;
		case EAST: if (x < 6) x++; break;
		case SOUTH: if (y < 6) y++; break;
		case WEST: if (x > 0) x--; break;
		}
	}
	
	public void turnLeft() {
		if (this.direction == 1)
			this.direction = 4;
		else 
			this.direction--;
	}
	
	public void turnRight() {
		if (this.direction == 4)
			this.direction = 1;
		else 
			this.direction++;
	}
}









