package Domain.Common.Dto;

public class BoardDto {
	private int number; 		//�Խù� ��ȣ
	private String id;  		//userid 
	private String title;		//������
	private String contents;	//�۳���
	private String date;		//�ۼ���¥
	private int hits;			//��ȸ��
	
//	����Ʈ ������
	public BoardDto() {}
	
//	��� ���ڸ� �޴� ������
	public BoardDto(int number, String id, String title, String contents, String date, int hits) {
		this.number = number;
		this.id = id;
		this.title = title;
		this.contents = contents;
		this.date = date;
		this.hits = hits;
	}

//	toString ������
	@Override
	public String toString() {
		return "ContentsDto [number=" + number + ", id=" + id + ", title=" + title + ", contents=" + contents
				+ ", date=" + date + ", hits=" + hits + "]";
	}

//	getter and setter
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	
	
	
}