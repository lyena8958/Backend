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

		boolean insertBoard(BoardVO vo);
		boolean updateBoard(BoardVO vo);
		boolean deleteBoard(BoardVO vo);
		List<BoardVO> selectAll();
		BoardVO selectOne (BoardVO vo);


}
