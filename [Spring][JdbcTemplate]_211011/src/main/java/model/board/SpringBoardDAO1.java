package model.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
// 1. 상속받아서 처리
class BoardRowMapper implements RowMapper<BoardVO> {
	// 강제성 덕분에 안정적으로 rowMapper를 정의할 수 있다.
	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO data = new BoardVO();

		data.setId(rs.getInt("id"));
		data.setTitle(rs.getString("title"));
		data.setWriter(rs.getString("writer"));
		data.setContent(rs.getString("content"));
		data.setWDate(rs.getDate("wdate"));
		return data;




	}
}
// 스프링에서 제공하는 BoardDAO
// 기존 애플워치에서 스마트 워치로 사용하는 DAO로 변경!

// 1. extends 상속받아서 구현
// 2. JDBCTemplate를 <bean>등록, 의존성주입받아 사용 ○(많이사용)
@Repository()
public class SpringBoardDAO1 extends JdbcDaoSupport{ 
	// 끝이 Support 붙는다는 건 뭔가 스프링에서 구현해놓은걸 여기서 사용하려고 상속받은 것을 의미

	
/*	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;*/
	
	// final 상수를 넣어주면 다른데서 바뀌지 않는 실수를 방지할 수 있다.
	private final String insertSQL = "insert into board (id, title, writer, content) values ((SELECT NVL(MAX(id),0)+1 FROM board), ?, ?, ?)";
	private final String updateSQL = "update board set title=?, writer=? content=? where id=?;";
	private final String deleteSQL = "delete from board where id=?";
	private final String getBoardSQL = "select * from board where id=?";
	private final String getBoardListSQL = "select * from board";
	
	@Autowired
	public void setSuperDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	

	public void insertBoard(BoardVO vo) {
		System.out.println("jdbcTemplate으로 insert");
		getJdbcTemplate().update(insertSQL, vo.getTitle(), vo.getWriter(), vo.getContent());
		
		/*conn = JDBC.getConnection();
		try {
			pstmt= conn.prepareStatement(insertSQL);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		return false;*/
	}
	public void updateBoard(BoardVO vo) {
		System.out.println("jdbcTemplate으로 update");
		getJdbcTemplate().update(insertSQL, vo.getTitle(), vo.getWriter(), vo.getContent(), vo.getId());
		
		/*conn = JDBC.getConnection();
		try {
			pstmt= conn.prepareStatement(updateSQL);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.setInt(4, vo.getId());
			pstmt.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		return false;*/
	}
	public void deleteBoard(BoardVO vo) {
		System.out.println("jdbcTemplate delete");
		getJdbcTemplate().update(insertSQL, vo.getId());
		/*conn = JDBC.getConnection();
		try {
			pstmt= conn.prepareStatement(deleteSQL);
			pstmt.setInt(1, vo.getId());
			pstmt.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			JDBC.close(conn, pstmt);
		}
		return false;*/
	}
	public BoardVO getOne(BoardVO vo) { // 메서드명 getOne, getBoard라고도 한다.
		System.out.println("jdbcTemplate selectOne");
		Object[] args = {vo.getId() };
 		return getJdbcTemplate().queryForObject(getBoardSQL, args, new BoardRowMapper());
		/*conn = JDBC.getConnection();
		BoardVO data = null;
		try {
			pstmt= conn.prepareStatement(getBoardSQL);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new BoardVO();
				data.setId(rs.getInt("id"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				data.setContent(rs.getString("content"));
				data.setWDate(rs.getDate("wdate"));
			}
			rs.close();
			return data;
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			JDBC.close(conn, pstmt);
		}
		
		return null;*/
	}
	public List<BoardVO> getAll(BoardVO vo) { // 메서드명 getAll, getBoardList라고도 한다.
		System.out.println("jdbcTemplate selectAll");
		
		System.out.println("jdbcTemplate selectOne");
 		return getJdbcTemplate().query(getBoardListSQL, new BoardRowMapper());
 		
 		
	/*	conn = JDBC.getConnection();
		List<BoardVO> datas = new ArrayList<BoardVO>();
		try {
			pstmt= conn.prepareStatement(getBoardListSQL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO data = new BoardVO();
				data.setId(rs.getInt("id"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				data.setContent(rs.getString("content"));
				data.setWDate(rs.getDate("wdate"));
				datas.add(data);
			}
			rs.close();
			return datas;
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			JDBC.close(conn, pstmt);
		}
		
		return null;
	}*/

	}
}
