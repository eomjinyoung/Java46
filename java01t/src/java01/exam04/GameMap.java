package java01.exam04;

public class GameMap {
	AngryBird bird;
	BadPig pig;
	
	public void print() {
		System.out.println("-------");
	  for (int y = 0; y < 7; y++) {
			for (int x = 0; x < 7; x++) {
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
	  System.out.println("-------");
  }

	public void setAngryBird(AngryBird bird) {
		this.bird = bird;
	}
	
	public void setBadPig(BadPig pig) {
		this.pig = pig;
	}
}









