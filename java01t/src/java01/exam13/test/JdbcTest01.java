package java01.exam13.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcTest01 {

	public static void main(String[] args) throws Exception {
		//1. JDBC 드라이버 정보를 갖고 있는 클래스를 로딩
		// - java.sql.Driver를 구현한 클래스를 로딩한다.
		// - 클래스 이름은 패키지 이름을 포함해야 한다. Fully-qualified class name
		//   FQName = QName
		Class.forName("com.mysql.jdbc.Driver");
		
		//2. JDBC 드라이버 관리자를 통해 DB 연결자를 얻는다.
		// - DB 연결자란 java.sql.Connection 구현체다.
		// - 시나리오
		//   1) DriverManager에게 DB 연결자를 달라고 요청한다.
		//		 2) DriverManager는 로딩된 클래스 중에서 java.sql.Driver 구현체를 찾는다.
		//      그 클래스에게 Connection 구현체를 달라고 요청한다.
		//				파라미터 정보: 접속할 DBMS URL, 아이디, 암호 
		//   3) java.sql.Driver 구현 클래스는 DB 연결자를 생성하여 리턴한다.
		//		 4) DriverManager는 JDBC 드라이버가 리턴한 값을 그대로 리턴한다.
		//   5) DB 연결자를 잘 보관한다.
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/spmsdb?"
				+ "useUnicode=true&characterEncoding=UTF8", 
				"spms", "spms");
		
		//3. DB 연결자를 통해 SQL을 서버에 보낼 실행자를 얻는다.
		// - SQL 실행자란, java.sql.Statement 구현 클래스이다.
		Statement stmt = conn.createStatement();
		
		//4. SQL 실행자를 통해 INSERT를 서버에 보낸다.
		stmt.executeUpdate(
				"INSERT INTO MEMBERS(MNAME,EMAIL,TEL)"
				+ " VALUES('홍길동3', 'hong@test.com', '111-1111')");
		
		//5. SQL 실행자를 닫는다.
		stmt.close();
		
		//6. DB 연결자를 닫는다.
		conn.close();

	}

}








