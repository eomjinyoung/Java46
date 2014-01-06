package spms.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import spms.dao.MemberDao;
import spms.vo.Member;

@WebServlet("/member/update")
public class MemberUpdateServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response)
	    throws ServletException, IOException {
		//URL => .../web01/member/update?no=3&name=aaa&email=bbb&tel=cccc&age=10
		Member member = new Member();
		member.setNo( Integer.parseInt(request.getParameter("no")) );
		member.setName( request.getParameter("name") );
		member.setEmail( request.getParameter("email") );
		member.setTel( request.getParameter("tel") );
		member.setAge( Integer.parseInt(request.getParameter("age")) );
		
		response.setContentType("text/plain;charset=UTF-8");
	  PrintWriter out = response.getWriter();
	  
	  try {
		  MemberDao memberDao = new MemberDao();
			memberDao.update(member);
			out.println("변경 성공입니다.");
	  } catch (Exception e) {
	  		e.printStackTrace();
	  		out.println("실행 중 오류발생!");
	  }
	}
}




