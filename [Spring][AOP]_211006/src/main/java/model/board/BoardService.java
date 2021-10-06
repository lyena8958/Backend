package model.board;


import java.util.List;

/*Phone{
	soundUp();
}
Watch{
	volumenUp();
}
== Phone Watch 메서드를 강제하기 위해 interface를 하자*/

public interface BoardService {

		boolean insertBoard(BoardVO vo);
		boolean updateBoard(BoardVO vo);
		boolean deleteBoard(BoardVO vo);
		List<BoardVO> selectAll();
		BoardVO selectOne (BoardVO vo);


}
