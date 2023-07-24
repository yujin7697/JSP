package Domain.Common.Service;

public interface LendService {

	//외부로부터 Service받기
	void setMemberService(MemberService memService);

	void setBookService(BookService bookService);

	boolean reqLend(String sid, String userid, int bookcode) throws Exception;

}