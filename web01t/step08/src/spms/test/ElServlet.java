package spms.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import spms.vo.Member;

@WebServlet("/test/eltest")
public class ElServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
		req.setAttribute("v1", "홍길동");
		
		HttpSession session = req.getSession();
		session.setAttribute("v1", "임꺽정");
		
		ServletContext application = req.getServletContext();
		application.setAttribute("v1", "일지매");
		
	  Member m = new Member();
	  m.setName("홍길동");
	  m.setEmail("hong@test.com");
	  m.setTel("111-2222");
	  m.setAge(20);
	  
	  req.setAttribute("member", m);
	  
		RequestDispatcher rd = req.getRequestDispatcher("/test/eltest01.jsp");
	  rd.forward(req, resp);
	}
}











