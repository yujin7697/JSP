package Controller.member.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Common.Service.MemberService;
import Domain.Common.Service.MemberServiceImpl;

public class LogoutController implements SubController{

	private MemberService service = MemberServiceImpl.getInstance();
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("LogoutController execute!");		
	}

}
