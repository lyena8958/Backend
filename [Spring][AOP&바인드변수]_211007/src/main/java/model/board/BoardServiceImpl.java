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
		// after-throwing�� �������� �Ϻη� �����߻���Ű�� 
		/*if(vo.getId()==0) {// setter �ȵǾ������� 0���� �޾ƿ� ���̹Ƿ� ����ó������
			throw new IllegalArgumentException("ID PK 0�Ұ���");
			// ��Ÿ�� ����(����ÿ� �߻�, üũ�Ǵ� ����)
		}*/
		// 33�� ���ο��� ���ܰ� �߻��Ͽ�, 41�� ������ ������� ����
	

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
	public List<BoardVO> getAll() {
		//logAdvice.printLog();
		//logPulsAdvice.printPlusLog();
		return boardDAO.getAll();
	}

	@Override
	public BoardVO getOne(BoardVO vo) {
		//logAdvice.printLog();
		//logPulsAdvice.printPlusLog();
		return boardDAO.getOne(vo);
	}

}
