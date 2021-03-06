package model.review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.commit.JDBC;

public class ReviewDAO {
	String SQL_SELECTONE = "SELECT * FROM REVIEW WHERE RNUM=?";
	String SQL_SELECTALL = "SELECT * FROM REVIEW ORDER BY RNUM DESC";
	String SQL_SELECTUSER = "SELECT * FROM REVIEW WHERE ONUM=?";
	String SQL_INSERT = "INSERT INTO REVIEW (ONUM, RNUM, WRITER, TITLE, CONTENT, WDATE) VALUES(?, (SELECT NVL(MAX(ONUM),0)+1 FROM REVIEW), ?, ?, ?, SYSDATE)";
	String SQL_UPDATE = "UPDATE REVIEW SET WRITER=?, TITLE=?, CONTENT=? WHERE ONUM=?";
	String SQL_DELETE = "DELETE FROM REVIEW WHERE ONUM=?";
	
	public ArrayList<ReviewVO> RVSelectAll() {
	
		ArrayList<ReviewVO> datas = new ArrayList<ReviewVO>();
		Connection conn = JDBC.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(SQL_SELECTALL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				ReviewVO data = new ReviewVO();
				data.setOnum(rs.getInt("onum"));
				data.setRnum(rs.getInt("rnum"));
				data.setWriter(rs.getString("writer"));
				data.setTitle(rs.getString("title"));
				data.setContent(rs.getString("content"));
				data.setWdate(rs.getDate("wdate"));
				datas.add(data); // 저장한 객체별로 datas 인덱스에 저장
			}
		} catch (SQLException e) {
			System.out.println("RVInsert 에서 오류");
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		
		return datas;
	}
	// 유저 본인 게시물 리스트 반환
	public ArrayList<ReviewVO> RVUserDatas(ReviewVO vo){
		
		ArrayList<ReviewVO> datas = new ArrayList<ReviewVO>();
		Connection conn = JDBC.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(SQL_SELECTUSER);
			pstmt.setInt(1, vo.getOnum());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				ReviewVO data = new ReviewVO();
				data.setOnum(rs.getInt("onum"));
				data.setRnum(rs.getInt("rnum"));
				data.setWriter(rs.getString("writer"));
				data.setTitle(rs.getString("title"));
				data.setContent(rs.getString("content"));
				data.setWdate(rs.getDate("wdate"));
				datas.add(data); // 저장한 객체별로 datas 인덱스에 저장
			}
		} catch (SQLException e) {
			System.out.println("RVUserDatas 에서 오류");
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		
		return datas;
	}
	public ReviewVO RVSelectOne(ReviewVO vo) {
		ReviewVO data = null;
		Connection conn = JDBC.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(SQL_SELECTUSER);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new ReviewVO();
				data.setOnum(rs.getInt("onum"));
				data.setOnum(rs.getInt("rnum"));
				data.setWriter(rs.getString("writer"));
				data.setTitle(rs.getString("title"));
				data.setContent(rs.getString("content"));
				data.setWdate(rs.getDate("wdate"));
			}
		} catch (SQLException e) {
			System.out.println("RVInsert 에서 오류");
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		
		return data;
	}
	public boolean RVInsert(ReviewVO vo) {
		Connection conn = JDBC.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setInt(1, vo.getOnum());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getTitle());
			pstmt.setString(4, vo.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("RVInsert 에서 오류");
			e.printStackTrace();
			return false; // 오류발생시 false 반환
		}finally {
			JDBC.close(conn, pstmt);
		}
		
		return true;
	}
	public boolean RVUpdate(ReviewVO vo) {
		Connection conn = JDBC.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setInt(4, vo.getOnum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("RVUpdate 에서 오류");
			return false; // 오류발생시 false 반환
		}finally {
			JDBC.close(conn, pstmt);
		}
		
		return true;
	}
	public boolean RVDelete(ReviewVO vo) {
		Connection conn = JDBC.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, vo.getOnum());			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("RVDelete 에서 오류");
			return false; // 오류발생시 false 반환
		}finally {
			JDBC.close(conn, pstmt);
		}
		
		
		return true;
	}
	
}
