package spms.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spms.dao.MemberDao;

@WebServlet("/member/delete")
public class MemberDeleteServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

	@Override
	public void doGet(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		int no = Integer.parseInt( request.getParameter("no") );
		
	  try {
	  		MemberDao memberDao = (MemberDao)this.getServletContext()
	  			.getAttribute("memberDao");
			int count = memberDao.delete(no);
			if (count > 0) {
				request.setAttribute("message", "삭제 성공입니다.");
			} else {
				request.setAttribute("message", "해당 번호의 회원 정보가 없습니다!");
			}
			
			response.setHeader("Refresh", "1;url=list");
			request.setAttribute("pageTitle", "회원 삭제");
			request.setAttribute("contentPage", "/member/delete.jsp");
			RequestDispatcher rd = request.getRequestDispatcher("/template.jsp");
			rd.forward(request, response);
			
	  } catch (Exception e) {
	  		e.printStackTrace();
	  		request.setAttribute("error", e);
	  		RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
		  rd.forward(request, response);
	  }
	}
}




