package java01.exam13.server.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java01.exam13.server.vo.Member;

public class MemberDao {
	public ArrayList<Member> selectList() throws Exception {
		ArrayList<Member> list = new ArrayList<Member>();
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
			
			Member member = null;
			while(rs.next()) {
				member = new Member();
				member.setNo(rs.getInt("MNO"));
				member.setName(rs.getString("MNAME"));
				member.setEmail(rs.getString("EMAIL"));
				member.setTel(rs.getString("TEL"));
				member.setAge(rs.getInt("AGE"));
				
				list.add(member);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {if(rs != null) rs.close();} catch (Exception e) {}
			try {if(stmt != null) stmt.close();} catch (Exception e) {}
			try {if(conn != null) conn.close();} catch (Exception e) {}
		}
		
		return list;
	}
	
	public Member selectOne(int no) throws Exception {
		Member member = null;
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
					"select MNO,MNAME,EMAIL,TEL,AGE "
					+ " from MEMBERS"
					+ " where MNO=" + no);
			
			if(rs.next()) {
				member = new Member();
				member.setNo(rs.getInt("MNO"));
				member.setName(rs.getString("MNAME"));
				member.setEmail(rs.getString("EMAIL"));
				member.setTel(rs.getString("TEL"));
				member.setAge(rs.getInt("AGE"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {if(rs != null) rs.close();} catch (Exception e) {}
			try {if(stmt != null) stmt.close();} catch (Exception e) {}
			try {if(conn != null) conn.close();} catch (Exception e) {}
		}	
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
					"INSERT INTO MEMBERS(MNAME,EMAIL,TEL,AGE)"
					+ " VALUES('" + member.getName()
					+ "','" + member.getEmail()
					+ "','" + member.getTel()
					+ "'," + member.getAge()
					+ ")");
		
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
					"update MEMBERS set "
					+ " MNAME='" + member.getName() + "',"
					+ " EMAIL='" + member.getEmail() + "',"
					+ " TEL='" + member.getTel() + "',"
					+ " AGE=" + member.getAge()
					+ " where MNO=" + member.getNo());
		
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			
		} finally {
			try {stmt.close();} catch (Exception e) {}
			try {conn.close();} catch (Exception e) {}
		}		
		return count;
	}
	
	public int delete(int no) throws Exception {
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
					"delete from MEMBERS "
					+ " where MNO=" + no);
		
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			
		} finally {
			try {stmt.close();} catch (Exception e) {}
			try {conn.close();} catch (Exception e) {}
		}		
		return count;
	}
	
}







