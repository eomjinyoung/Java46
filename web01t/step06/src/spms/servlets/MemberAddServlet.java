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

@WebServlet("/member/add")
public class MemberAddServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
  	
  		// getParameter()를 호출하기 전에 문자셋을 알려줘야 한다.
  		// 단 한 번이라도 getParameter()를 호출하면 무시된다.
  	  // POST 방식으로 전송된 다국어 문자에 대해서만 적용됨.
  		// GET 방식은 서버의 설정에 따른다.
  		//request.setCharacterEncoding("UTF-8"); // 필터로 대체
  	
		Member member = new Member();
		member.setName( request.getParameter("name") );
		member.setEmail( request.getParameter("email") );
		member.setTel( request.getParameter("tel") );
		member.setAge( Integer.parseInt(request.getParameter("age")) );
		
	  try {
		  MemberDao memberDao = new MemberDao();
			int count = memberDao.insert(member);
			if (count > 0) {
				request.setAttribute("message", "등록 성공입니다!");
			} else {
				request.setAttribute("message", "등록 실패입니다!");
			}
			
			RequestDispatcher rd = request.getRequestDispatcher(
					"add.jsp");
			rd.forward(request, response);
			
	  } catch (Exception e) {
	  		e.printStackTrace();
	  		request.setAttribute("error", e);
	  		RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
		  rd.forward(request, response);
	  }
	}
}












