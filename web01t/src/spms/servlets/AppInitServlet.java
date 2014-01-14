package spms.servlets;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import spms.dao.MemberDao;
import spms.util.DBConnectionPool;

// 웹애플리케이션이 시작될 때 서블릿이 사용할 객체들을 준비
public class AppInitServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;

  DBConnectionPool dbPool;
  
	@Override
	public void init(ServletConfig config) throws ServletException {
	  super.init(config);
	  
	  System.out.println("AppInitServlet.init()");
	  try {
	  		dbPool = new DBConnectionPool(
				"com.mysql.jdbc.Driver", 
				"jdbc:mysql://localhost/spmsdb?"
						+ "useUnicode=true&characterEncoding=UTF8", 
				"spms", "spms");
	  		
	  		MemberDao memberDao = new MemberDao();
	  	  memberDao.setDBConnectionPool(dbPool); // dbPool 주입
	  	  
	  	  this.getServletContext().setAttribute("memberDao", memberDao);
	  	  
	  } catch (Exception e) {
	  		e.printStackTrace();
	  }
	}
	
	@Override
	public void destroy() {
		super.destroy();
		
		System.out.println("AppInitServlet.destroy()");
		dbPool.closeAll();
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
	    throws ServletException, IOException {

	}

}





