package model.board;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JPABoardDAO {
	
	//���Ӽ����� 1:1 �����ϱ� ������ �ʿ��� ������̼�
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
			em.remove(em.find(BoardVO.class , vo.getId())); // ������ PK�� ���� �ϱ⶧����, �ش�Ŭ������ PK�� �Է����ش�.
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public BoardVO getBoard(BoardVO vo) {
		return (BoardVO)em.find(BoardVO.class, vo.getId()); // ����Ÿ���� ���������� �����Ƿ�, ĳ������ ���� ���������!
	}														// ������ȸ�� PK�� ���� �ϱ⶧����, �ش�Ŭ������ PK�� �Է����ش�.
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		return em.createQuery("select b from Board b", BoardVO.class).getResultList();
		// ������ ����� �˻��� ���� Ȯ�� ����
	}
}
