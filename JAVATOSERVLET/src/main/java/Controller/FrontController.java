package Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.book.BookAddController;
import Controller.book.BookDeleteController;
import Controller.book.BookSearchController;
import Controller.book.BookUpdateController;
import Controller.lend.LendAddController;
import Controller.lend.LendDeleteController;
import Controller.lend.LendSearchController;
import Controller.lend.LendUpdateController;
import Controller.member.MemberAddController;
import Controller.member.MemberDeleteController;
import Controller.member.MemberPageController;
import Controller.member.MemberSearchController;
import Controller.member.MemberUpdateController;
import Controller.member.auth.LoginController;
import Controller.member.auth.LogoutController;

public class FrontController extends HttpServlet {

	private Map<String, SubController> map = new HashMap();
	// 초기값 설정
	// 사용자요구사항API Controller에 맞게 저장
	// /req_bookinfo에대한 요구사항은 BookController 전달

	@Override
	public void init(ServletConfig config) throws ServletException {
		
		String projectPath=config.getServletContext().getContextPath(); // /JAVA_TO_SERVLET/
		
		//book
		map.put(projectPath+"/book/search.do", new BookSearchController());
		map.put(projectPath+"/book/add.do", new BookAddController());
		map.put(projectPath+"/book/update.do", new BookUpdateController());
		map.put(projectPath+"/book/delete.do", new BookDeleteController());
		
		//lend
		map.put(projectPath+"/lend/search.do", new LendSearchController());
		map.put(projectPath+"/lend/add.do", new LendAddController());
		map.put(projectPath+"/lend/update.do", new LendUpdateController());
		map.put(projectPath+"/lend/delete.do", new LendDeleteController());		
		
		//member
		map.put(projectPath+"/member/search.do", new MemberSearchController());
		map.put(projectPath+"/member/add.do", new MemberAddController());
		map.put(projectPath+"/member/update.do", new MemberUpdateController());
		map.put(projectPath+"/member/delete.do", new MemberDeleteController());		
		
		//member.auth
		map.put(projectPath+"/login.do", new LoginController());		
		map.put(projectPath+"/logout.do", new LogoutController());
		//mypage
		map.put(projectPath+"/mypage.do", new MemberPageController());
		
		//main
		map.put(projectPath+"/main.do",new MainController());

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        
		System.out.println("FrontController's service Uri : " + req.getRequestURI());// 
		
		SubController controller = map.get(req.getRequestURI());
		controller.execute(req, resp);

		
	}



}