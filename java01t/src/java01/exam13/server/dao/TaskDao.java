package java01.exam13.server.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java01.exam13.server.vo.Task;

public class TaskDao {
	
	public ArrayList<Task> selectList() throws Exception {
		ArrayList<Task> list = new ArrayList<Task>();
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
					"select TNO,TITLE,SDATE,EDATE,STATE,PNO from TASKS");
			
			Task task = null;
			while(rs.next()) {
				task = new Task();
				task.setNo(rs.getInt("TNO"));
				task.setTitle(rs.getString("TITLE"));
				task.setState(rs.getInt("STATE"));
				task.setProjectNo(rs.getInt("PNO"));
				
				list.add(task);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			
		} finally {
			try {if(rs != null) rs.close();} catch (Exception e) {}
			try {if(stmt != null) stmt.close();} catch (Exception e) {}
			try {if(conn != null) conn.close();} catch (Exception e) {}
		}
		
		return list;
	}
	
	public Task selectOne(int no) throws Exception {
		Task task = null;
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
					"select TNO,TITLE,SDATE,EDATE,STATE,PNO,TAGS,MNO"
					+ " from TASKS"
					+ " where TNO=" + no);
			
			if(rs.next()) {
				task = new Task();
				task.setNo(rs.getInt("TNO"));
				task.setTitle(rs.getString("TITLE"));
				task.setState(rs.getInt("STATE"));
				task.setProjectNo(rs.getInt("PNO"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			
		} finally {
			try {if(rs != null) rs.close();} catch (Exception e) {}
			try {if(stmt != null) stmt.close();} catch (Exception e) {}
			try {if(conn != null) conn.close();} catch (Exception e) {}
		}	
		return task;
	}
	
	public int insert(Task task) throws Exception {
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
					"INSERT INTO TASKS(TITLE,PNO)"
					+ " VALUES('" + task.getTitle()
					+ "'," + task.getProjectNo() 
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
	
	public int update(Task task) throws Exception {
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
					"update TASKS set "
					+ " TITLE='" + task.getTitle() + "',"
					//+ " SDATE='" +  + "',"
					//+ " EDATE='" + member.getTel() + "',"
					+ " STATE='" + task.getState() + "',"
					//+ " TAGS='" + member.getTel() + "',"
					+ " PNO=" + task.getProjectNo()
					+ " where TNO=" + task.getNo());
		
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
					"delete from TASKS "
					+ " where TNO=" + no);
		
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







