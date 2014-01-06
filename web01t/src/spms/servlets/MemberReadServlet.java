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

@WebServlet("/member/read")
public class MemberReadServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response)
	    throws ServletException, IOException {
		//URL => http://localhost:9999/web01/member/read?no=3&name=aaa
		int no = Integer.parseInt( request.getParameter("no") );
		
		response.setContentType("text/html;charset=UTF-8");
	  PrintWriter out = response.getWriter();
	  
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>회원정보</title>");
		out.println("</head>");
		out.println("<body>");
		
	  try {
		  MemberDao memberDao = new MemberDao();
			Member member = memberDao.selectOne(no);
			
			if (member != null) {
				out.println("<h1>회원 정보</h1>");
				out.println("번호:" + member.getNo() + "<br>");
				out.println(	"이름:" + member.getName() + "<br>");
				out.println("이메일:" + member.getEmail() + "<br>");
				out.println("전화:" + member.getTel() + "<br>");
				out.println("나이:" + member.getAge() + "<br>");
				out.println("<a href='delete?no=" + no + "'>[삭제]</a><br>");
				
			} else {
				out.println("해당 번호의 멤버가 없습니다!");
			}
	  } catch (Exception e) {
	  		e.printStackTrace();
	  		out.println("실행 중 오류발생!");
	  }
	  
	  out.println("</body>");
		out.println("</html>");
	}
}




