package Controller.lend;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Common.Service.LendService;
import Domain.Common.Service.LendServiceImpl;

public class LendAddController implements SubController {

	LendService service = LendServiceImpl.getInstance();
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("LendAddController execute");
	}

}
