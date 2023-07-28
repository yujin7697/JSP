package Domain.Common.Dao;

import java.util.List;

import Domain.Common.Dto.MemberDto;

public interface MemberDao {

	//id ����
	String getId();

	//	ȸ�� id/pw ����
	int insert(MemberDto dto) throws Exception;

	MemberDto select(String id) throws Exception;
	// 	ȸ�� id/pw ��ȸ
	List<MemberDto> select(String id, String pw) throws Exception;

	//	ȸ�� id/pw ����
	int delete(String id) throws Exception;

}