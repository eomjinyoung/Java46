package java01.exam04;

public class AngryBirdGame {
	
	//생성자가 없으면 컴파일러가 자동 생성
	//생성자가 있다면 자동 생성 안함.
	//public AngryBirdGame() {}
	
	public static void main(String[] args) {
		GameMap map = new GameMap(10, 8);
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








