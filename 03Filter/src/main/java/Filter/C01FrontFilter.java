package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter("/login.do")
public class C01FrontFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resq, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("C01FrontFilter 시작!");
		
		chain.doFilter(req,resq);
		System.out.println("C01FrontFilter 끝!!");
		
	}
	
}
