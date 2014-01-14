package spms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import spms.util.DBConnectionPool;
import spms.vo.Member;

public class MemberDao {
	DBConnectionPool dbPool; // 의존 객체(dependencies)
	
	public void setDBConnectionPool(DBConnectionPool dbPool) {
		this.dbPool = dbPool;
	}
	
	public ArrayList<Member> selectList() throws Exception {
		ArrayList<Member> list = new ArrayList<Member>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = dbPool.getConnection();
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
			dbPool.returnConnection(conn);
		}
		
		return list;
	}
	
	public Member selectOne(int no) throws Exception {
		Member member = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = dbPool.getConnection();
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
			throw e;
			
		} finally {
			try {if(rs != null) rs.close();} catch (Exception e) {}
			try {if(stmt != null) stmt.close();} catch (Exception e) {}
			dbPool.returnConnection(conn);
		}	
		return member;
	}
	
	public int insert(Member member) throws Exception {
		int count = 0;
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = dbPool.getConnection();
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
			dbPool.returnConnection(conn);
		}
		return count;
	}
	
	public int update(Member member) throws Exception {
		int count = 0;
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = dbPool.getConnection();
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
			dbPool.returnConnection(conn);
		}		
		return count;
	}
	
	public int delete(int no) throws Exception {
		int count = 0;
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = dbPool.getConnection();
			stmt = conn.createStatement();
			count = stmt.executeUpdate(
					"delete from MEMBERS "
					+ " where MNO=" + no);
		
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			
		} finally {
			try {stmt.close();} catch (Exception e) {}
			dbPool.returnConnection(conn);
		}		
		return count;
	}
	
	public Member selectByEmailPassword(String email, String password) 
			throws Exception {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = dbPool.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(
					"select MNO,MNAME,EMAIL"
					+ " from MEMBERS"
					+ " where EMAIL='" + email + "' and PWD='" + password + "'");
			
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
			dbPool.returnConnection(conn);
		}	
		return null;
	}
	
}







