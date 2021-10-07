package model.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class BoardClient {
public static void main(String[] args) {
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		// 			부모									자식
		
					// 어노테이션으로 설정했기 때문에 불러올수 있게된다.
		BoardService bs = (BoardService)factory.getBean("boardService");
		
		BoardVO vo = new BoardVO();
		vo.setContent("내용 작성중~~");
		vo.setTitle("제목입니다!");
		vo.setWriter("괸리자");
		
		bs.insertBoard(vo); // bPointcut
		// Around 부르고, 수행하고, Around종료
		
		List<BoardVO> datas = bs.getAll();
		for(BoardVO v : datas) {
			System.out.println(v);
		}
		factory.close();//안닫아주어도 좋지만 성능상 닫아주는 것이 좋다(가비지컬렉터)
		
	}
}
