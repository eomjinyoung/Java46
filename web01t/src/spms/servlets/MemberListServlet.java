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
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>회원 목록</title>");
		out.println("</head>");
		out.println("<body>");
		
	  try {
		  MemberDao memberDao = new MemberDao();
			ArrayList<Member> members = memberDao.selectList();
			
			out.println("<h1>회원 목록</h1>");
			out.println("<a href='NewMember.html'>[새회원]</a><br>");
			out.println("<table border='1'>");
			out.println("<tr>");
			out.println("<th>번호</th>");
			out.println("<th>이름</th>");
			out.println("<th>나이</th>");
			out.println("<th>전화</th>");
			out.println("</tr>");
			
			// * 링크 마크업 
			// <a href='http://localhost:9999/web01/member/read?no=3'>내용</a>
			for (Member member : members) {
				out.print("<tr>");
				out.print("<td>" + member.getNo() + "</td>");
				out.print("<td><a href='read?no=" 
						+ member.getNo() 	+ "'>"
						+ member.getName() 
						+ "</a></td>");
				out.print("<td>" + member.getAge() + "</td>");
				out.print("<td>" + member.getTel() + "</td>");
				out.print("</tr>");
			}
			out.println("</table>");
	  } catch (Exception e) {
	  		e.printStackTrace();
	  		out.println("실행 중 오류발생!");
	  }
	  
	  out.println("</body>");
		out.println("</html>");
	}
}




