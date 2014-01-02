package java01.exam13.server.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

import java01.exam13.server.vo.Member;

public class MemberDao {
	public ArrayList<Member> selectList() throws Exception {
		ArrayList<Member> list = new ArrayList<Member>();
		
		return list;
	}
	
	public Member selectOne(int no) throws Exception {
		Member member = null;
		
		return member;
	}
	
	public int insert(Member member) throws Exception {
		int count = 0;
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/spmsdb?"
					+ "useUnicode=true&characterEncoding=UTF8", 
					"spms", "spms");
			stmt = conn.createStatement();
			count = stmt.executeUpdate(
					"INSERT INTO MEMBERS(MNAME,EMAIL,TEL)"
					+ " VALUES('홍길동3', 'hong@test.com', '111-1111')");
		
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			
		} finally {
			try {stmt.close();} catch (Exception e) {}
			try {conn.close();} catch (Exception e) {}
		}
		return count;
	}
	
	public int update(Member member) throws Exception {
		int count = 0;
		
		return count;
	}
	
	public int delete(int no) throws Exception {
		int count = 0;
		
		return count;
	}
	
}







