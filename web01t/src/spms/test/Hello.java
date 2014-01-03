package spms.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// 서블릿 만들기
// 1. javax.servlet.Servlet 인터페이스를 구현한다.
// 2. DD 파일에 서블릿을 등록한다.
public class Hello implements Servlet {
	ServletConfig config;
	
	// 이 클래스의 인스턴스를 만든 후 바로 호출함.
	// - 서블릿이 작업하는데 필요한 준비를 수행.
	// - 딱 한 번만 호출됨.
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	  System.out.println("init()");
	}
	
	// 클라이언트가 이 서블릿에 대해 실행을 요청할 때 마다 호출함.
	// - 일을 수행하는데 필요한 도구 두 개를 넘긴다.
	// 1) ServletRequest : 요청 정보를 다루는 도구
	//					. 요청자의 IP 주소, 포트번호
	//					. 요청자가 보낸 데이터를 꺼내기
	// 2) ServletResponse : 응답 정보를 다루는 도구
	//					. 클라이언트에게 응답하기 위한 출력스트림 얻기
	@Override
	public void service(ServletRequest request, ServletResponse response)
	    throws ServletException, IOException {
	  System.out.println("service()");
	  
	  // 출력할 때 기본 문자셋은 ISO-8859-1이다. => UTF-8로 설정해야 한다.
	  // => 출력스트림을 얻기 전에!
	  response.setContentType("text/plain;charset=UTF-8");
	  PrintWriter out = response.getWriter();
	  out.println("오호라. 바로 이것이여... ");
	}
	
	// 웹 애플리케이션이 멈출 때, 서블릿 컨테이너가 멈출 때 호출함.
	// - 마무리 작업을 할 기회를 줌.
	// - 서블릿이 실행하는 동안 사용한 자원을 해제하는 작업 등.
	@Override
	public void destroy() {
	  System.out.println("destroy()");
	}
	
	// 서블릿 컨테이너가 관리 기능을 수행할 때 가끔 호출.
	// 내부에서도 호출함.
	// - init()에서 받은 ServletConfig 객체를 리턴.
	@Override
	public ServletConfig getServletConfig() {
	  return config;
	}
	
	// 서블릿 컨테이너가 서블릿의 정보를 출력할 때 호출.
	// - 서블릿의 이름 및 역할을 문자열로 린턴.
	@Override
	public String getServletInfo() {
	  return "Hello : 인사하는 서블릿!";
	}
}










