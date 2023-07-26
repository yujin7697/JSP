package Domain.Common.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import Domain.Common.Dto.MemberDto;

public interface MemberService {

//	회원가입
	boolean Join(MemberDto dto) throws Exception;

//	회원조회(전체) - 관리자
	List<MemberDto> memberSearch(String role) throws Exception;

//	회원삭제
	boolean memberDelete(String id, String role) throws Exception;

//	로그인
	boolean login(HttpServletRequest req) throws Exception;

//	로그아웃
	boolean logout(String id, String pw, String role);

//	역할반환함수
	String getRole(String role);

}