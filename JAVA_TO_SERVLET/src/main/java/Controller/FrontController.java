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

public class FrontController extends HttpServlet {

	private Map<String, SubController> map = new HashMap();
	// 초기값 설정
	// 사용자요구사항API Controller에 맞게 저장
	// /req_bookinfo에대한 요구사항은 BookController 전달

	@Override
	public void init(ServletConfig config) throws ServletException {
		
		String projectPath = config.getServletContext().getContextPath(); // /JAVA_TO_SERVLET
		
//		book
		map.put(projectPath+"/book/search.do", new BookSearchController() );
		map.put(projectPath+"/book/add.do", new BookAddController() );
		map.put(projectPath+"/book/update.do", new BookUpdateController() );
		map.put(projectPath+"/book/delete.do", new BookDeleteController() );
//		lend
		
//		member
		
//		member.auth
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("FrontController's service uri : " + req.getRequestURI());
//		SubController controller = map.get(request);
//
//		Map<String, Object> result = new HashMap();
//		result = controller.execute(ServiceNo, param);

	}
	
}
