package Domain.Common.Dao;

import java.util.ArrayList;
import java.util.List;

import Domain.Common.Dto.BoardDto;

public class BoardDaoImpl extends ConnectionPool implements BoardDao {

	// �̱��� ����
	private static BoardDao instance;

	public static BoardDao getInstance() {
		if (instance == null)
			instance = new BoardDaoImpl();
		return instance;
	}

	private BoardDaoImpl() {

	}

//		CURD
//	�� �ۼ�
	@Override
	public int insert(BoardDto dto, String role) throws Exception {
		pstmt = conn.prepareStatement("insert into tbl_board values (null,?,?,?,now(),null)");

		pstmt.setString(1, dto.getId());
		pstmt.setString(2, dto.getTitle());
		pstmt.setString(3, dto.getContents());

		return pstmt.executeUpdate();
	}

//	��ü�� ��ȸ
	@Override
	public List<BoardDto> select() throws Exception {
		List<BoardDto> list = new ArrayList();
		BoardDto dto = null;
		pstmt = conn.prepareStatement("select * from tbl_board");
		rs = pstmt.executeQuery();
		if (rs != null) {
			while (rs.next()) {
				dto = new BoardDto();
				dto.setNumber(rs.getInt("number"));
				dto.setId(rs.getString("id"));
				dto.setTitle(rs.getString("title"));
				dto.setContents(rs.getString("contents"));
				dto.setDate(rs.getString("date"));
				dto.setHits(rs.getInt("hits"));
				list.add(dto);
			}
		}
		return list;
	}

	// �� �ϳ� ��ȸ(number�� ��ȸ)
	@Override
	public BoardDto select_one(int number) throws Exception {

		BoardDto dto = null;
		pstmt = conn.prepareStatement("select * from tbl_contents where number = ?");
		pstmt.setInt(1, number);
		rs = pstmt.executeQuery();
		if (rs != null) {
			rs.next();
			dto = new BoardDto();
			dto.setNumber(rs.getInt("number"));
			dto.setId(rs.getString("id"));
			dto.setTitle(rs.getString("title"));
			dto.setDate(rs.getString("date"));
			dto.setHits(rs.getInt("hits"));
			rs.close();
		}
		pstmt.close();
		return dto;
	}

//	id �� title�� �� ��ȸ
	@Override
	public List<BoardDto> search_id(String id) throws Exception {
		List<BoardDto> list = new ArrayList();
		BoardDto dto = null;
		pstmt = conn.prepareStatement("select * from tbl_board where id = ?");
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		if (rs != null) {
			rs.next();
			dto = new BoardDto();
			dto.setNumber(rs.getInt("number"));
			dto.setId(rs.getString("id"));
			dto.setTitle(rs.getString("title"));
			dto.setDate(rs.getString("date"));
			dto.setHits(rs.getInt("hits"));
			rs.close();
		}
		pstmt.close();
		return list;
	}

	@Override
	public List<BoardDto> search_title(String title) throws Exception {
		List<BoardDto> list = new ArrayList();
		BoardDto dto = null;
		pstmt = conn.prepareStatement("select * from tbl_board where title = ?");
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		if (rs != null) {
			rs.next();
			dto = new BoardDto();
			dto.setNumber(rs.getInt("number"));
			dto.setId(rs.getString("id"));
			dto.setTitle(rs.getString("title"));
			dto.setDate(rs.getString("date"));
			dto.setHits(rs.getInt("hits"));
			rs.close();
		}
		pstmt.close();
		return list;
	}

//	���� �� �� ��ȸ
	@Override
	public List<BoardDto> search_mine(String id) throws Exception {
		List<BoardDto> list = new ArrayList();
		BoardDto dto = null;
		pstmt = conn.prepareStatement("select * from tbl_board where id = ?");
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		if (rs != null) {
			rs.next();
			dto = new BoardDto();
			dto.setNumber(rs.getInt("number"));
			dto.setId(rs.getString("id"));
			dto.setTitle(rs.getString("title"));
			dto.setDate(rs.getString("date"));
			dto.setHits(rs.getInt("hits"));
			rs.close();
		}
		pstmt.close();
		return list;
	}

//	���� �� �� ����
	@Override
	public int update(BoardDto dto) throws Exception {
		pstmt = conn.prepareStatement("update tbl_board set title=?,contents=?");
		pstmt.setString(3, dto.getTitle());
		pstmt.setString(4, dto.getContents());

		return pstmt.executeUpdate();
	}

//	���� �� �� ����
	@Override
	public int delete(String id) throws Exception {
		pstmt = conn.prepareStatement("delete from tbl_board where id = ?");
		pstmt.setString(1, id);
		int result = pstmt.executeUpdate();
		pstmt.close();

		return result;
	}

}