package spms.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import spms.dao.MemberDao;
import spms.vo.Member;

public class MemberListServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response)
	    throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	  PrintWriter out = response.getWriter();
	  
	  try {
		  MemberDao memberDao = new MemberDao();
			ArrayList<Member> members = memberDao.selectList();
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='UTF-8'>");
			out.println("<title>회원 목록</title>");
			out.println("</head>");
			out.println("<body>");
			
			out.println("----------------------------<br>");
			out.println("번호 \t 이름 \t 나이 \t 전화<br>");
			out.println("----------------------------<br>");
			
			// * 링크 마크업 
			// <a href='http://localhost:9999/web01/member/read?no=3'>내용</a>
			for (Member member : members) {
				out.print(member.getNo() + "\t");
				out.print(
						"<a href='read?no=" 
						+ member.getNo() 	+ "'>"
						+ member.getName() 
						+ "</a>\t");
				out.print(member.getAge() + "\t");
				out.println(member.getTel() + "<br>");
			}
			
			out.println("</body>");
			out.println("</html>");
			
	  } catch (Exception e) {
	  		e.printStackTrace();
	  		out.println("실행 중 오류발생!");
	  }
	}
}




