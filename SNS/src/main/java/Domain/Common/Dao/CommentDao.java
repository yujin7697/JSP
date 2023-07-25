package Domain.Common.Dao;

import java.util.List;

import Domain.Common.Dto.CommentDto;

public interface CommentDao {

	//	´ñ±Û Á¶È¸
	List<CommentDto> select() throws Exception;

	//	´ñ±Û ÀÛ¼º 
	int insert(CommentDto dto, String role) throws Exception;

	//	´ñ±Û ¼öÁ¤
	int update(CommentDto dto) throws Exception;

	//	´ñ±Û »èÁ¦
	int delete(String id) throws Exception;

}