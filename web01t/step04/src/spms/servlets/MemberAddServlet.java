package spms.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spms.dao.MemberDao;
import spms.vo.Member;

@WebServlet("/member/add")
public class MemberAddServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	  PrintWriter out = response.getWriter();
	  
	  out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>회원등록</title>");
		out.println("</head>");
		out.println("<body>");
		
		Member member = new Member();
		member.setName( request.getParameter("name") );
		member.setEmail( request.getParameter("email") );
		member.setTel( request.getParameter("tel") );
		member.setAge( Integer.parseInt(request.getParameter("age")) );
		
		//response.sendRedirect("list");
		response.setHeader("Refresh", "5;url=list");
	  
	  try {
		  MemberDao memberDao = new MemberDao();
			memberDao.insert(member);
			out.println("등록 성공입니다.");
	  } catch (Exception e) {
	  		e.printStackTrace();
	  		out.println("실행 중 오류발생!");
	  }
	  
	  out.println("</body>");
		out.println("</html>");
	  
	}
}












