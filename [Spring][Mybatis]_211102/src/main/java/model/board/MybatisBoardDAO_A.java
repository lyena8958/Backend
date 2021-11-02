package model.board;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
// �θ𺸴� �ڽ��� ����� �� ����. (�θ𲨿��� �߰� ������ �� �ֱ� ����)
@Repository
public class MybatisBoardDAO_A{ // JdbcTemplate ���� ����!
	// SqlSessionFactory�� applicationContext.xml���� bean ����� ���ؼ� �������Եȴ�.

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
		return (BoardVO)mybatis.selectOne("dao.getBoard"); // ����Ÿ���� ���������� �����Ƿ�, ĳ������ ���� ���������!
	}
	public List<BoardVO> getBoardList(BoardVO vo) {
		return mybatis.selectList("dao.getBoardList", vo);
	}
}
