package spms.servlets.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/auth/logout")
public class LogoutServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(
  			HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  		request.getSession().invalidate(); //HttpSession 객체 제거 및 새로 생성
  		response.sendRedirect("login.html");
  }
}










