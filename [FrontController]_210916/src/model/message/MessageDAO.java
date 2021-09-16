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
	
	// [��ۻ���]
	public boolean msg_INSERT(MessageVO vo) {
		
		conn = DBCP.getConnection();
		try {
			pstmt = conn.prepareStatement(sql_INSERT);
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getMsg());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("msg_INSERT �����߻�");
			return false;
		}finally{
			DBCP.close(conn, pstmt);			
		}
		
		return true;
		
		
	}
	// [���� ��� ��ȸ]
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
			System.out.println("msg_SELECT_ONE �����߻�");
		}finally{
			DBCP.close(conn, pstmt);			
		}
		return data;
		
	}
	// [��� + ����list]
	public ArrayList<MsgSet> msg_SELECT_ALL(int mcnt, String id) {
		
		// ��ȯ�� ������
		// ���ϴ��(Message) �� ���� ����Ʈ(Reply)
		ArrayList<MsgSet> datas = new ArrayList<MsgSet>();

		conn = DBCP.getConnection();
		//System.out.println(conn);
		try {
			pstmt = conn.prepareStatement(sql_SELECT_ALL);
			pstmt.setInt(1, mcnt);
			pstmt.setString(2, "%"+id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
		// ���
				// AL�� ���� �ӽ� ������
				MsgSet data = new MsgSet();
				
				// data�� �ν��Ͻ����� set���� �ӽõ�����
				MessageVO msg = new MessageVO();
				ArrayList<ReplyVO> replys = new ArrayList<ReplyVO>();
				
				msg.setMnum(rs.getInt("mnum"));
				msg.setUserID(rs.getString("userID"));
				msg.setMsg(rs.getString("msg"));
				msg.setLikeCnt(rs.getInt("likeCnt"));
				msg.setReplyCnt(rs.getInt("replyCnt"));
				msg.setDatetime(rs.getDate("datetime"));
				//System.out.println("msg"+msg);
				
		// ���� 
				//Reply DAO�� ���� �ش� ����� �����͸� ��� �޾ƿ�
				ReplyDAO RDAO = new ReplyDAO();
				replys = RDAO.reply_SELECT_ALL(rs.getInt("mnum")); 
				//System.out.println(replys.size()+"����");
				
				
				// msg, reply ������ ������ ������� set
				data.setMsg(msg);
				data.setReplyList(replys);
				
				// data�۾��� �Ϸ�Ǿ�����, index�� ���+����list ��ü�� ����
				datas.add(data);
			}
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("msg_SELECT_ALL �����߻�");
		}finally {
			DBCP.close(conn, pstmt);
		}
	
		
		return datas;
		
	}
	// [��� ����] 
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
			System.out.println("msg_UPDATE �����߻�");
			return false;
		}finally {
			DBCP.close(conn, pstmt);
		}		
		
		return true;
		
	}

	// [��� ����] 
	public boolean msg_DELETE(MessageVO vo) {
		conn = DBCP.getConnection();
		try {
			pstmt = conn.prepareStatement(sql_DELETE);
			pstmt.setInt(1, vo.getMnum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("msg_DELETE �����߻�");
			return false;
		}finally {
			DBCP.close(conn, pstmt);
		}		
		
		return true;
		
	}
}
