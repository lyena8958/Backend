package model.board;

import java.util.List;

public interface BoardService {
	
	public boolean insertBoard(BoardVO vo);
	public boolean updateBoard(BoardVO vo);
	public boolean deleteBoard(BoardVO vo);
	public BoardVO getBoard(BoardVO vo);
	public List<BoardVO> getListBoard(BoardVO vo);
	
	
}
