package Controller.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Common.Dto.MemberDto;
import Domain.Common.Service.MemberService;
import Domain.Common.Service.MemberServiceImpl;

public class MemberController implements SubController{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}
	private MemberService service;

	public MemberController() {
		service = MemberServiceImpl.getInstance();
	}

	// [CRUD]
	// 1 search 2 join 3 Delete 4 login 5 logout

	public Map<String, Object> execute(int serviceNo, Map<String, Object> param) {

		if (serviceNo == 1) { // search
			// �� ����
			String role = (String) param.get("role");
			// �� ����X
			// ���� ����
			List<MemberDto> list = null;
			try {
				list = service.memberSearch(role);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// view�� ����
			System.out.println("Member_Select Block!");
			Map<String, Object> result = new HashMap();
			result.put("result", list);
			return result;
		} else if (serviceNo == 2) { // join
			// �� ����
			String id = (String) param.get("id");
			String pw = (String) param.get("pw");

			// �� ����
			if (id == null || pw == null) {
				System.out.println("[ERROR] Data Validation Check Error!");
				return null;
			}
			// ���� ����
			MemberDto dto = null;
			System.out.println("Dto : " + dto);
			Boolean rValue = false;
			try {
				rValue = service.Join(new MemberDto("id", "pw", "role"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			// view�� ����
			System.out.println("Member_Insert Block!");
			Map<String, Object> result = new HashMap();
			result.put("result", rValue);
			return result;
		} else if (serviceNo == 3) { // delete
			// �� ����
			String id = (String) param.get("id");
			String pw = (String) param.get("pw");
			// �� ����
			if (id == null || pw == null) {
				System.out.println("[ERROR] Data Validation Check Error!");
				return null;
			}
			// ���� ����
			Boolean rValue = false;
			try {
				rValue = service.memberDelete(id, pw);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// view�� ����
			System.out.println("Member_Delete Block!");
			Map<String, Object> result = new HashMap();
			result.put("result", rValue);
			return result;
		} else if (serviceNo == 4) { // login
			// �� ����
			String id = (String) param.get("id");
			String pw = (String) param.get("pw");
			// �� ����
			if (id == null || pw == null) {
				System.out.println("[ERROR] Data Validation Check Error!");
				return null;
			}
			// ���� ����
			Map<String, Object> result = new HashMap();
			String role = null;
			try {
				result = service.login(id,pw);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// view�� ����
			return result;
		} else if (serviceNo == 5) { // logout
			// �� ����
			String id = (String) param.get("id");
			String pw = (String) param.get("pw");
			String role = (String) param.get("role");
			// �� ����
			if (id == null || pw == null) {
				System.out.println("[ERROR] Data Validation Check Error!");
				return null;
			}
			// ���� ����
			Boolean rValue = false;
			try {
				rValue = service.logout(id, pw, role);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// view�� ����
			System.out.println("Member_Logout Block!");
			Map<String, Object> result = new HashMap();
			result.put("result", rValue);
			return result;
		}

		return null;
	}

}