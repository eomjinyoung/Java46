package java01.exam05;

public class GameMap01 {
	public static final int DEFAULT_X_SIZE = 7;
	public static final int DEFAULT_Y_SIZE = 7;
	
	char[][] map;
	AngryBird bird;
	BadPig pig;
	int maxX;
	int maxY;
	
	public GameMap01() {
		this(DEFAULT_X_SIZE, DEFAULT_Y_SIZE);
	}
	
	public GameMap01(int maxValue) {
		this(maxValue, maxValue);
	}
	
	public GameMap01(int maxX, int maxY) {
		this.maxX = maxX;
		this.maxY = maxY;
		map = new char[maxY][maxX];
	}
	
	private void initMap() {
		for (int y = 0; y < maxY; y++) {
			for (int x = 0; x < maxX; x++) {
				map[y][x] = '.';
			}
		}
	}
	
	private void locateItems() {
		if (pig != null) {
			map[pig.getY()][pig.getX()] = pig.getFlag();
		}
		if (bird != null) {
			map[bird.getY()][bird.getX()] = bird.getFlag();
		}
	}
	
	public void print() {
		initMap();
		locateItems();
		
		printBoundary();
		
	  for (int y = 0; y < maxY; y++) {
			for (int x = 0; x < maxX; x++) {
					System.out.print(map[y][x]);
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









