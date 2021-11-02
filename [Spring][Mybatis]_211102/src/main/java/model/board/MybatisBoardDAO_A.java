package model.board;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
// 부모보다 자식이 기능이 더 많다. (부모꺼에서 추가 정의할 수 있기 때문)
@Repository
public class MybatisBoardDAO_A{ // JdbcTemplate 완전 유사!
	// SqlSessionFactory는 applicationContext.xml에서 bean 등록을 통해서 가져오게된다.

	@Autowired
	private SqlSessionTemplate mybatis;
	

	public boolean insertBoard(BoardVO vo) {
		try {
			mybatis.insert("dao.insertBoard", vo);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	public boolean updateBoard(BoardVO vo) {
		try {
			mybatis.update("dao.updateBoard", vo);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	public boolean deleteBoard(BoardVO vo) {
		try {
			mybatis.delete("dao.deleteBoard", vo);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	public BoardVO getBoard(BoardVO vo) {
		return (BoardVO)mybatis.selectOne("dao.getBoard"); // 리턴타입이 정해져있지 않으므로, 캐스팅을 통해 명시해주자!
	}
	public List<BoardVO> getBoardList(BoardVO vo) {
		return mybatis.selectList("dao.getBoardList", vo);
	}
}
