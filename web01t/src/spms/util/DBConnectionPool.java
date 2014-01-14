package spms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class DBConnectionPool {
	ArrayList<Connection> list = new ArrayList<Connection>();
	
	String driver;
	String url;
	String username;
	String password;
	
	public DBConnectionPool(String driver, String url,
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
		list.add(con);
	}
	
	public void closeAll() {
		for(Connection con : list) {
			try { con.close(); } catch (Exception e) {}
		}
	}
}

























