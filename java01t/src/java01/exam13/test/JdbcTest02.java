package java01.exam13.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcTest02 {

	public static void main(String[] args) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/spmsdb?"
					+ "useUnicode=true&characterEncoding=UTF8", 
					"spms", "spms");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(
					"select MNO,MNAME,EMAIL,TEL,AGE from MEMBERS");
			while(rs.next()) {
				System.out.println(rs.getInt("MNO") + "," 
						+ rs.getString("MNAME") + ","
						+ rs.getString("EMAIL") + ","
						+ rs.getString("TEL") + ","
						+ rs.getInt("AGE") );
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {if(rs != null) rs.close();} catch (Exception e) {}
			try {if(stmt != null) stmt.close();} catch (Exception e) {}
			try {if(conn != null) conn.close();} catch (Exception e) {}
		}
	}

}








