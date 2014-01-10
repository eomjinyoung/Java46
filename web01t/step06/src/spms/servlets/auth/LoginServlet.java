package spms.servlets.auth;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spms.dao.MemberDao;
import spms.vo.Member;

@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(
  			HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  		String email = request.getParameter("email");
  		String password = request.getParameter("password");
  		
  		MemberDao memberDao = new MemberDao();
  		try {
  			Member member = memberDao.selectByEmailPassword(email, password);
  			
  			if (member != null) {
  				request.getSession().setAttribute("member", member);
  				response.sendRedirect("../index.jsp");
  			} else {
  				RequestDispatcher rd = request.getRequestDispatcher(
  						"/auth/loginFail.jsp");
    		  rd.forward(request, response);
  			}
  			
  		} catch (Exception e) {
	  		e.printStackTrace();
	  		request.setAttribute("error", e);
	  		RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
		  rd.forward(request, response);
	  }
  }
}










