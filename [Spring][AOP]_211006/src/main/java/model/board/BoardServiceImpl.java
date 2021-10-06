package model.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lee.app.common.LogAdvice;
import com.lee.app.common.LogPlusAdvice;

// ���� OOP ���ü�迡�� AOP�� ���� �Ѱ�
@Service("boardService") // service���� �˷���
public class BoardServiceImpl implements BoardService{

	@Autowired // ���� boardDAO�� �ϳ��ۿ� ��� Ÿ�Ը����� ������ �� �ִ�.
	private BoardDAO boardDAO;
	//@Autowired // Autowired�� 1:1�̱� ������ ���Ǹ� ������
	//private LogAdvice logAdvice;
	//private LogPlusAdvice logPulsAdvice;
	
	public BoardServiceImpl() {
		//this.logAdvice=new LogAdvice();
		//this.logPulsAdvice= new LogPlusAdvice();
	}
	
	// ��������Ʈ : 6��
	// ����Ʈ�� : 2��(select�� ������ ���)
	
	@Override
	public boolean insertBoard(BoardVO vo) {
		//logAdvice.printLog();
		//logPulsAdvice.printPlusLog();
		return boardDAO.insertBoard(vo);
	}

	@Override
	public boolean updateBoard(BoardVO vo) {
		//logAdvice.printLog();
		//logPulsAdvice.printPlusLog();
		return boardDAO.updateBoard(vo);
	}

	@Override
	public boolean deleteBoard(BoardVO vo) {
		//logAdvice.printLog();
		//logPulsAdvice.printPlusLog();
		return boardDAO.deleteBoard(vo);
	}

	@Override
	public List<BoardVO> selectAll() {
		//logAdvice.printLog();
		//logPulsAdvice.printPlusLog();
		return boardDAO.selectAll();
	}

	@Override
	public BoardVO selectOne(BoardVO vo) {
		//logAdvice.printLog();
		//logPulsAdvice.printPlusLog();
		return boardDAO.selectOne(vo);
	}

}
