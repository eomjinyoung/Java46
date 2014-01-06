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

@WebServlet("/member/add")
public class MemberAddServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response)
	    throws ServletException, IOException {
		//URL => .../web01/member/add?name=aaa&email=bbb&tel=cccc&age=10
		Member member = new Member();
		member.setName( request.getParameter("name") );
		member.setEmail( request.getParameter("email") );
		member.setTel( request.getParameter("tel") );
		member.setAge( Integer.parseInt(request.getParameter("age")) );
		
		response.setContentType("text/plain;charset=UTF-8");
	  PrintWriter out = response.getWriter();
	  
	  try {
		  MemberDao memberDao = new MemberDao();
			memberDao.insert(member);
			out.println("등록 성공입니다.");
	  } catch (Exception e) {
	  		e.printStackTrace();
	  		out.println("실행 중 오류발생!");
	  }
	}
}




