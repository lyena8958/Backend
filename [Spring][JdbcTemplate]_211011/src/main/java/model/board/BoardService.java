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

		void insertBoard(BoardVO vo);
		void updateBoard(BoardVO vo);
		void deleteBoard(BoardVO vo);
		List<BoardVO> getAll(BoardVO vo);
		BoardVO getOne (BoardVO vo);


}
