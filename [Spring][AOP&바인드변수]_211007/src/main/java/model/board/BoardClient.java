package model.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class BoardClient {
public static void main(String[] args) {
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		// 			�θ�									�ڽ�
		
					// ������̼����� �����߱� ������ �ҷ��ü� �ְԵȴ�.
		BoardService bs = (BoardService)factory.getBean("boardService");
		
		BoardVO vo = new BoardVO();
		vo.setContent("���� �ۼ���~~");
		vo.setTitle("�����Դϴ�!");
		vo.setWriter("������");
		
		bs.insertBoard(vo); // bPointcut
		// Around �θ���, �����ϰ�, Around����
		
		List<BoardVO> datas = bs.getAll();
		for(BoardVO v : datas) {
			System.out.println(v);
		}
		factory.close();//�ȴݾ��־ ������ ���ɻ� �ݾ��ִ� ���� ����(�������÷���)
		
	}
}
