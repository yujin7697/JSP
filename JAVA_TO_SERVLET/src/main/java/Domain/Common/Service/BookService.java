package Domain.Common.Service;

import java.util.List;

import Domain.Common.Dto.BookDto;

public interface BookService {

	// 도서조회하기(비회원/회원/사서)
	List<BookDto> getAllBook() throws Exception;

	BookDto getBook(int bookcode) throws Exception;

	// 도서등록하기(사서)
	boolean addBook(BookDto dto, String sid) throws Exception;

	// 도서수정하기
	boolean updateBook(BookDto dto, String sid) throws Exception;

	// 도서삭제하기
	boolean removeBook(int bookcode, String sid) throws Exception;

}