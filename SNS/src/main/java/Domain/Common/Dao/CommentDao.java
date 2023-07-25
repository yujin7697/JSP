package Domain.Common.Dao;

import java.util.List;

import Domain.Common.Dto.CommentDto;

public interface CommentDao {

	//	��� ��ȸ
	List<CommentDto> select() throws Exception;

	//	��� �ۼ� 
	int insert(CommentDto dto, String role) throws Exception;

	//	��� ����
	int update(CommentDto dto) throws Exception;

	//	��� ����
	int delete(String id) throws Exception;

}