package spms.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spms.dao.MemberDao;
import spms.vo.Member;

public class MemberListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

	@Override
	public void doGet(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	  try {
		  MemberDao memberDao = new MemberDao();
			ArrayList<Member> members = memberDao.selectList();
			
			// 데이터 출력을 JSP에게 맡긴다.
			RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
			rd.forward(request, response);
	  } catch (Exception e) {
	  		e.printStackTrace();
	  }
	}
}




