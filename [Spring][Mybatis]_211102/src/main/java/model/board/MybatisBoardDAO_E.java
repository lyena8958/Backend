package model.board;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
// 부모보다 자식이 기능이 더 많다. (부모꺼에서 추가 정의할 수 있기 때문)
@Repository
public class MybatisBoardDAO_E extends SqlSessionDaoSupport{ // JdbcTemplate 완전 유사!
	// SqlSessionFactory는 applicationContext.xml에서 bean 등록을 통해서 가져오게된다.


	// SqlSession은 Sqls.Factory의 getSession으로 이루어져 가져온다. >> 부모 껄로 가져오자!
	@Autowired // Autowired는 메서드에도 붙일 수 있다.
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
		return (BoardVO)getSqlSession().selectOne("dao.getBoard"); // 리턴타입이 정해져있지 않으므로, 캐스팅을 통해 명시해주자!
	}
	public List<BoardVO> getBoardList(BoardVO vo) {
		return getSqlSession().selectList("dao.getBoardList", vo);
	}
}
