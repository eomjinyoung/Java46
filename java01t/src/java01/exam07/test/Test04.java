package java01.exam07.test;

// 다형성: 다형적 변수(Polymorphic Variable)
class Pen {
	int color;
}

class BallPen extends Pen {
	int diameter;
}

class MarkerPen extends Pen {
	int width;
}

class ThreeBallPen extends BallPen {
	int color2;
	int color3;
	int selectedColor;
}



public class Test04 {

	public static void main(String[] args) {
		//BallPen p1 = new Pen();
		BallPen p2 = new BallPen();
		//BallPen p3 = new MarkerPen();
		BallPen p4 = new ThreeBallPen();
		
		//p1.diameter = 1;
		p2.color = 30;
		p2.diameter = 1;
		
		((ThreeBallPen)p2).color2 = 40;
		((ThreeBallPen)p2).color3 = 40;
		
		
		p4.color = 30;
		p4.diameter = 2;
		
		((ThreeBallPen)p4).color2 = 40;
		((ThreeBallPen)p4).color3 = 40;
		
		ThreeBallPen p5 = (ThreeBallPen) p4;
		p5.color2 = 40;
		p5.color3 = 50;
		
		System.out.println(p5.color);
		System.out.println(p5.color2);
		System.out.println(p5.color3);
		System.out.println(p5.diameter);
		
	}

}





