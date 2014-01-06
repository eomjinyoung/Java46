package spms.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import spms.dao.MemberDao;

@WebServlet("/member/delete")
public class MemberDeleteServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response)
	    throws ServletException, IOException {
		//URL => http://localhost:9999/web01/member/delete?no=3
		int no = Integer.parseInt( request.getParameter("no") );
		
		response.setContentType("text/plain;charset=UTF-8");
	  PrintWriter out = response.getWriter();
	  
	  try {
		  MemberDao memberDao = new MemberDao();
			int count = memberDao.delete(no);
			if (count > 0) {
				out.println("삭제 성공입니다.");
			} else {
				out.println("해당 번호의 멤버가 없습니다!");
			}
	  } catch (Exception e) {
	  		e.printStackTrace();
	  		out.println("실행 중 오류발생!");
	  }
	}
}



