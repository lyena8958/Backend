package model.message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.DBCP;
import model.reply.ReplyDAO;
import model.reply.ReplyVO;

public class MessageDAO {
	String sql_INSERT = "INSERT INTO MESSAGE (MID, ID, MSG, DATETIME) VALUES "
			+ "((SELECT NVL(MAX(MID),0)+1 FROM MESSAGE), ?, ?, sysdate)";
	String sql_SELECT_ONE = "SELECT * FROM MESSAGE WHERE MID=?";
	String sql_SELECT_ALL = "SELECT * FROM MESSAGE WHERE ROWNUM <= ? AND ID LIKE ? ORDER BY DATETIME DESC";
	String sql_UPDATE = "UPDATE MESSAGE SET MSG=?, FAVCOUNT=?, REPLYCOUNT=? WHERE MID=?";
	String sql_DELETE = "DELETE FROM MESSAGE WHERE MID=?";
	
	Connection conn;
	PreparedStatement pstmt; 
	
	// [댓글생성]
	public boolean msg_INSERT(MessageVO vo) {
		
		conn = DBCP.connect();
		try {
			pstmt = conn.prepareStatement(sql_INSERT);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getMsg());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally{
			//DBCP.close(conn, pstmt);			
		}
		
		return true;
		
		
	}
	// [단일 댓글 조회]
	public MessageVO msg_SELECT_ONE(MessageVO vo) {
		MessageVO data = null;
		
		conn = DBCP.connect();
		try {
			pstmt = conn.prepareStatement(sql_SELECT_ONE);
			pstmt.setInt(1, vo.getMid());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new MessageVO();
				data.setMid(rs.getInt("mid"));
				data.setId(rs.getString("id"));
				data.setMsg(rs.getString("msg"));
				data.setFavcount(rs.getInt("favcount"));
				data.setReplycount(rs.getInt("replycount"));
				data.setDatetime(rs.getDate("datetime"));
			}
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//DBCP.close(conn, pstmt);			
		}
		return data;
		
	}
	// [댓글 + 대댓글list]
	public ArrayList<MsgSet> msg_SELECT_ALL(int cnt, String id) {
		
		// 반환할 데이터
		// 단일댓글(Message) ↔ 대댓글 리스트(Reply)
		ArrayList<MsgSet> datas = new ArrayList<MsgSet>();

		conn = DBCP.connect();
		System.out.println(conn);
		try {
			pstmt = conn.prepareStatement(sql_SELECT_ALL);
			pstmt.setInt(1, cnt);
			pstmt.setString(2, "%"+id+"%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
		// 댓글
				// AL에 넣을 임시 데이터
				MsgSet data = new MsgSet();
				
				// data에 인스턴스변수 set해줄 임시데이터
				MessageVO msg = new MessageVO();
				ArrayList<ReplyVO> replys = new ArrayList<ReplyVO>();
				
				msg.setMid(rs.getInt("mid"));
				msg.setId(rs.getString("id"));
				msg.setMsg(rs.getString("msg"));
				msg.setFavcount(rs.getInt("favcount"));
				msg.setReplycount(rs.getInt("replycount"));
				msg.setDatetime(rs.getDate("datetime"));
				
				
		// 대댓글 
				//Reply DAO를 통해 해당 댓글의 데이터를 모두 받아옴
				ReplyDAO RDAO = new ReplyDAO();
				replys = RDAO.reply_SELECT_ALL(rs.getInt("mid")); 
				
				
				
				// msg, reply 설정된 데이터 멤버변수 set
				data.setMsg(msg);
				data.setReply_List(replys);
				
				// data작업이 완료되었으니, index별 댓글+대댓글list 객체를 삽입
				datas.add(data);
			}
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
		return datas;
		
	}
	// [댓글 수정] 
	public boolean msg_UPDATE(MessageVO vo) {
		conn = DBCP.connect();
		try {
			pstmt = conn.prepareStatement(sql_UPDATE);
			pstmt.setString(1, vo.getMsg());
			pstmt.setInt(2, vo.getFavcount());
			pstmt.setInt(3, vo.getReplycount());
			pstmt.setInt(4, vo.getMid());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			//DBCP.close(conn, pstmt);
		}		
		
		return true;
		
	}

	// [댓글 삭제] 
	public boolean msg_DELETE(MessageVO vo) {
		conn = DBCP.connect();
		try {
			pstmt = conn.prepareStatement(sql_DELETE);
			pstmt.setInt(1, vo.getMid());
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
