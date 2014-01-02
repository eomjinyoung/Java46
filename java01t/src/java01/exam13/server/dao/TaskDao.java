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
				task.setStartDate(rs.getDate("SDATE"));
				task.setEndDate(rs.getDate("EDATE"));
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
				task.setStartDate(rs.getDate("SDATE"));
				task.setEndDate(rs.getDate("EDATE"));
				task.setState(rs.getInt("STATE"));
				task.setTags(rs.getString("TAGS"));
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
					"INSERT INTO TASKS(TITLE,SDATE,EDATE,TAGS,PNO)"
					+ " VALUES('" + task.getTitle()
					+ "','" + task.getStartDate()
					+ "','" + task.getEndDate()
					+ "','" + task.getTags()
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

			StringBuffer buf = new StringBuffer();
			buf.append("update TASKS set ");
			buf.append(" TITLE='" + task.getTitle() + "',");
			buf.append(" SDATE='" + task.getStartDate() + "',");
			buf.append(" EDATE='" + task.getEndDate() + "',");
			buf.append(" STATE=" + task.getState() + ",");
			buf.append(" TAGS='" + task.getTags() + "',");
			buf.append(" PNO=" + task.getProjectNo());
			buf.append(" where TNO=" + task.getNo());
			count = stmt.executeUpdate(buf.toString());
		
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







