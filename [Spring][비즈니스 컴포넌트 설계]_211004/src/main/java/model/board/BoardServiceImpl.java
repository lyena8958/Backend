package model.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("boardService") // service임을 알려줌
public class BoardServiceImpl implements BoardService{

	@Autowired // 현재 boardDAO가 하나밖에 없어서 타입만보고 가져올 수 있다.
	private BoardDAO boardDAO;
	
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
	public List<BoardVO> selectAll() {
		return boardDAO.selectAll();
	}

	@Override
	public BoardVO selectOne(BoardVO vo) {
		return boardDAO.selectOne(vo);
	}

}
