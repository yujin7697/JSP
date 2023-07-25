package Domain.Common.Dao;

import java.util.List;

import Domain.Common.Dto.BoardDto;

public interface BoardDao {

	//		CURD
	//	�� �ۼ�
	int insert(BoardDto dto, String role) throws Exception;

	//	��ü�� ��ȸ
	List<BoardDto> select() throws Exception;

	// �� �ϳ� ��ȸ(number�� ��ȸ)
	BoardDto select_one(int number) throws Exception;

	//	id �� title�� �� ��ȸ
	List<BoardDto> search_id(String id) throws Exception;

	List<BoardDto> search_title(String title) throws Exception;

	//	���� �� �� ��ȸ
	List<BoardDto> search_mine(String id) throws Exception;

	//	���� �� �� ����
	int update(BoardDto dto) throws Exception;

	//	���� �� �� ����
	int delete(String id) throws Exception;

}