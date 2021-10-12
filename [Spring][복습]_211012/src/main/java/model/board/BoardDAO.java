package model.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

// get류를 받아오기 위한 맵핑 Class
class BoardRowMapper implements RowMapper<BoardVO>{

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO data = new BoardVO();
		data.setId(rs.getInt("id"));
		data.setTitle(rs.getString("title"));
		data.setWriter(rs.getString("writer"));
		data.setContent(rs.getString("content"));
		data.setWdate(rs.getDate("wdate"));
		
		return data;
	}
	
	
}


@Repository("boardDAO")
public class BoardDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// [sql구문]
	String INSERT = "INSERT INTO BOARD (ID, TITLE, WRITER, CONTENT) VALUES ((SELECT NVL(MAX(ID),0)+1 FROM BOARD), ?, ?, ?)";
	String UPDATE = "UPDATE BOARD SET TITLE=?, WRITER=?, CONTENT=? WHERE ID=?";
	String DELETE = "DELETE FROM BOARD WHERE ID=?";
	String SELECT_ONE = "SELECT * FROM BOARD WHERE ID=?";
	String SELECT_LIST= "SELECT * FROM BOARD WHERE CONTENT LIKE ? ORDER BY ID DESC";
	
	// [비즈니스 메서드]
	public void insertBoard(BoardVO vo) {
		Object[] args = {vo.getTitle(), vo.getWriter(), vo.getContent()};
		jdbcTemplate.update(INSERT, args);
	}
	 
	public void updateBoard(BoardVO vo) {
		Object[] args = {vo.getTitle(), vo.getWriter(), vo.getContent(), vo.getId()};
		jdbcTemplate.update(UPDATE, args);
	}
	public void deleteBoard(BoardVO vo) {
		jdbcTemplate.update(DELETE, vo.getId());
	}
	public BoardVO getBoard(BoardVO vo) {
		Object[] args = {vo.getId()};
		return jdbcTemplate.queryForObject(SELECT_ONE, args, new BoardRowMapper());
	}
	public List<BoardVO> getListBoard(BoardVO vo){
		Object[] args = {"%"+vo.getContent()+"%"};
		return jdbcTemplate.query(SELECT_LIST, args ,new BoardRowMapper());
	}
	
}
