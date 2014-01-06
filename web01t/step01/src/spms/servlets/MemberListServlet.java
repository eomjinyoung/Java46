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
		response.setContentType("text/plain;charset=UTF-8");
	  PrintWriter out = response.getWriter();
	  
	  try {
		  MemberDao memberDao = new MemberDao();
			ArrayList<Member> members = memberDao.selectList();
			out.println("----------------------------");
			out.println("번호 \t 이름 \t 나이 \t 전화");
			out.println("----------------------------");
			
			for (Member member : members) {
				out.print(member.getNo() + "\t");
				out.print(member.getName() + "\t");
				out.print(member.getAge() + "\t");
				out.println(member.getTel());
			}
	  } catch (Exception e) {
	  		e.printStackTrace();
	  		out.println("실행 중 오류발생!");
	  }
	}
}




