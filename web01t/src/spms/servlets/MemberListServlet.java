package spms.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spms.dao.MemberDao;
import spms.vo.Member;

@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

	@Override
	public void doGet(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		System.out.println("MemberListServlet: doGet()");
	  try {
		  MemberDao memberDao = (MemberDao)this.getServletContext()
		  			.getAttribute("memberDao");
			ArrayList<Member> members = memberDao.selectList();
			
			// JSP에 데이터를 넘기기 
			request.setAttribute("members", members);
			
			// 데이터 출력을 JSP에게 맡긴다.
			request.setAttribute("pageTitle", "회원 목록");
			request.setAttribute("contentPage", "/member/list.jsp");
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




