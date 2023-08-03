package Controller.board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Common.Service.BoardService;
import Domain.Common.Service.BoardServiceImpl;

public class BoardDeleteController implements SubController{

	private BoardService service= BoardServiceImpl.getInstance();

	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("BookDeleteController execute");
		
		try {
            String id = req.getParameter("id");

            // 게시물 삭제
            boolean isDeleted = service.boardDelete(id);

            if (isDeleted) {
                // 삭제 성공 시 메시지를 세션에 저장
                req.getSession().setAttribute("deleteSuccess", true);
            } else {
                // 삭제 실패 시 메시지를 세션에 저장
                req.getSession().setAttribute("deleteFail", true);
            }

            // 게시물 목록 페이지로 리다이렉트
            resp.sendRedirect("mypage.do");
        } catch (Exception e) {
            e.printStackTrace();
            // 예외 발생 시 에러 메시지를 세션에 저장하고 게시물 목록 페이지로 리다이렉트
            req.getSession().setAttribute("deleteError", true);
            resp.sendRedirect("mypage.do");
        }
	}

}
