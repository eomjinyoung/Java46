package spms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

//2. DI 적용을 위한 고유 객체 생성 방식으로 전환 
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

























