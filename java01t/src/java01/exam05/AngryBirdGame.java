package java01.exam05;

public class AngryBirdGame {
	
	//생성자가 없으면 컴파일러가 자동 생성
	//생성자가 있다면 자동 생성 안함.
	//public AngryBirdGame() {}
	
	public static void main(String[] args) {
		GameMap map = new GameMap(10, 8);
		map.print();
		
		AngryBird bird = new AngryBird();
		bird.setPosition(3, 3);
		
   	BadPig pig = new BadPig();
		pig.setPosition(6, 5);
		
		map.setAngryBird(bird);
		map.setBadPig(pig);
		
		bird.turnRight();
		for (int i = 0; i < 3; i++) bird.move();

		bird.turnRight();
		for (int i = 0; i < 2; i++) bird.move();
				
		map.print();
		
		
	}



}








