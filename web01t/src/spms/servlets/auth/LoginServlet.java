package spms.servlets.auth;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spms.dao.MemberDao;
import spms.vo.Member;

@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(
  			HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  		//1. 웹브라우저가 보낸 쿠키 꺼내기
  		Cookie[] cookies = request.getCookies();
  		if (cookies != null) {
	  		for(Cookie c : cookies) {
	  			if (c.getName().equals("email")) {
	  				request.setAttribute("email", c.getValue());
	  				request.setAttribute("checkSaveEmail", "checked");
	  				break;
	  			}
	  		}
  		}
  	
  		RequestDispatcher rd = request.getRequestDispatcher(
  				"/auth/login.jsp");
	  rd.forward(request, response);
  }
  
  @Override
  protected void doPost(
  			HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  		String email = request.getParameter("email");
  		String password = request.getParameter("password");
  		
  		// 체크상자를 체크 했을 때만 값이 서버로 넘어 온다.
  		// 체크하지 않으면 파라미터가 넘어 오지 않는다.
  		String saveEmail = request.getParameter("saveEmail");
  		if (saveEmail != null) {
  			response.addCookie(new Cookie("email", email));
  		} else {
  			Cookie c = new Cookie("email", null);
  			c.setMaxAge(0); // 쿠키를 삭제하도록 설정
  			response.addCookie(c);
  		}
  		
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










