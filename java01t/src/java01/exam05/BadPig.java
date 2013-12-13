package java01.exam05;

public class BadPig extends Item {
	private int weight;
	
	public BadPig() {
		this('M', 40);
	}
	
	public BadPig(char flag, int weight) {
		this.flag = flag;
		this.weight = weight;
	}
	
	public int getWeight() { 
		return this.weight;
	}
}
