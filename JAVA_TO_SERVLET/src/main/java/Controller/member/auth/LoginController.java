package Controller.member.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Common.Service.MemberService;
import Domain.Common.Service.MemberServiceImpl;

public class LoginController implements SubController {

	private MemberService service = MemberServiceImpl.getInstance();

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("LoginController execute!");
		// 1 파라미터 추출
		String id = (String) req.getParameter("id");
		String pw = (String) req.getParameter("pw");
		// 2 입력값 검증
		try {
			if (id == null || pw == null) {
			System.out.println("[ERROR] Data Validation Check Error!");
			req.setAttribute("msg", "[ERROR] ID나 PW 입력해주세요.");
			req.getRequestDispatcher("/login.do").forward(req, resp);
			return;
		}
		// 3 서비스 실행
		// MemberDto dto = new MemberDto(id,pw,null,null);
		boolean isLogin = false;
			isLogin = service.login(req);

			// 4 View로 전달
			if (isLogin) {
//			main.do 이동 - Redirect 
				resp.sendRedirect(req.getContextPath() + "/main.do");
			} else {
//			login.do 이동 - Forward 
				req.getRequestDispatcher("/login.do").forward(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
