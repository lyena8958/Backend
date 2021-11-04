package model.board;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JPABoardDAO {
	
	//영속성으로 1:1 맵핑하기 때문에 필요한 어노테이션
	@PersistenceContext
	private EntityManager em;
	

	public boolean insertBoard(BoardVO vo) {
		try {
			em.persist(vo);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public boolean updateBoard(BoardVO vo) {
		try {
			em.merge(vo);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public boolean deleteBoard(BoardVO vo) {
		try {
			em.remove(em.find(BoardVO.class , vo.getId())); // 삭제는 PK를 보고 하기때문에, 해당클래스와 PK를 입력해준다.
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public BoardVO getBoard(BoardVO vo) {
		return (BoardVO)em.find(BoardVO.class, vo.getId()); // 리턴타입이 정해져있지 않으므로, 캐스팅을 통해 명시해주자!
	}														// 단일조회는 PK를 보고 하기때문에, 해당클래스와 PK를 입력해준다.
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		return em.createQuery("select b from Board b", BoardVO.class).getResultList();
		// 쿼리문 어법은 검색을 통해 확인 가능
	}
}
