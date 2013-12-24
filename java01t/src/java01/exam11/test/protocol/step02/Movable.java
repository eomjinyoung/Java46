package java01.exam11.test.protocol.step02;

// Driver가 사용할 이동수단의 자격을 정의
// Driver의 호출 규칙 정의
// - 인터페이스에는 추상 메서드만 선언할 수 있다.(public abstract)
// - 상수 변수만 가능(public static final)
public interface Movable {
	/*public static final*/ int LAND = 1;
	/*public static final*/ int SEA = 1;
	/*public static final*/ int SKY = 1;
	
	/*abstract public*/ void move();
	/*abstract public*/ void stop();
}
