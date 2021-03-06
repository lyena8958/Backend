package model.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import model.common.JDBC;

// DAO -> 드라이버, CP, MyBatis, JPA, .... (DAO의 종류는 여러가지이다.)
// Service를 DAO 객체를 이용하여 CRUD 기능을 제공할 예정!

// 폰Service <-> 시계DAO
// 핸드폰이 사운드 CRUD하는 것은 안바뀜, 누굴 통해서 할건데? board DAO를 통해서

@Repository("boardDAO") // 사용함으로써 컨테이너는DAO임을 인지한다. // 컴포넌트상속받은 리포지토리
public class BoardDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// final 상수를 넣어주면 다른데서 바뀌지 않는 실수를 방지할 수 있다.
	private final String insertSQL = "insert into board (id, title, writer, content) values ((SELECT NVL(MAX(id),0)+1 FROM board), ?, ?, ?)";
	private final String updateSQL = "update board set title=?, writer=? content=? where id=?;";
	private final String deleteSQL = "delete from board where id=?";
	private final String getBoardSQL = "select * from board where id=?";
	private final String getBoardListSQL = "select * from board";
	
	public boolean insertBoard(BoardVO vo) {
		System.out.println("DAO insert");
		conn = JDBC.getConnection();
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
		return false;
	}
	public boolean updateBoard(BoardVO vo) {
		System.out.println("DAO update");
		conn = JDBC.getConnection();
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
		return false;
	}
	public boolean deleteBoard(BoardVO vo) {
		System.out.println("DAO delete");
		conn = JDBC.getConnection();
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
		return false;
	}
	public List<BoardVO> getAll() { // 메서드명 getAll, getBoardList라고도 한다.
		System.out.println("DAO selectAll");
		conn = JDBC.getConnection();
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
	}
	public BoardVO getOne(BoardVO vo) { // 메서드명 getOne, getBoard라고도 한다.
		System.out.println("DAO selectOne");
		conn = JDBC.getConnection();
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
		
		return null;
	}
}
