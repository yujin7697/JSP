package Controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Common.Service.BoardkService;
import Domain.Common.Service.BoardServiceImpl;

public class BoardAddController implements SubController{

	private BoardkService service= BoardServiceImpl.getInstance();

	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("BookAddController execute");
		
	}

}
