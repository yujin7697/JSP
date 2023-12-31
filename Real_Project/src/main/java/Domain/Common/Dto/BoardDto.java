package Domain.Common.Dto;

public class BoardDto {
	private int number; 		//게시물 번호
	private String id;  		//userid 
	private String contents;	//글내용
	private String date;		//작성날짜
	private int hits;			//조회수
	private int like;
	
//	디폴트 생성자
	public BoardDto() {}
	
//	모든 인자를 받는 생성자
	public BoardDto(int number, String id, String contents, String date, int hits, int like) {
		this.number = number;
		this.id = id;
		this.contents = contents;
		this.date = date;
		this.hits = hits;
		this.like = like;
	}

	@Override
	public String toString() {
		return "BoardDto [number=" + number + ", id=" + id + ", contents=" + contents + ", date=" + date + ", hits="
				+ hits + ", like=" + like + "]";
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}


	
	
}