package model.userMsg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.DBCP;

public class UserMsgDAO {
	String sql_INSERT = "INSERT INTO USERMSG (ID, NAME, PASSWD, DATETIME) VALUES(?, ?, ?, sysdate)";
	String sql_SELECT_ONE = "SELECT * FROM USERMSG WHERE ID=?";
	String sql_SELECT_ALL = "SELECT * FROM USERMSG";
	String sql_UPDATE = "UPDATE USERMSG SET NAME=? PASSWD=? WHERE ID=?";
	String sql_DELETE = "DELETE FROM USERMSG WHERE ID=?";
	
	Connection conn;
	PreparedStatement pstmt;
	
	
	
// 비즈니스 메서드  ↓	 ↓	↓
	
	// [회원가입]
	public boolean user_INSERT(UserMsgVO vo) {
		conn = DBCP.connect();
		try {
			pstmt = conn.prepareStatement(sql_INSERT);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getPasswd());
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			//DBCP.close(conn, pstmt);
		}		
		
		
		return true;
	}
	
	// [단일회원 조회]
	public UserMsgVO user_SELECT_ONE(UserMsgVO vo) {
		UserMsgVO data = null;
	
		try {
			conn = DBCP.connect();
			pstmt = conn.prepareStatement(sql_SELECT_ONE);
			pstmt.setString(1, vo.getId());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new UserMsgVO();
				data.setId(rs.getString("id"));
				data.setName(rs.getString("name"));
				data.setPasswd(rs.getString("passwd"));
				data.setDatetime(rs.getDate("datetime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		
		return data;
		
		
	}
	// [전체회원 조회]
	public ArrayList<UserMsgVO> user_SELECT_ALL(){
		ArrayList<UserMsgVO> datas = new ArrayList<UserMsgVO>();
		
		conn = DBCP.connect();
		try {
			pstmt = conn.prepareStatement(sql_SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				UserMsgVO data = new UserMsgVO();
				data.setId(rs.getString("id"));
				data.setName(rs.getString("name"));
				data.setPasswd(rs.getString("passwd"));
				data.setDatetime(rs.getDate("datetime"));
				datas.add(data); //인덱스별 객체 삽입
			}
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//DBCP.close(conn, pstmt);
		}
		
		
		return datas;
		
	}
	// [회원정보 수정]
	public boolean user_UPDATE(UserMsgVO vo) {
		
		conn = DBCP.connect();
		try {
			pstmt = conn.prepareStatement(sql_UPDATE);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPasswd());
			pstmt.setString(3, vo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			//DBCP.close(conn, pstmt);
		}
		
		return true;
	}
	// [회원탈퇴]
	public boolean user_DELETE(UserMsgVO vo) {
		conn = DBCP.connect();
		try {
			pstmt = conn.prepareStatement(sql_DELETE);
			pstmt.setString(1, vo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			//DBCP.close(conn, pstmt);
		}
		
		return true;
	}
	
	
}
