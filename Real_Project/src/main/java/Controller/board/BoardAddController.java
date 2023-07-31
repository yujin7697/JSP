package Controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Common.Dao.BoardDao;
import Domain.Common.Dao.BoardDaoImpl;
import Domain.Common.Dto.BoardDto;
import Domain.Common.Service.BoardService;
import Domain.Common.Service.BoardServiceImpl;

@WebServlet("/board/add.do")
public class BoardAddController extends HttpServlet implements SubController {

	private BoardService service = BoardServiceImpl.getInstance();
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("BoardAddController doPost");
		String title = req.getParameter("title");
		String contents = req.getParameter("contents");
		if(title.isEmpty()||contents.isEmpty()) {
			req.setAttribute("msg", "제목 또는 내용을 입력해주세요.");
			req.getRequestDispatcher("/board/add.jsp").forward(req, resp);
			return;
		}
		BoardDto bdto = new BoardDto();
		bdto.setTitle(title);
		bdto.setContents(contents);
		
		BoardDao bdao = BoardDaoImpl.getInstance();
		try {
			int result = bdao.insert(bdto);
			if(result>0) {
				req.setAttribute("msg", "게시물이 작성되었습니다.");
				req.getRequestDispatcher("/WEB-INF/view/main.jsp").forward(req, resp);
			} else {
				req.setAttribute("msg", "게시물 작성 중 오류가 발생했습니다.");
				req.getRequestDispatcher("/board/add.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			req.setAttribute("msg", "오류가 발생하여 회원 가입에 실패했습니다.");
            req.getRequestDispatcher("/board/add.jsp").forward(req, resp);
		}
		
//		super.doPost(req, resp);
	}


	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
	

		
	}

}
