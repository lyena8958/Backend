package model.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

class BoardRowMapper implements RowMapper<BoardVO> {

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO data=new BoardVO();
		data.setId(rs.getInt("id"));
		data.setTitle(rs.getString("title"));
		data.setWriter(rs.getString("writer"));
		data.setContent(rs.getString("content"));
		data.setWdate(rs.getDate("wdate"));
		return data;
	}
	
}

@Repository
public class SpringBoardDAO {

	private final String insertSQL="insert into board (id,title,writer,content) values((select nvl(max(id),0)+1 from board),?,?,?)";
	private final String updateSQL="update board set title=?,content=?,writer=? where id=?";
	private final String deleteSQL="delete board where id=?";
	private final String getBoardSQL="select * from board where id=?";
	private final String getBoardListSQL_TITLE="select * from board where title like '%'||?||'%' order by id desc";
	private final String getBoardListSQL_WRITER="select * from board where writer like '%'||?||'%' order by id desc";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertBoard(BoardVO vo) {
		System.out.println("jdbcTemplate으로 insert");
		jdbcTemplate.update(insertSQL,vo.getTitle(),vo.getWriter(),vo.getContent());
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("jdbcTemplate으로 update");
		jdbcTemplate.update(updateSQL,vo.getTitle(),vo.getContent(),vo.getWriter(),vo.getId());
	}
	
	public void deleteBoard(BoardVO vo) {
		System.out.println("jdbcTemplate으로 delete");
		jdbcTemplate.update(deleteSQL,vo.getId());
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("jdbcTemplate으로 getBoardList");
		Object[] args= { vo.getKeyword() };
		if(vo.getCondition().equals("title")) {
			return jdbcTemplate.query(getBoardListSQL_TITLE,args,new BoardRowMapper());
		}
		else {
			return jdbcTemplate.query(getBoardListSQL_WRITER,args,new BoardRowMapper());
		}
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("jdbcTemplate으로 getBoard");
		Object[] args= { vo.getId() };
		return jdbcTemplate.queryForObject(getBoardSQL,args,new BoardRowMapper());
	}
	
}
