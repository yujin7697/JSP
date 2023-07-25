package Domain.Common.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import Domain.Common.Dao.MemberDao;
import Domain.Common.Dao.MemberDaoImpl;
import Domain.Common.Dto.MemberDto;
import Domain.Common.Service.Auth.Session;

public class MemberServiceImpl implements MemberService {

	public Map<String, Object> sessionMap;

	private MemberDao dao;

	private static MemberServiceImpl instance;

	public static MemberServiceImpl getInstance() {
		if (instance == null)
			instance = new MemberServiceImpl();
		return instance;
	}

	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
		sessionMap = new HashMap();
	}

//	ȸ�� �����ϱ�
	@Override
	public boolean Join(MemberDto dto) throws Exception {
		int result = dao.insert(dto);
		if (result > 0)
			return true;
		return false;
	}

//	ȸ�� ��ȸ(��ü) - ������
	@Override
	public List<MemberDto> memberSearch(String role) throws Exception {
		if (role.equals("MASTER"))
			return dao.select("id", "pw");
		return null;
	}

//	ȸ�� �����ϱ�
	@Override
	public boolean memberDelete(String id, String role) throws Exception {
		Session session = (Session) sessionMap.get(role);
		if (role == "MASTER" || session.getId().equals(id)) {
			int result = dao.delete(id);
			if (result > 0)
				return true;
		}
		return false;

	}

//	�α���
	@Override
	public Map<String, Object> login(String id, String pw) throws Exception {
//		1. id/pw üũ -> Dao ���޹��� id�� ��ġ�ϴ� ������ �����ͼ� pw��ġ Ȯ��
		MemberDto dto = (MemberDto) dao.select(id, pw);
		if (dto == null) {
			System.out.println("[ERROR");
			return null;
		}

		if (!pw.equals(dto.getPw())) {
			System.out.println("[ERROR]");
			return null;
		}

//		2. �ش� ����ڿ� ���� ������(Session)�� MemberService�� ����
		String role = UUID.randomUUID().toString();
		Session session = new Session(dto.getId(), dto.getPw(), dto.getRole());
		sessionMap.put(role, session);
//		3. ���ǿ� ���� ������ Ŭ���̾�Ʈ�� ������ �� �ֵ��� �ϴ� ���� ���� id(Session Cookie)����
		Map<String, Object> result = new HashMap();
		result.put("id", id);
		result.put("pw", pw);
		result.put("role", role);
		return result;
	}

//	�α׾ƿ�
	@Override
	public Boolean logout(String id, String pw, String role) {

		Session session = (Session) sessionMap.get(role);
		if (id == null || pw == null) {
			System.out.println("[ERROR");
			return false;
		}
		sessionMap.remove(role);
		return null;

	}

//	���� ��ȯ �Լ�(ȸ������ ����������)
	@Override
	public String getRole(String role) {
		Session session = (Session) sessionMap.get(role);
		if (session.equals("MASTER")) {
			return session.getRole();
		}

		return null;
	}

}