package spms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import spms.vo.Project;

public class ProjectDao {
	
	public ArrayList<Project> selectList() throws Exception {
		ArrayList<Project> list = new ArrayList<Project>();
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
					"select PNO,TITLE,SDATE,EDATE,STATE from PROJECTS");
			
			Project project = null;
			while(rs.next()) {
				project = new Project();
				project.setNo(rs.getInt("PNO"));
				project.setTitle(rs.getString("TITLE"));
				project.setStartDate(rs.getDate("SDATE"));
				project.setEndDate(rs.getDate("EDATE"));
				project.setState(rs.getInt("STATE"));
				
				list.add(project);
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
	
	public Project selectOne(int no) throws Exception {
		Project project = null;
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
					"select TITLE,CONTENTS,SDATE,EDATE,STATE,TAGS"
					+ " from PROJECTS"
					+ " where PNO=" + no);
			
			if(rs.next()) {
				project = new Project();
				project.setNo(no);
				project.setTitle(rs.getString("TITLE"));
				project.setDescription(rs.getString("CONTENTS"));
				project.setStartDate(rs.getDate("SDATE"));
				project.setEndDate(rs.getDate("EDATE"));
				project.setState(rs.getInt("STATE"));
				project.setTags(rs.getString("TAGS"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			
		} finally {
			try {if(rs != null) rs.close();} catch (Exception e) {}
			try {if(stmt != null) stmt.close();} catch (Exception e) {}
			try {if(conn != null) conn.close();} catch (Exception e) {}
		}	
		return project;
	}
	
	public int insert(Project project) throws Exception {
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
					"INSERT INTO PROJECTS(TITLE,CONTENTS,SDATE,EDATE,TAGS)"
					+ " VALUES('" + project.getTitle()
					+ "','" + project.getDescription()
					+ "','" + project.getStartDate()
					+ "','" + project.getEndDate()
					+ "','" + project.getTags()
					+ "')");
		
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			
		} finally {
			try {stmt.close();} catch (Exception e) {}
			try {conn.close();} catch (Exception e) {}
		}
		return count;
	}
	
	public int update(Project project) throws Exception {
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
			buf.append("update PROJECTS set ");
			buf.append(" TITLE='" + project.getTitle() + "',");
			buf.append(" CONTENTS='" + project.getDescription() + "',");
			buf.append(" SDATE='" + project.getStartDate() + "',");
			buf.append(" EDATE='" + project.getEndDate() + "',");
			buf.append(" STATE=" + project.getState() + ",");
			buf.append(" TAGS='" + project.getTags() + "'");
			buf.append(" where PNO=" + project.getNo());
			
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
					"delete from PROJECTS "
					+ " where PNO=" + no);
		
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







