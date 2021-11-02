package model.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
// DBA를 효율적으로 관리할 수 있게 됨
public class BoardDAO {
	private SqlSession mybatis;
	
	public BoardDAO(){
		//SqlSessionFactoryBean을 통해서 가져온 SqlSessionInstance를 사용할 수 있게 됨
		mybatis=SqlSessionFactoryBean.getSqlSessionInstance();
	}
	
	public void insertBoard(BoardVO vo) {
		// <mapper namespace="dao"> 에서 지정한 namespace로 경로 입력
		// 			여기서 VO는 board-mapping.xml의 paramType이 되는 것이다(속성에 default로 들어가있어서 안보임!)
		mybatis.insert("dao.insertBoard", vo);
		// 1번 김은지 등장
		mybatis.commit(); 
	}
	public void updateBoard(BoardVO vo) {
		mybatis.update("dao.updateBoard", vo);
		mybatis.commit();
	}
	public BoardVO getBoard(BoardVO vo) {
		return (BoardVO) mybatis.selectOne("dao.getBoard", vo);
	}
	public List<BoardVO> getBoardList(BoardVO vo) {
		return mybatis.selectList("dao.getBoardList", vo);
	}
}
