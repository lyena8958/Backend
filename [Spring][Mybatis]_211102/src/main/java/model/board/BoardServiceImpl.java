package model.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Autowired
	private MybatisBoardDAO_E boardDAO;
	
	@Override
	public boolean insertBoard(BoardVO vo) {
		return boardDAO.insertBoard(vo);
		
	}

	@Override
	public boolean updateBoard(BoardVO vo) {
		return boardDAO.updateBoard(vo);
		
	}

	@Override
	public boolean deleteBoard(BoardVO vo) {
		return boardDAO.deleteBoard(vo);
		
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
		
	}

	@Override
	public List<BoardVO> getListBoard(BoardVO vo) {
		return boardDAO.getBoardList(vo);
		
	}

}
