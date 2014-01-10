package spms.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spms.dao.MemberDao;
import spms.vo.Member;

@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

	@Override
	public void doPost(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8"); // 필터로 대체
		
		Member member = new Member();
		member.setNo( Integer.parseInt(request.getParameter("no")) );
		member.setName( request.getParameter("name") );
		member.setEmail( request.getParameter("email") );
		member.setTel( request.getParameter("tel") );
		member.setAge( Integer.parseInt(request.getParameter("age")) );
		
	  try {
		  MemberDao memberDao = new MemberDao();
			int count = memberDao.update(member);
			if (count > 0) {
				request.setAttribute("message", "변경 성공입니다!");
			} else {
				request.setAttribute("message", "해당 번호의 회원 정보를 찾을 수 없습니다!");
			}
			
			RequestDispatcher rd = request.getRequestDispatcher(
					"update.jsp");
			rd.forward(request, response);
			
	  } catch (Exception e) {
	  		e.printStackTrace();
	  		request.setAttribute("error", e);
	  		RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
		  rd.forward(request, response);
	  }
	  
	}
}




