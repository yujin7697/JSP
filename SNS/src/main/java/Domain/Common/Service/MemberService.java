package Domain.Common.Service;

import java.util.List;
import java.util.Map;

import Domain.Common.Dto.MemberDto;

public interface MemberService {

	//	ȸ�� �����ϱ�
	boolean Join(MemberDto dto) throws Exception;

	//	ȸ�� ��ȸ(��ü) - ������
	List<MemberDto> memberSearch(String role) throws Exception;

	//	ȸ�� �����ϱ�
	boolean memberDelete(String id, String role) throws Exception;

	//	�α���
	Map<String, Object> login(String id, String pw) throws Exception;

	//	�α׾ƿ�
	Boolean logout(String id, String pw, String role);

	//	���� ��ȯ �Լ�(ȸ������ ����������)
	String getRole(String role);

}