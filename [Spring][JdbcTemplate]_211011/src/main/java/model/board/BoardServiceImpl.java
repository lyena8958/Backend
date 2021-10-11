package model.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lee.app.common.LogAdvice;
import com.lee.app.common.LogPlusAdvice;

// 기존 OOP 언어체계에서 AOP가 갖는 한계
@Service("boardService") // service임을 알려줌
public class BoardServiceImpl implements BoardService{

	@Autowired // 현재 SpringBoardDAO가 하나밖에 없어서 타입만보고 가져올 수 있다.
	private SpringBoardDAO2 SpringBoardDAO; 
	
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
	public void insertBoard(BoardVO vo) {
		// after-throwing를 보기위해 일부러 오류발생시키기 
/*		if(vo.getId()==0) {// setter 안되어있으니 0으로 받아올 것이므로 오류처리가능
			throw new IllegalArgumentException("ID PK 0불가능");
			// 런타임 예외(실행시에 발생, 체크되는 예외)
		}*/
		// 33번 라인에서 예외가 발생하여, 41번 라인이 수행되지 않음
	

		SpringBoardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		//logAdvice.printLog();
		//logPulsAdvice.printPlusLog();
		SpringBoardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		//logAdvice.printLog();
		//logPulsAdvice.printPlusLog();
		SpringBoardDAO.deleteBoard(vo);
	}

	@Override
	public List<BoardVO> getAll(BoardVO vo) {
		//logAdvice.printLog();
		//logPulsAdvice.printPlusLog();
		return SpringBoardDAO.getAll(vo);
	}

	@Override
	public BoardVO getOne(BoardVO vo) {
		//logAdvice.printLog();
		//logPulsAdvice.printPlusLog();
		return SpringBoardDAO.getOne(vo);
	}

}
