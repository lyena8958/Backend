package model.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
// DBA�� ȿ�������� ������ �� �ְ� ��
public class BoardDAO {
	private SqlSession mybatis;
	
	public BoardDAO(){
		//SqlSessionFactoryBean�� ���ؼ� ������ SqlSessionInstance�� ����� �� �ְ� ��
		mybatis=SqlSessionFactoryBean.getSqlSessionInstance();
	}
	
	public void insertBoard(BoardVO vo) {
		// <mapper namespace="dao"> ���� ������ namespace�� ��� �Է�
		// 			���⼭ VO�� board-mapping.xml�� paramType�� �Ǵ� ���̴�(�Ӽ��� default�� ���־ �Ⱥ���!)
		mybatis.insert("dao.insertBoard", vo);
		// 1�� ������ ����
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
