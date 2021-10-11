package model.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

// ���������� �����ϴ� BoardDAO
// ���� ���ÿ�ġ���� ����Ʈ ��ġ�� ����ϴ� DAO�� ����!

// 1. extends ��ӹ޾Ƽ� ����
// 2. JDBCTemplate�� <bean>���, ���������Թ޾� ��� ��(���̻��)
@Repository()
public class SpringBoardDAO2{ 
	// ���� Support �ٴ´ٴ� �� ���� ���������� �����س����� ���⼭ ����Ϸ��� ��ӹ��� ���� �ǹ�

	
/*	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;*/
	
	// final ����� �־��ָ� �ٸ����� �ٲ��� �ʴ� �Ǽ��� ������ �� �ִ�.
	private final String insertSQL = "insert into board (id, title, writer, content) values ((SELECT NVL(MAX(id),0)+1 FROM board), ?, ?, ?)";
	private final String updateSQL = "update board set title=?, writer=? content=? where id=?;";
	private final String deleteSQL = "delete from board where id=?";
	private final String getBoardSQL = "select * from board where id=?";
	private final String getBoardListSQL = "select * from board";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insertBoard(BoardVO vo) {
		System.out.println("jdbcTemplate���� insert");
		jdbcTemplate.update(insertSQL, vo.getTitle(), vo.getWriter(), vo.getContent());
		
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
		System.out.println("jdbcTemplate���� update");
		jdbcTemplate.update(insertSQL, vo.getTitle(), vo.getWriter(), vo.getContent(), vo.getId());
		
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
		jdbcTemplate.update(insertSQL, vo.getId());
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
	public BoardVO getOne(BoardVO vo) { // �޼���� getOne, getBoard��� �Ѵ�.
		System.out.println("jdbcTemplate selectOne");
		Object[] args = {vo.getId() };
 		return jdbcTemplate.queryForObject(getBoardSQL, args, new BoardRowMapper());
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
	public List<BoardVO> getAll(BoardVO vo) { // �޼���� getAll, getBoardList��� �Ѵ�.
		System.out.println("jdbcTemplate selectAll");
		
		System.out.println("jdbcTemplate selectOne");
 		return jdbcTemplate.query(getBoardListSQL, new BoardRowMapper());
 		
 		
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
