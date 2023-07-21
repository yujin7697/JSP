package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet LoginServlet 시작!");
		req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost LoginServlet 시작!");
		
		
		String userid = req.getParameter("userid");
		String pwd = req.getParameter("pwd");
		
		System.out.println("userid : " + userid);
		System.out.println("pwd : " + pwd);
		
		PrintWriter out = resp.getWriter();
		out.print("userid : " + userid);
		out.print("pwd : " + pwd);
	}
}
