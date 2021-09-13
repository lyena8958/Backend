package model.reply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.DBCP;

public class ReplyDAO {
	String sql_INSERT = "INSERT INTO REPLY (RID, MID, ID, DATETIME, RMSG) VALUES "
			+ "((SELECT NVL(MAX(MID),0)+1 FROM REPLY), ?, ?, sysdate, ?)"; 
	String sql_SELECT_ONE = "SELECT * FROM REPLY WHERE RID=?";
	String sql_SELECT_ALL = "SELECT * FROM REPLY WHERE MID=?"; // 특정댓글의 모든 대댓글 불러오기
	String sql_UPDATE = "UPDATE REPLY SET NAME=? PASSWD=? WHERE ID=?";
	String sql_DELETE = "DELETE FROM REPLY WHERE ID=?";
	
	private Connection conn;
	private PreparedStatement pstmt;
	
	
	public ArrayList<ReplyVO> reply_SELECT_ALL(int mid){
		ArrayList<ReplyVO> datas = new ArrayList<ReplyVO>();
		conn = DBCP.connect();
		try {
			pstmt = conn.prepareStatement(sql_SELECT_ALL);
			pstmt.setInt(1, mid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				ReplyVO data = new ReplyVO();
				data.setRid(rs.getInt("rid"));
				data.setMid(rs.getInt("mid"));
				data.setId(rs.getString("id"));
				data.setDatetime(rs.getDate("datetime"));
				data.setRmsg(rs.getString("rmsg"));
				datas.add(data);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//DBCP.close(conn, pstmt);
		}

		
		return datas;
		
	}
	
	
}
