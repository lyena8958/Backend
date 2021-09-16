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
	String sql_INSERT = "INSERT INTO MESSAGE (MNUM, USERID, MSG, DATETIME) VALUES "
			+ "((SELECT NVL(MAX(MNUM),0)+1 FROM MESSAGE), ?, ?, sysdate)";
	String sql_SELECT_ONE = "SELECT * FROM MESSAGE WHERE MNUM=?";
	String sql_SELECT_ALL = "SELECT * FROM (SELECT * FROM MESSAGE ORDER BY MNUM DESC) WHERE ROWNUM <= ? AND USERID LIKE ? ORDER BY MNUM DESC";
	String sql_UPDATE = "UPDATE MESSAGE SET MSG=?, LIKECNT=?, REPLYCNT=? WHERE MNUM=?";
	String sql_DELETE = "DELETE FROM MESSAGE WHERE MNUM=?";
	
	Connection conn;
	PreparedStatement pstmt; 
	
	// [댓글생성]
	public boolean msg_INSERT(MessageVO vo) {
		
		conn = DBCP.getConnection();
		try {
			pstmt = conn.prepareStatement(sql_INSERT);
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getMsg());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("msg_INSERT 오류발생");
			return false;
		}finally{
			DBCP.close(conn, pstmt);			
		}
		
		return true;
		
		
	}
	// [단일 댓글 조회]
	public MessageVO msg_SELECT_ONE(MessageVO vo) {
		MessageVO data = null;
		
		conn = DBCP.getConnection();
		try {
			pstmt = conn.prepareStatement(sql_SELECT_ONE);
			pstmt.setInt(1, vo.getMnum());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new MessageVO();
				data.setMnum(rs.getInt("mnum"));
				data.setUserID(rs.getString("userID"));
				data.setMsg(rs.getString("msg"));
				data.setLikeCnt(rs.getInt("likeCnt"));
				data.setReplyCnt(rs.getInt("replyCnt"));
				data.setDatetime(rs.getDate("datetime"));
				//System.out.println(data);
			}
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("msg_SELECT_ONE 오류발생");
		}finally{
			DBCP.close(conn, pstmt);			
		}
		return data;
		
	}
	// [댓글 + 대댓글list]
	public ArrayList<MsgSet> msg_SELECT_ALL(int mcnt, String id) {
		
		// 반환할 데이터
		// 단일댓글(Message) ↔ 대댓글 리스트(Reply)
		ArrayList<MsgSet> datas = new ArrayList<MsgSet>();

		conn = DBCP.getConnection();
		//System.out.println(conn);
		try {
			pstmt = conn.prepareStatement(sql_SELECT_ALL);
			pstmt.setInt(1, mcnt);
			pstmt.setString(2, "%"+id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
		// 댓글
				// AL에 넣을 임시 데이터
				MsgSet data = new MsgSet();
				
				// data에 인스턴스변수 set해줄 임시데이터
				MessageVO msg = new MessageVO();
				ArrayList<ReplyVO> replys = new ArrayList<ReplyVO>();
				
				msg.setMnum(rs.getInt("mnum"));
				msg.setUserID(rs.getString("userID"));
				msg.setMsg(rs.getString("msg"));
				msg.setLikeCnt(rs.getInt("likeCnt"));
				msg.setReplyCnt(rs.getInt("replyCnt"));
				msg.setDatetime(rs.getDate("datetime"));
				//System.out.println("msg"+msg);
				
		// 대댓글 
				//Reply DAO를 통해 해당 댓글의 데이터를 모두 받아옴
				ReplyDAO RDAO = new ReplyDAO();
				replys = RDAO.reply_SELECT_ALL(rs.getInt("mnum")); 
				//System.out.println(replys.size()+"리플");
				
				
				// msg, reply 설정된 데이터 멤버변수 set
				data.setMsg(msg);
				data.setReplyList(replys);
				
				// data작업이 완료되었으니, index별 댓글+대댓글list 객체를 삽입
				datas.add(data);
			}
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("msg_SELECT_ALL 오류발생");
		}finally {
			DBCP.close(conn, pstmt);
		}
	
		
		return datas;
		
	}
	// [댓글 수정] 
	public boolean msg_UPDATE(MessageVO vo) {
		conn = DBCP.getConnection();
		System.out.println(vo);
		try {
			pstmt = conn.prepareStatement(sql_UPDATE);
			pstmt.setString(1, vo.getMsg());
			pstmt.setInt(2, vo.getLikeCnt());
			pstmt.setInt(3, vo.getReplyCnt());
			pstmt.setInt(4, vo.getMnum());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("msg_UPDATE 오류발생");
			return false;
		}finally {
			DBCP.close(conn, pstmt);
		}		
		
		return true;
		
	}

	// [댓글 삭제] 
	public boolean msg_DELETE(MessageVO vo) {
		conn = DBCP.getConnection();
		try {
			pstmt = conn.prepareStatement(sql_DELETE);
			pstmt.setInt(1, vo.getMnum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("msg_DELETE 오류발생");
			return false;
		}finally {
			DBCP.close(conn, pstmt);
		}		
		
		return true;
		
	}
}
