package model.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import model.common.JDBC;



@Repository("boardDAO")
public class BoardDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// [sql구문]
	String INSERT = "INSERT INTO BOARD (ID, TITLE, WRITER, CONTENT) VALUES ((SELECT NVL(MAX(ID),0)+1 FROM BOARD), ?, ?, ?)";
	String UPDATE = "UPDATE BOARD SET TITLE=?, WRITER=?, CONTENT=? WHERE ID=?";
	String DELETE = "DELETE FROM BOARD WHERE ID=?";
	String SELECT_ONE = "SELECT * FROM BOARD WHERE ID=?";
	String SELECT_LIST= "SELECT * FROM BOARD ORDER BY ID DESC"; //WHERE CONTENT LIKE ?
	
	// [비즈니스 메서드]
	public boolean insertBoard(BoardVO vo) {
		System.out.println("DAO insert");
		conn = JDBC.getConnection();
		try {
			pstmt= conn.prepareStatement(INSERT);
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
			pstmt= conn.prepareStatement(UPDATE);
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
			pstmt= conn.prepareStatement(DELETE);
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
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("DAO selectOne");
		conn = JDBC.getConnection();
		BoardVO data = null;
		try {
			pstmt= conn.prepareStatement(SELECT_ONE);
			pstmt.setInt(1, vo.getId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new BoardVO();
				data.setId(rs.getInt("id"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				data.setContent(rs.getString("content"));
				data.setWdate(rs.getDate("wdate"));
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
	public List<BoardVO> getListBoard(BoardVO vo){
		System.out.println("DAO selectAll");
		conn = JDBC.getConnection();
		List<BoardVO> datas = new ArrayList<BoardVO>();
		try {
			pstmt= conn.prepareStatement(SELECT_LIST);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO data = new BoardVO();
				data.setId(rs.getInt("id"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				data.setContent(rs.getString("content"));
				data.setWdate(rs.getDate("wdate"));
				datas.add(data);
			}
			rs.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			
		}finally {
			JDBC.close(conn, pstmt);
		}
		return datas;
	}
	
}
