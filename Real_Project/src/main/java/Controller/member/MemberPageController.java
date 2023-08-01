package Controller.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.SubController;

public class MemberPageController implements SubController {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {

		try {
			HttpSession session = req.getSession();
			String role = (String) session.getAttribute("ROLE");
			if (role.equals("ROLE_USER")) {
				req.getRequestDispatcher("/WEB-INF/view/member/user.jsp").forward(req, resp);
			} else if (role.equals("ROLE_MEMBER")) {
				req.getRequestDispatcher("mypage.jsp").forward(req, resp);
				// 회원 아이디 가져오기
				String memberId = (String) session.getAttribute("MEMBER_ID");

				// 회원의 작성 게시물 데이터 가져오기
				List<Post> posts = getMemberPosts(memberId);

				// 게시물 데이터를 request에 저장하여 JSP로 전달
				req.setAttribute("posts", posts);

				req.getRequestDispatcher("/WEB-INF/view/member/member.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}