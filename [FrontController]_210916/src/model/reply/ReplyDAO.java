package model.reply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.DBCP;

public class ReplyDAO {
	String sql_INSERT = "INSERT INTO REPLY (RNUM, MNUM, USERID, RMSG, DATETIME) VALUES "
			+ "((SELECT NVL(MAX(RNUM),0)+1 FROM REPLY), ?, ?, ?, sysdate)"; 
	String sql_SELECT_ONE = "SELECT * FROM REPLY WHERE RNUM=?";
	String sql_SELECT_ALL = "SELECT * FROM REPLY WHERE MNUM=? ORDER BY RNUM DESC"; // Ư������� ��� ���� �ҷ�����
	String sql_UPDATE = "UPDATE REPLY SET RMSG=? WHERE RNUM=?";
	String sql_DELETE = "DELETE FROM REPLY WHERE RNUM=?";
	
	private Connection conn;
	private PreparedStatement pstmt;
	// [���� �߰�]
	public boolean reply_INSERT(ReplyVO vo) {
		System.out.println(vo);
		conn = DBCP.getConnection();
		try {
			pstmt = conn.prepareStatement(sql_INSERT);
			pstmt.setInt(1, vo.getMnum());
			pstmt.setString(2, vo.getUserID());
			pstmt.setString(3, vo.getRmsg());
			pstmt.executeUpdate();
			
			// Ʈ����� ����
			String sql="UPDATE MESSAGE SET REPLYCNT=REPLYCNT+1 WHERE MNUM="+vo.getMnum();
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("reply_INSERT �����߻�");
			return false;
		}finally {
			DBCP.close(conn, pstmt);
		}
			
		
		return true;
		
		
	}
	// [���� �������]
	public ReplyVO reply_SELECT_ONE(ReplyVO vo) {
		ReplyVO data = null;
		
		conn = DBCP.getConnection();
		try {
			pstmt = conn.prepareStatement(sql_SELECT_ONE);
			pstmt.setInt(1, vo.getRnum());
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				data = new ReplyVO();
				
				data.setRnum(rs.getInt("rnum"));
				data.setMnum(rs.getInt("mnum"));
				data.setUserID(rs.getString("userID"));
				data.setRmsg(rs.getString("rmsg"));
				data.setDatetime(rs.getDate("datetime"));
				
			}
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("reply_SELECT_ONE �����߻�");
		}finally {
			DBCP.close(conn, pstmt);
		}
		
		
		
		return data;
		
	}
	// [���� ��� - �� ��� �������]
	public ArrayList<ReplyVO> reply_SELECT_ALL(int mid){
		ArrayList<ReplyVO> datas = new ArrayList<ReplyVO>();
		conn = DBCP.getConnection();
		try {
			pstmt = conn.prepareStatement(sql_SELECT_ALL);
			pstmt.setInt(1, mid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				ReplyVO data = new ReplyVO();
				data.setRnum(rs.getInt("rnum"));
				data.setMnum(rs.getInt("mnum"));
				data.setUserID(rs.getString("userID"));
				data.setRmsg(rs.getString("rmsg"));
				data.setDatetime(rs.getDate("datetime"));
				datas.add(data);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("reply_SELECT_ALL �����߻�");
		}finally {
			DBCP.close(conn, pstmt);
		}

		
		return datas;
		
	}
	// [���� ����]
	public boolean reply_UPDATE(ReplyVO vo) {
		
		conn = DBCP.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql_UPDATE);
			pstmt.setString(1, vo.getRmsg());
			pstmt.setInt(2, vo.getRnum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("reply_UPDATE �����߻�");
			return false;
		}
		
		return true;
		
	}
	// [���� ����]
	public boolean reply_DELETE(ReplyVO vo) {
	conn = DBCP.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql_DELETE);
			pstmt.setInt(1, vo.getRnum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("reply_UPDATE �����߻�");
			return false;
		}
		
		return true;
		
	}
	
}
