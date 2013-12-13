package java01.exam04;

public class GameMap {
	AngryBird bird;
	BadPig pig;
	int maxX = 7;
	int maxY = 7;
	
	public GameMap() {}
	
	public GameMap(int maxValue) {
		this(maxValue, maxValue);
	}
	
	public GameMap(int maxX, int maxY) {
		this.maxX = maxX;
		this.maxY = maxY;
	}
	
	public void print() {
		printBoundary();
		
	  for (int y = 0; y < maxY; y++) {
			for (int x = 0; x < maxX; x++) {
				if (bird != null && 
					x == bird.getX() && 
					y == bird.getY()) {
					System.out.print(bird.getFlag());
				} else if (pig != null && 
					x == pig.getX() && 
					y == pig.getY()) {
					System.out.print(pig.getFlag());
				}	else {
					System.out.print(".");
				}
			}
			System.out.println();
		}
	  
	  printBoundary();
  }

	private void printBoundary() {
	  for (int i = 0 ;i < maxX; i++) {
			System.out.print("-");
		}
		System.out.println();
  }

	public void setAngryBird(AngryBird bird) {
		this.bird = bird;
	}
	
	public void setBadPig(BadPig pig) {
		this.pig = pig;
	}
}









