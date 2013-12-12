package java01.exam04;

public class GameMap {
	int[][] map = new int[7][7];
	
	public void init() {
	  for (int y = 0; y < 7; y++) {
			for (int x = 0; x < 7; x++) {
				this.map[y][x] = 0;
			}
		}
  }
	
	public void print() {
		System.out.println("-------");
	  for (int y = 0; y < 7; y++) {
			for (int x = 0; x < 7; x++) {
				System.out.print(this.map[y][x]);
			}
			System.out.println();
		}
	  System.out.println("-------");
  }

	public void locate(AngryBird bird) {
		int x = bird.getX();
		int y = bird.getY();
		
		map[y][x] = 1;
  }
}









