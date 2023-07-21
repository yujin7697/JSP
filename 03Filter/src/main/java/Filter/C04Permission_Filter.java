package Filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import Type.Role;

public class C04Permission_Filter implements Filter{

//	페이지별 권한정보 저장 Map
//	/user.do - Role.ROLE_USER
//	/admin.do - Role.ROLE_ADMIN
	Map<String,Role> pageGradeMap = new HashMap();
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String path = filterConfig.getServletContext().getContextPath();
		pageGradeMap.put(path + "/user.do", Role.ROLE_USER);	// 0
		pageGradeMap.put(path + "/admin.do", Role.ROLE_ADMIN);	// 1
	}
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
//		전
		System.out.println("C04Permission_Filter 시작!");
		
//		세션에서 Role 가져오기
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		Role userRole = (Role)session.getAttribute("ROLE");
		if(userRole == null) {
			throw new ServletException("Role이 없어요오옹,,,");
		}
		
//		Map에서 Page별 Role 가져오기
		String reqUri = req.getRequestURI();		//URL : http://localhost:8080/C01JSP/index.html
		Role pageRole = pageGradeMap.get(reqUri);	//URI : C01JSP/index.html
		
		if(userRole.ordinal()<pageRole.ordinal()) {
			throw new ServletException("권한이 부족한 계정으로 페이지 요청을 해요오오ㅗ오옹ㅇ");
		}
								
		chain.doFilter(request,response);
//		후
		System.out.println("C04Permission_Filter 끝!");
	}
	
}
