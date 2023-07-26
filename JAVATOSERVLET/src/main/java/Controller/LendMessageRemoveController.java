package Controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Domain.Common.Service.LendService;
import Domain.Common.Service.LendServiceImpl;

public class LendMessageRemoveController implements SubController {

	private LendService service = LendServiceImpl.getInstance();
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
//		1 파라미터
		String userid = req.getParameter("userid");
		System.out.println("LendMessageRemoveController params : "+userid);
//		2 입력값

//		3 서비스 실행
		try {
			boolean isRemoved = service.removeMessage(req);
			PrintWriter out = resp.getWriter();
			out.print(isRemoved);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
//		4 view 전달(data)
	}

}
