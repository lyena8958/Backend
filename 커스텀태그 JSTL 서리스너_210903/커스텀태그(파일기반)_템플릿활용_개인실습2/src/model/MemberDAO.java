package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.commit.JDBC;

public class MemberDAO {

	String sql_SELECT_LOGIN = "SELECT * FROM MEMBER WHERE USERID=? AND USERPW=?";
	String sql_INSERT = "INSERT INTO MEMBER (ONUM, USERID, USERPW) VALUES ((SELECT NVL(MAX(ONUM),0)+1 FROM MEMBER),?,?)";

	//[비즈니스 메서드] INSERT
	public boolean SignUp(MemberVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = JDBC.getConnection();
			pstmt = conn.prepareStatement(sql_INSERT);
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getUserPW());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false; // 오류가 발생되면 false 반환
		}finally {
			JDBC.DBclose(conn, pstmt);
		}
		return true;// 가입이 완료되면 true반환
		
	}
	//[비즈니스 메서드] SELECTONE  == 회원 대조용
	public boolean LoginSelectOne(MemberVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = JDBC.getConnection();
			pstmt = conn.prepareStatement(sql_SELECT_LOGIN);
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getUserPW());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("MemberDAO-loginCheck에서 오류");
			return false;
		}
		finally {
			JDBC.DBclose(conn, pstmt);
		}
	}
	
}
