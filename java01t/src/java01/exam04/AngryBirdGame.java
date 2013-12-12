package java01.exam04;

public class AngryBirdGame {
	public static void main(String[] args) {
		GameMap map = new GameMap();
		map.print();
		
		AngryBird bird = new AngryBird();
		bird.init(3, 3);
		
		BadPig pig = new BadPig();
		pig.init(3, 5);
		
		map.setAngryBird(bird);
		map.setBadPig(pig);
		
		bird.turnLeft();
		bird.turnLeft();
		bird.move();
		bird.move();
		
		map.print();
		
		
	}



}








