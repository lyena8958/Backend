package model.board;


import java.util.List;

/*Phone{
	soundUp();
}
Watch{
	volumenUp();
}
== Phone Watch �޼��带 �����ϱ� ���� interface�� ����*/

public interface BoardService {

		void insertBoard(BoardVO vo);
		void updateBoard(BoardVO vo);
		void deleteBoard(BoardVO vo);
		List<BoardVO> getAll(BoardVO vo);
		BoardVO getOne (BoardVO vo);


}
