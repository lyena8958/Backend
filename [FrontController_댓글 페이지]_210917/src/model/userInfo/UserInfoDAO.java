package model.userInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.DBCP;


public class UserInfoDAO {
	String sql_INSERT = "INSERT INTO USERINFO (USERID, USERPW, USERNAME, DATETIME) VALUES(?, ?, ?, sysdate)";
	String sql_SELECT_ONE = "SELECT * FROM USERINFO WHERE USERID=? AND USERPW=?";
	String sql_SELECT_ALL = "SELECT * FROM USERINFO ORDER BY DATETIME DESC";
	String sql_UPDATE = "UPDATE USERINFO SET USERPW=?, USERNAME=? WHERE USERID=?";
	String sql_DELETE = "DELETE FROM USERINFO WHERE USERID=?";
	
	Connection conn;
	PreparedStatement pstmt;
	
	
	
// 비즈니스 메서드  ↓	 ↓	↓
	
	// [회원가입]
	public boolean user_INSERT(UserInfoVO vo) {
		conn = DBCP.getConnection();
		try {
			pstmt = conn.prepareStatement(sql_INSERT);
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getUserPW());
			pstmt.setString(3, vo.getUserName());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("user_INSERT 에러");
			return false;
		}finally {
			DBCP.close(conn, pstmt);
		}		
		
		
		return true;
	}
	
	// [단일회원 조회]
	public UserInfoVO user_SELECT_ONE(UserInfoVO vo) {
		UserInfoVO data = null;
	
		try {
			conn = DBCP.getConnection();
			pstmt = conn.prepareStatement(sql_SELECT_ONE);
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getUserPW());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new UserInfoVO();
				data.setUserID(rs.getString("userID"));
				data.setUserPW(rs.getString("userPW"));
				data.setUserName(rs.getString("userName"));
				data.setDatetime(rs.getDate("datetime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("user_SELECT_ONE 에러");
		}finally {
			DBCP.close(conn, pstmt);
		}

		
		
		return data;
		
		
	}
	// [전체회원 조회]
	public ArrayList<UserInfoVO> user_SELECT_ALL(){
		ArrayList<UserInfoVO> datas = new ArrayList<UserInfoVO>();
		
		conn = DBCP.getConnection();
		try {
			pstmt = conn.prepareStatement(sql_SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				UserInfoVO data = new UserInfoVO();
				data.setUserID(rs.getString("userID"));
				data.setUserPW(rs.getString("userPW"));
				data.setUserName(rs.getString("userName"));
				data.setDatetime(rs.getDate("datetime"));
				datas.add(data); //인덱스별 객체 삽입
			}
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("user_SELECT_ALL 에러");
		}finally {
			DBCP.close(conn, pstmt);
		}
		
		
		return datas;
		
	}
	// [회원정보 수정]
	public boolean user_UPDATE(UserInfoVO vo) {
		
		conn = DBCP.getConnection();
		try {
			pstmt = conn.prepareStatement(sql_UPDATE);
			pstmt.setString(1, vo.getUserName());
			pstmt.setString(2, vo.getUserPW());
			pstmt.setString(3, vo.getUserID());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("user_UPDATE 에러");
			return false;
		}finally {
			DBCP.close(conn, pstmt);
		}
		
		return true;
	}
	// [회원탈퇴]
	public boolean user_DELETE(UserInfoVO vo) {
		conn = DBCP.getConnection();
		try {
			pstmt = conn.prepareStatement(sql_DELETE);
			pstmt.setString(1, vo.getUserID());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("user_DELETE 에러");
			return false;
		}finally {
			DBCP.close(conn, pstmt);
		}
		
		return true;
	}
}
