package Domain.Common.Service;

import java.util.List;

import Domain.Common.Dto.BoardDto;
import Domain.Common.Dto.CommentDto;

public interface BoardService {

	// �� ��� ��ȸ�ϱ�(��ȸ��,ȸ��,������ ���)
	List<BoardDto> getAllBoard() throws Exception;

	// �� �ϳ� ��ȸ
	BoardDto getBoard(int number) throws Exception;

	// �� ����ϱ�(ȸ��)
	boolean boardAdd(BoardDto dto) throws Exception;

	// �� �����ϱ�
	boolean boardUpdate(BoardDto dto, String sid, int number) throws Exception;

	//�� �����ϱ�
	// �̰� �����Ը���� ����   0704 �ڿ��� 13:17
	boolean boardDelete(String id) throws Exception;

	//�� id�� ��ȸ
	List<BoardDto> boardsearch_id(String id) throws Exception;

	//�� title�� ��ȸ
	boolean boardsearch_title(BoardDto dto) throws Exception;

	//���� �� �� ��ȸ
	boolean boardsearch_mine(BoardDto dto) throws Exception;

	//��� ��ȸ
	List<CommentDto> Commentselect(CommentDto dto) throws Exception;

	//��� �ۼ�
	boolean Commentadd(CommentDto dto, String role) throws Exception;

	//��� ����
	boolean Commentupdate(CommentDto dto, String role) throws Exception;

	//��� ����
	boolean Commentdelete(String id, String role) throws Exception;

}