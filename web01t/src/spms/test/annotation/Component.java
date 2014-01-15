package spms.test.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
 * 1. 애노테이션  
 * - 일반 주석은 컴파일 후 제거되지만, 애노테이션은 설정에 따라 클래스 파일에 잔류한다.
 * - 컴파일러와 JVM에게 전달하는 특별한 주석. 실행 시에 꺼내 볼 수 있다.
 * - 애노테이션을 정의할 때 애노테이션 유지 정책을 선언해야 한다.
 * 2. 애노테이션 유지 정책
 * 1) SOURCE - 컴파일 후 제거. 클래스 파일에 남아있지 않음.
 * 2) CLASS - 클래스 파일에 기록됨. 실행 시에는 참조할 수 없음.
 * 3) RUNTIME - 클래스 파일에 기록됨. 실행 시에 참조 가능.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
	String name() default "N/A";
	String value();
	int no();
	int count() default 1;
	String[] nicknames();
}












