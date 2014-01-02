package java01.exam13.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcTest04 {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/spmsdb?"
				+ "useUnicode=true&characterEncoding=UTF8", 
				"spms", "spms");
		Statement stmt = conn.createStatement();
		int count = stmt.executeUpdate(
				"delete from MEMBERS where MNO=1");
		stmt.close();
		conn.close();
		
		System.out.println(count);
	}

}








