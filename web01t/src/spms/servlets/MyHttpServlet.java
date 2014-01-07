package spms.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class MyHttpServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response)
	    throws ServletException, IOException {
		
		HttpServletRequest request2 = (HttpServletRequest) request;
		HttpServletResponse response2 = (HttpServletResponse) response;
		
		if (request2.getMethod().equals("POST")) {
			doPost(request2, response2);
			
		} else {
			doGet(request2, response2);
		}
	}
	
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	  PrintWriter out = response.getWriter();
	  
	  out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>회원등록</title>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("GET 요청을 처리할 수 없습니다.");
		
		out.println("</body>");
		out.println("</html>");
	}
	
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	  PrintWriter out = response.getWriter();
	  
	  out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>회원등록</title>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("POST 요청을 처리할 수 없습니다.");
		
		out.println("</body>");
		out.println("</html>");
	}

}



