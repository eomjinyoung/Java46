package spms.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spms.dao.MemberDao;

@WebServlet("/member/delete")
public class MemberDeleteServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

	@Override
	public void doGet(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		int no = Integer.parseInt( request.getParameter("no") );
		
		response.setContentType("text/html;charset=UTF-8");
	  PrintWriter out = response.getWriter();
	  
	  out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<meta http-equiv='Refresh' content='1;url=list'>");
		out.println("<title>회원삭제</title>");
		out.println("</head>");
		out.println("<body>");
	  
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
	  
	  out.println("</body>");
		out.println("</html>");
	}
}




