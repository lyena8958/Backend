package model.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("boardService") // service���� �˷���
public class BoardServiceImpl implements BoardService{

	@Autowired // ���� boardDAO�� �ϳ��ۿ� ��� Ÿ�Ը����� ������ �� �ִ�.
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
