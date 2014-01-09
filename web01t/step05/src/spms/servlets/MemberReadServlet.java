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

@WebServlet("/member/read")
public class MemberReadServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

	@Override
	public void doGet(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		int no = Integer.parseInt( request.getParameter("no") );
	  try {
		  MemberDao memberDao = new MemberDao();
			Member member = memberDao.selectOne(no);
			
			request.setAttribute("member", member);
			
			RequestDispatcher rd = request.getRequestDispatcher(
					"updateForm.jsp");
			rd.forward(request, response);
			
	  } catch (Exception e) {
	  		e.printStackTrace();
	  }
	}
}












