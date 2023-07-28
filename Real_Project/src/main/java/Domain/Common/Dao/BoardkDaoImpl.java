package Domain.Common.Dao;

import java.util.ArrayList;
import java.util.List;

import Domain.Common.Dto.BoardkDto;
 

public class BoardkDaoImpl extends ConnectionPool implements BoardkDao {
	
	//싱글톤 패턴
	private static BoardkDao instance; 
	public static BoardkDao getInstance() {
		if(instance==null)
			instance=new BoardkDaoImpl();
		return instance;
	}
	//
	
	private BoardkDaoImpl(){
		
	}
	
	
	//CRUD
	@Override
	public int insert(BoardkDto dto) throws Exception{
	 
		pstmt=conn.prepareStatement("insert into tbl_book values(?,?,?,?)");
		pstmt.setInt(1, dto.getBookcode());
		pstmt.setString(2, dto.getBookname());
		pstmt.setString(3,dto.getPublisher());
		pstmt.setString(4, dto.getIsbn());
		int result=pstmt.executeUpdate();
		pstmt.close();
		
		return result;
		
	}
	
	@Override
	public List<BoardkDto> select() throws Exception{
		List<BoardkDto> list = new ArrayList();
		BoardkDto dto=null;
		pstmt=conn.prepareStatement("select * from tbl_book");
		rs=pstmt.executeQuery();
		if(rs!=null)
		{
			while(rs.next()) {
				dto=new BoardkDto();
				dto.setBookcode(rs.getInt("bookcode"));
				dto.setBookname(rs.getString("bookname"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setIsbn(rs.getString("isbn"));
				list.add(dto);
			}
			rs.close();
		}
		pstmt.close();
			
		return list;
	}
	@Override
	public BoardkDto select(int bookcode) throws Exception{
		 
		BoardkDto dto=null;
		pstmt=conn.prepareStatement("select * from tbl_book where bookcode=?");
		pstmt.setInt(1, bookcode);
		rs=pstmt.executeQuery();
		if(rs!=null&& rs.isBeforeFirst())
		{
				rs.next();
				dto=new BoardkDto();
				dto.setBookcode(rs.getInt("bookcode"));
				dto.setBookname(rs.getString("bookname"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setIsbn(rs.getString("isbn"));
				 		
				rs.close();
		}
		pstmt.close();
		return dto;
	}	
	
	
	@Override
	public List<BoardkDto> select(String keyword){
		return null;
	}
	@Override
	public List<BoardkDto> select(String keyfield,String keyword){
		return null;
	}
	@Override
	public int update(BoardkDto dto) throws Exception{
		pstmt=conn.prepareStatement("update tbl_book set bookname=?,publisher=?,isbn=? where bookcode=?");
		pstmt.setString(1,dto.getBookname() );
		pstmt.setString(2,dto.getPublisher() );
		pstmt.setString(3,dto.getIsbn());
		pstmt.setInt(4,dto.getBookcode() );
		int result=pstmt.executeUpdate();
		pstmt.close();
		return result;
	}
	@Override
	public int delete(int bookcode)  throws Exception{
		 
		pstmt=conn.prepareStatement("delete from tbl_book where bookcode=?");
		pstmt.setInt(1, bookcode);
		int result=pstmt.executeUpdate();
		pstmt.close();
		return result;
	}
	
	
	
	
	
}
