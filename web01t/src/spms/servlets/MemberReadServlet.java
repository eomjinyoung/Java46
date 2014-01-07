package spms.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spms.dao.MemberDao;
import spms.vo.Member;

@WebServlet("/member/read")
public class MemberReadServlet extends HttpServlet {
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
		out.println("<title>회원정보</title>");
		out.println("</head>");
		out.println("<body>");
		
	  try {
		  MemberDao memberDao = new MemberDao();
			Member member = memberDao.selectOne(no);
			
			if (member != null) {
				out.println("<h1>회원 정보</h1>");
				out.println("<form action='update' method='post'>");
				out.println("번호: <input readonly type='text' name='no' value='" 
						+ member.getNo() + "'><br>");
				out.println(	"이름: <input type='text' name='name' value='" 
						+ member.getName() + "'><br>");
				out.println("이메일: <input type='text' name='email' value='" 
						+ member.getEmail() + "'><br>");
				out.println("전화: <input type='tel' name='tel' value='" 
						+ member.getTel() + "'><br>");
				out.println("나이: <input type='text' name='age' value='" 
						+ member.getAge() + "'><br>");
				out.println("<input type='submit' value='변경'>");
				out.println("<a href='delete?no=" + no + "'>[삭제]</a><br>");
				out.println("</form>");
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




