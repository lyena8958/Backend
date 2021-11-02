package model.board;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
// �θ𺸴� �ڽ��� ����� �� ����. (�θ𲨿��� �߰� ������ �� �ֱ� ����)
@Repository
public class MybatisBoardDAO_E extends SqlSessionDaoSupport{ // JdbcTemplate ���� ����!
	// SqlSessionFactory�� applicationContext.xml���� bean ����� ���ؼ� �������Եȴ�.


	// SqlSession�� Sqls.Factory�� getSession���� �̷���� �����´�. >> �θ� ���� ��������!
	@Autowired // Autowired�� �޼��忡�� ���� �� �ִ�.
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	public boolean insertBoard(BoardVO vo) {
		try {
			getSqlSession().insert("dao.insertBoard", vo);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	public boolean updateBoard(BoardVO vo) {
		try {
			getSqlSession().update("dao.updateBoard", vo);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	public boolean deleteBoard(BoardVO vo) {
		try {
			getSqlSession().delete("dao.deleteBoard", vo);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	public BoardVO getBoard(BoardVO vo) {
		return (BoardVO)getSqlSession().selectOne("dao.getBoard"); // ����Ÿ���� ���������� �����Ƿ�, ĳ������ ���� ���������!
	}
	public List<BoardVO> getBoardList(BoardVO vo) {
		return getSqlSession().selectList("dao.getBoardList", vo);
	}
}
