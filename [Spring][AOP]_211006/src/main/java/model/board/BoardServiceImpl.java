package model.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lee.app.common.LogAdvice;
import com.lee.app.common.LogPlusAdvice;

// 기존 OOP 언어체계에서 AOP가 갖는 한계
@Service("boardService") // service임을 알려줌
public class BoardServiceImpl implements BoardService{

	@Autowired // 현재 boardDAO가 하나밖에 없어서 타입만보고 가져올 수 있다.
	private BoardDAO boardDAO;
	//@Autowired // Autowired는 1:1이기 때문에 정의를 해주자
	//private LogAdvice logAdvice;
	//private LogPlusAdvice logPulsAdvice;
	
	public BoardServiceImpl() {
		//this.logAdvice=new LogAdvice();
		//this.logPulsAdvice= new LogPlusAdvice();
	}
	
	// 조인포인트 : 6개
	// 포인트컷 : 2개(select만 선택한 경우)
	
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
