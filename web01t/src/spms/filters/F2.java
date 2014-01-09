package spms.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class F2 implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("F2: init()");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
	    FilterChain chain) throws IOException, ServletException {
		System.out.println("F2: before doFilter()");
		
		chain.doFilter(request, response);
		
		System.out.println("F2: after doFilter()");

	}

	@Override
	public void destroy() {
		System.out.println("F2: destroy()");

	}

}





