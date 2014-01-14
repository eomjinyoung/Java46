package spms.servlets;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.sql.DataSource;

import spms.dao.MemberDao;

// 웹애플리케이션이 시작될 때 서블릿이 사용할 객체들을 준비
public class AppInitServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
	  super.init(config);
	  
	  System.out.println("AppInitServlet.init()");
	  try {
	  		// 디렉토리 서비스에 등록된 자원을 찾아주는 객체
	  		Context ctx = new InitialContext();
	  		
	  		// loopup(자원이름) 
	  		DataSource ds = (DataSource)ctx.lookup(
	  				"java:/comp/env/jdbc/spmsdb");
	  		
	  		MemberDao memberDao = new MemberDao();
	  	  memberDao.setDataSource(ds); // dbPool 주입
	  	  
	  	  this.getServletContext().setAttribute("memberDao", memberDao);
	  	  
	  } catch (Exception e) {
	  		e.printStackTrace();
	  }
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res)
	    throws ServletException, IOException {

	}

}





