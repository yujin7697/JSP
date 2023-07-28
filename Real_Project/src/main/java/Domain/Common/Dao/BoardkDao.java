package Domain.Common.Dao;

import java.util.List;

import Domain.Common.Dto.BoardkDto;

public interface BoardkDao {

	//CRUD
	int insert(BoardkDto dto) throws Exception;

	List<BoardkDto> select() throws Exception;

	BoardkDto select(int bookcode) throws Exception;

	List<BoardkDto> select(String keyword);

	List<BoardkDto> select(String keyfield, String keyword);

	int update(BoardkDto dto) throws Exception;

	int delete(int bookcode) throws Exception;

}