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
	//private LogAdvice logAdvice; // ver1
	private LogPlusAdvice logPlusAdvice; // ver2 
	
	// 기존 OOP에서 AOP가 갖는 한계를 log ver1,2 통해서 알 수 있다.
	
	public BoardServiceImpl() {
		//this.logAdvice=new LogAdvice();
		this.logPlusAdvice= new LogPlusAdvice();
	}
	
	@Override
	public boolean insertBoard(BoardVO vo) {
		//logAdvice.printLog();
		logPlusAdvice.printPlusLog();
		return boardDAO.insertBoard(vo);
	}

	@Override
	public boolean updateBoard(BoardVO vo) {
		//logAdvice.printLog();
		logPlusAdvice.printPlusLog();
		return boardDAO.updateBoard(vo);
	}

	@Override
	public boolean deleteBoard(BoardVO vo) {
		//logAdvice.printLog();
		logPlusAdvice.printPlusLog();
		return boardDAO.deleteBoard(vo);
	}

	@Override
	public List<BoardVO> selectAll() {
		//logAdvice.printLog();
		logPlusAdvice.printPlusLog();
		return boardDAO.selectAll();
	}

	@Override
	public BoardVO selectOne(BoardVO vo) {
		//logAdvice.printLog();
		logPlusAdvice.printPlusLog();
		return boardDAO.selectOne(vo);
	}

}
