package Controller.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Common.Dto.BoardDto;
import Domain.Common.Service.BoardService;
import Domain.Common.Service.BoardServiceImpl;

//public class BoardUpdateController implements SubController {
//
//    private BoardService service = BoardServiceImpl.getInstance();
//
//    @Override
//    public void execute(HttpServletRequest req, HttpServletResponse resp) {
//        System.out.println("BoardUpdateController execute");
//
//        try {
//            int boardNumber = Integer.parseInt(req.getParameter("boardNumber"));
//            String contents = req.getParameter("contents");
//
//            // 게시물 수정
//            BoardDto board = new BoardDto();
//            board.setNumber(boardNumber);
//            board.setContents(contents);
//
//            // 수정 처리
//            boolean isUpdated = service.boardUpdate(board, contents, boardNumber);
//
//            if (isUpdated) {
//                // 수정이 성공하면 마이페이지로 리다이렉트
//                resp.sendRedirect(req.getContextPath() + "/mypage.do");
//            } else {
//                // 수정 실패 시 에러 페이지 또는 다른 처리 방법을 선택하여 구현
//                // 예: 에러 메시지를 출력하거나 다시 수정 폼으로 이동
//                resp.getWriter().write("게시물 수정에 실패했습니다.");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            // 예외 발생 시 에러 페이지 또는 다른 처리 방법을 선택하여 구현
//            // 예: 에러 메시지를 출력하거나 다시 수정 폼으로 이동
//            try {
//				resp.getWriter().write("게시물 수정 중 오류가 발생했습니다.");
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//        }
//    }
//}
public class BoardUpdateController implements SubController {
    private BoardService service = BoardServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("BoardUpdateController execute");

        try {
            int boardNumber = Integer.parseInt(req.getParameter("number"));
            String contents = req.getParameter("contents");

            // 게시물 수정
            BoardDto board = new BoardDto();
            board.setNumber(boardNumber);
            board.setContents(contents);

            // 수정 처리
            boolean isUpdated = service.boardUpdate(board, contents, boardNumber);

            if (isUpdated) {
                // 수정이 성공하면 JSON 응답으로 성공 메시지 전송
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                PrintWriter out = resp.getWriter();
                out.write("{\"success\": true}");
                out.flush();
            } else {
                // 수정 실패 시 JSON 응답으로 실패 메시지 전송
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                PrintWriter out = resp.getWriter();
                out.write("{\"success\": false}");
                out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
            // 예외 발생 시 에러 메시지 JSON 응답 전송
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            PrintWriter out = null;
			try {
				out = resp.getWriter();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            out.write("{\"success\": false}");
            out.flush();
        }
    }
}