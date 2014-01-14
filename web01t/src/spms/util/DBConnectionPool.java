package spms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

//1. Singleton 패턴 적용
//- 인스턴스를 오로지 한 개만 생성하게 만듦.
public class DBConnectionPool {
	ArrayList<Connection> list = new ArrayList<Connection>();
	
	String driver;
	String url;
	String username;
	String password;
	
	static DBConnectionPool instance;
	
	public static DBConnectionPool prepareInstance(String driver, String url,
			String username, String password) throws Exception {
		if (instance == null) {
			instance = new DBConnectionPool(driver, url, username, password);
		}
		return instance;
	}
	
	public static DBConnectionPool getInstance() {
		if (instance != null) {
			return instance;
		}
		return null;
	}
	
	private DBConnectionPool(String driver, String url,
			String username, String password) throws Exception {
		this.driver = driver;
		this.url = url;
		this.username = username;
		this.password = password;
		
		Class.forName(driver);
	}
	
	
	public Connection getConnection() throws Exception {
		if (list.size() > 0) {
			return list.remove(0);
		} else {
			return DriverManager.getConnection(url, username, password);
		}
	}
	
	public void returnConnection(Connection con) {
		try {
			if (con != null && !con.isClosed()) {
				list.add(con);
			}
		} catch (Exception e) {}
	}
	
	public void closeAll() {
		for(Connection con : list) {
			try { con.close(); } catch (Exception e) {}
		}
	}
}

























