package Controller.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Common.Dto.BoardDto;
import Domain.Common.Service.BoardService;
import Domain.Common.Service.BoardServiceImpl;

public class BoardController implements SubController{

	private static final BoardDto Dto = null;
	private BoardService service; // �Ķ���͸� ����Һ񽺷� �����ϱ� ���� ���� ����

	public BoardController() {
		service = BoardServiceImpl.getInstance();
	}

	// 1 Select , 2 Insert , 3 Update , 4 Delete
	public Map<String, Object> execute(int serviceNo, Map<String, Object> param) {

		if (serviceNo == 1) {// select
			// 1 �Ķ���� ����(����)
			// 2 �Է°� ����(����)
			// 3 ���� ����(���񽺸���۾� ���� ó��)
			List<BoardDto> list = null;
			try {
				list = service.getAllBoard();
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 4 View�� ����
			System.out.println("Board_Select Block");
			Map<String, Object> result = new HashMap();
			result.put("result", list);

			return result;
		} else if (serviceNo == 2) {
			//1 �Ķ���� ����
			Integer number = (Integer) param.get("number");
			String id = (String) param.get("id");
			String title = (String) param.get("title");
			String contents = (String) param.get("contents");
			String date = (String) param.get("date");
			Integer hits = (Integer) param.get("hits");
			//2 �Է°� ����
			if (number == null || id == null || title == null || contents == null || date == null || hits == null) {
				System.out.println("[ERROR] Data Validation Check Error!");
				return null;
			}
			//3 ���� ����
			BoardDto dto = new BoardDto(number, id, title, contents, date, hits);
			System.out.println("Dto + " + dto);

			Boolean rValue = false;
			try {
				rValue = service.boardAdd(dto);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//4 view�� ����
			System.out.println("Board_Insert Block!");
			Map<String, Object> result = new HashMap();
			result.put("result", rValue);
			return result;
		} else if (serviceNo == 3) { // update
			//1 �Ķ���� ����
			Integer number = (Integer) param.get("number");
			String id = (String) param.get("id");
			String title = (String) param.get("title");
			String contents = (String) param.get("contents");
			String date = (String) param.get("date");
			Integer hits = (Integer) param.get("hits");
			//2 �Է°� ����
			if (number == null || id == null || title == null || contents == null || date == null || hits == null) {
				System.out.println("[ERROR] Data Validation Check Error!");
				return null;
			}
			//3 ���� ����
			BoardDto dto = new BoardDto(number, id, title, contents, date, hits);
			System.out.println("Dto : " + dto);
			Boolean rValue = false;

			try {
				rValue = service.boardUpdate(dto, id, number);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//4 view�� ����
			System.out.println("Board_Update Block");
			Map<String, Object> result = new HashMap();
			result.put("result", rValue);
			return result;
		} else if (serviceNo == 4) { // delete
			//1 �Ķ���� ����
			Integer number = (Integer) param.get("number");
			String id = (String) param.get("id");
			String role = (String) param.get("role");
			//2 �Է°� ����
			if (number == null || id == null || role == "MEMBER") {
				System.out.println("[ERROR] Data Validation Check Error!");
				return null;
			}
			//3 ���� ����

			Boolean rValue = false;
			try {
				rValue = service.boardDelete(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//4 view�� ����
			System.out.println("Board_Delete Block");
			Map<String, Object> result = new HashMap();
			result.put("result", rValue);
			return result;
		}
		return null;

	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

}