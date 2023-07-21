package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet_Test02")

public class C02Servlet_Test extends HttpServlet{
	int i = 1;
	@Override
	public void init() throws ServletException {
		//최조 1회 실행
		System.out.println("Init!");
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		//요청시마다 동작!_!!!_!!!!!
		//arg0에 연결된 객체는 httpServletRequest로 만들어진 request객체의 주소
		//그 HttpServletRequest객체를 사위인터페이스 참조 변수인 arg0로 받는 파라미터
		HttpServletResponse response = (HttpServletResponse) arg1;
		PrintWriter out = response.getWriter();
		out.write("helloworld"+(i++));
		System.out.println("Service");
	}

	@Override
	public void destroy() {
		//서비스 종료,재시작 코드수정시
		System.out.println("Destroy");
	}

}
