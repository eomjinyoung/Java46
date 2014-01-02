package java01.exam13.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcTest03 {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/spmsdb?"
				+ "useUnicode=true&characterEncoding=UTF8", 
				"spms", "spms");
		Statement stmt = conn.createStatement();
		int count = stmt.executeUpdate(
				"update MEMBERS set "
				+ " MNAME = concat(MNAME, 'x'),"
				+ " AGE = 20 "
				+ " where MNO=22");
		stmt.close();
		conn.close();
		
		System.out.println(count);
	}

}








