package Controller.book;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import Controller.SubController;
import Domain.Common.Dto.BookDto;
import Domain.Common.Service.BookService;
import Domain.Common.Service.BookServiceImpl;

public class BookSearchController implements SubController {

	private BookService service = BookServiceImpl.getInstance();

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("BookSearchController execute");
		// 1 파라미터 추출(keyfield,keyword,criteria)
		
		// 2 입력값 검증(생략)
		
		
		// 3 서비스 실행(서비스모듈작업 이후 처리)
		List<BookDto> list = null;
		try {
		
			list = service.getAllBook(req);
			
			
			// JAVA -> JSON 변환
			ObjectMapper objectMapper = new ObjectMapper();
	        String jsonConverted = objectMapper.writeValueAsString(list);
			
			// 4 View로 전달			
			resp.setContentType("application/json");
			PrintWriter out = resp.getWriter();
			out.print(jsonConverted);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
