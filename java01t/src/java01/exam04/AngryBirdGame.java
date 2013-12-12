package java01.exam04;

public class AngryBirdGame {
	public static void main(String[] args) {
		GameMap map = new GameMap();
		map.init();
		map.print();
		
		AngryBird bird = new AngryBird();
		bird.init(3, 3);
		
		map.locate(bird);
		map.print();
		
		
	}



}








