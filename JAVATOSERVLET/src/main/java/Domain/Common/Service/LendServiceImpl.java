package Domain.Common.Service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import Domain.Common.Dao.LendDao;
import Domain.Common.Dao.LendDaoImpl;
import Domain.Common.Dto.BookDto;
import Domain.Common.Dto.LendDto;
import Domain.Common.Dto.MemberDto;

public class LendServiceImpl implements LendService {
	
	private MemberService memService;
	private BookService bookService;
	private LendDao dao;
	
	
	//싱글톤
	private static LendService instance;
	public static LendService getInstance() {
		if(instance==null)
			instance = new LendServiceImpl();
		return instance;
	}
	//
	
	private LendServiceImpl(){
		dao=LendDaoImpl.getInstance();
		memService = MemberServiceImpl.getInstance();
		bookService = BookServiceImpl.getInstance();
	}
	
	//외부로부터 Service받기
	@Override
	public void setMemberService(MemberService memService) {
		this.memService = memService;
	}
	@Override
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	
	@Override
	public boolean reqLend(HttpServletRequest req) throws Exception {
		//req로부터 userid , Session으로 ROLE 꺼내옴
		String userid = req.getParameter("id");
		String bc = req.getParameter("bookcode");
		int bookcode = Integer.parseInt(bc);
		HttpSession session = req.getSession();

		//사서로그인확인,Role받기
		String role = (String)session.getAttribute("ROLE");
		 
		if(!role.equals("ROLE_MEMBER")) {
			System.out.println("[WARN] 사서만 로그인 할 수 있습니다.");
			req.setAttribute("msg", "[WARN] 사서만 로그인 할 수 있습니다.");
			return false;
		}
		//회원존재유무 확인
		MemberDto dto = memService.memberSearchOne(role, userid);
		
		if(dto!=null)
		{
			//도서존재 유무 확인
			BookDto bdto= bookService.getBook(bookcode);
			if(bdto!=null) {
				//도서가 있다면 대여중인 상태인지 확인(LendDao이용해서 대여중인 책이있는지 조회)
				LendDto ldto=dao.select(bookcode);
				 		
				if(ldto==null) {
					//도서가 대여가능한 상태라면
					dao.insert(new LendDto(0,bookcode,userid,null,null) );
					System.out.println("[INFO] 도서대여 완료되었습니다.");
					req.setAttribute("msg", "[INFO] 도서대여 완료되었습니다.");
					return true;
				}
				System.out.println("[WARN] 요청한 도서는 대여중입니다.");	
				req.setAttribute("msg", "[WARN] 요청한 도서는 대여중입니다.");
				return false;
			}
			System.out.println("[WARN] 해당 도서는 존재하지 않습니다.");
			req.setAttribute("msg", "[WARN] 해당 도서는 존재하지 않습니다.");
			return false;
		}
		System.out.println("[WARN] 해당 회원은 존재하지 않습니다.");
		req.setAttribute("msg", "[WARN] 해당 회원은 존재하지 않습니다.");
		return false;
	}

	@Override
	public List<LendDto> getLendList(HttpServletRequest req) throws SQLException {
//		Session 객체안에서 ID를 추출
//		Dao에 Id를전달해서 id에 맞는 대여정보 받아오기
		
		System.out.println("LendServiceImpl's getLendList");
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("ID");
		List<LendDto> list = dao.select(id);
		return null;
	}
	
	
	
	

}