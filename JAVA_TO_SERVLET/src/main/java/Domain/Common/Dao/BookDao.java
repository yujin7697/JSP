package Domain.Common.Dao;

import java.util.List;

import Domain.Common.Dto.BookDto;

public interface BookDao {

	//CRUD
	int insert(BookDto dto) throws Exception;

	List<BookDto> select() throws Exception;

	BookDto select(int bookcode) throws Exception;

	List<BookDto> select(String keyword);

	List<BookDto> select(String keyfield, String keyword);

	int update(BookDto dto) throws Exception;

	int delete(int bookcode) throws Exception;

}