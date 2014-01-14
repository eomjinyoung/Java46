package spms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import spms.vo.Member;

public class MemberDao {
	DataSource ds; // 의존 객체(dependencies)
	
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	
	public ArrayList<Member> selectList() throws Exception {
		ArrayList<Member> list = new ArrayList<Member>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
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
			throw e;
			
		} finally {
			try {if(rs != null) rs.close();} catch (Exception e) {}
			try {if(stmt != null) stmt.close();} catch (Exception e) {}
			//DataSource가 리턴해준 Connection 객체는 
			//DriverManager가 리턴한 객체를 한 번 더 포장하였다.
			//그래서 close() 메서드는 DB와의 연결을 끊는 것이 아니라 
			//Connection Pool에 반환하는 일을 한다.
			try {if(conn != null) conn.close();} catch (Exception e) {}
		}
		
		return list;
	}
	
	public Member selectOne(int no) throws Exception {
		Member member = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(
					"select MNO,MNAME,EMAIL,TEL,AGE "
					+ " from MEMBERS"
					+ " where MNO=?");
			stmt.setInt(1, no);
			rs = stmt.executeQuery();
			
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
			throw e;
			
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
		PreparedStatement stmt = null;
		
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(
					"INSERT INTO MEMBERS(MNAME,EMAIL,TEL,AGE) VALUES(?,?,?,?)");
			stmt.setString(1, member.getName());
			stmt.setString(2, member.getEmail());
			stmt.setString(3, member.getTel());
			stmt.setInt(4, member.getAge());
			count = stmt.executeUpdate();		
		
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			
		} finally {
			try {stmt.close();} catch (Exception e) {}
			try {if(conn != null) conn.close();} catch (Exception e) {}
		}
		return count;
	}
	
	public int update(Member member) throws Exception {
		int count = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(
					"update MEMBERS set MNAME=?,EMAIL=?,TEL=?,AGE=? where MNO=?");
			stmt.setString(1, member.getName());
			stmt.setString(2, member.getEmail());
			stmt.setString(3, member.getTel());
			stmt.setInt(4, member.getAge());
			stmt.setInt(5, member.getNo());
			count = stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			
		} finally {
			try {stmt.close();} catch (Exception e) {}
			try {if(conn != null) conn.close();} catch (Exception e) {}
		}		
		return count;
	}
	
	public int delete(int no) throws Exception {
		int count = 0;
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			count = stmt.executeUpdate(
					"delete from MEMBERS "
					+ " where MNO=" + no);
		
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			
		} finally {
			try {stmt.close();} catch (Exception e) {}
			try {if(conn != null) conn.close();} catch (Exception e) {}
		}		
		return count;
	}
	
	public Member selectByEmailPassword(String email, String password) 
			throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(
					"select MNO,MNAME,EMAIL"
					+ " from MEMBERS"
					+ " where EMAIL=? and PWD=?");
			stmt.setString(1, email);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				return new Member()
								.setNo(rs.getInt("MNO"))	
								.setName(rs.getString("MNAME"))
								.setEmail(rs.getString("EMAIL"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			
		} finally {
			try {if(rs != null) rs.close();} catch (Exception e) {}
			try {if(stmt != null) stmt.close();} catch (Exception e) {}
			try {if(conn != null) conn.close();} catch (Exception e) {}
		}	
		return null;
	}
	
}







