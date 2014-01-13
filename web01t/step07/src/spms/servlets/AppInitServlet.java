package spms.servlets;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import spms.dao.MemberDao;

// 웹애플리케이션이 시작될 때 서블릿이 사용할 객체들을 준비
public class AppInitServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
	  super.init(config);
	  
	  System.out.println("AppInitServlet.init()");
	  
	  MemberDao memberDao = new MemberDao();
	  this.getServletContext().setAttribute("memberDao", memberDao);
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
	    throws ServletException, IOException {

	}

}
