package Domain.Common.Dto;

public class MemberDto {
	private String id;
	private String pw;
	private String role;

//	�⺻ ������
	public MemberDto() {
	}

// 	role���ڸ� �� ������
	public MemberDto(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
//	��� ���ڸ� �޴� ������
	public MemberDto(String id, String pw, String role) {
		this.id = id;
		this.pw = pw;
		this.role = role;
	}


//	toString ������

//	getter and setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", pw=" + pw + ", role=" + role + "]";
	}
}