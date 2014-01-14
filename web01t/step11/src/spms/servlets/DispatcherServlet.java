package spms.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spms.controls.PageControl;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

	@Override
	protected void service(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		/* 예) http://localhost:9999/web01/member/list.do?name=aaa&age=20
		 * getServletPath() => /member/list.do
		 * getContextPath() => /web01
		 * getRequestURI() => /web01/member/list.do
		 * getQueryString() => name=aaa&age=20
		 */
		try {
			String servletPath = request.getServletPath();
			HashMap<String,Object> resultMap = new HashMap<String,Object>();
			HashMap<String,Object> paramMap = prepareParameterMap(request);
			
			PageControl pageControl = 
					(PageControl)this.getServletContext().getAttribute(servletPath);
			
			if (pageControl == null) {
				throw new Exception("해당 서비스가 존재하지 않습니다.");
			}
			
			String contentPage = pageControl.execute(paramMap, resultMap);
			
			String refresh = (String)resultMap.get("Refresh");
			if (refresh != null) {
				response.setHeader("Refresh", refresh);
			}
			
			copyFromResultMapToServletRequest(resultMap, request);
			
			request.setAttribute("contentPage", contentPage);
			RequestDispatcher rd = request.getRequestDispatcher("/template.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
	  		request.setAttribute("error", e);
	  		RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
		  rd.forward(request, response);
		}
		
	}

	private void copyFromResultMapToServletRequest(
      HashMap<String, Object> resultMap, HttpServletRequest request) {
		for(String key : resultMap.keySet()) {
			request.setAttribute(key, resultMap.get(key));
		}
  }

	private HashMap<String, Object> prepareParameterMap(
			HttpServletRequest request) {
		HashMap<String,Object> paramMap = new HashMap<String,Object>();
		
		Map<String,String[]> map = request.getParameterMap();
		
		for(String key : map.keySet()) {
			paramMap.put(key, map.get(key)[0]);
		}
	  
		return paramMap;
  }
}
















