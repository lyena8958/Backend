package model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {
	String sql_INSERT = "INSERT INTO LOGIN (MNUM, USERID, USERPW, USERNAME) VALUES "
			+ "((SELECT NVL(MAX(MNUM), 0)+1 FROM LOGIN), ?, ?, ?)";
	String sql_SELECT_ONE = "SELECT * FROM LOGIN WHERE USERID LIKE ? AND USERPW LIKE ?";
	String sql_SELECT_ALL = "SELECT * FROM LOGIN";
	String sql_UPDATE = "UPDATE LOGIN SET USERPW=?, USERNAME=? WHERE MNUM=?";
	String sql_DELETE = "DELETE FROM LOGIN WHERE MNUM=?";
	
	
	PreparedStatement pstmt = null;
	Connection conn = null;
	public Connection DBCP() {
		
		
		try {
			// context.xml에서 커넥션 풀 자원등록했던 거에 접근할 수 있게됨
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/orcl");
			conn = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
		
	}
	public void DBCPclose(Connection conn, PreparedStatement pstmt) {
		
		try {
			conn.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	// [회원가입] 성공 true 실패false 반환
	public boolean SignUp(MemberVO vo) {
		
		try {
				//conn = DBCP(); // DBCP연결 및 반환
			//ID중복확인
			MemberVO data = new MemberVO();
			data.setUserID(vo.getUserID());
			data = loginCheck(data);
			
			// 존재하는 아이디가있다면 가입불가
			if(data!=null) {
				return false;
			}
			
			conn = DBCP(); // DBCP연결 및 반환
			pstmt = conn.prepareStatement(sql_INSERT);
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getUserPW());
			pstmt.setString(3, vo.getUserName());
			pstmt.executeUpdate();
			
		}catch (SQLException e) {
			System.out.println("SignUp 에러");
			e.printStackTrace();
			return false;
		}finally {// CLOSE 해줌에 따라 자원반납을 체크하는 시간을 줄임
			DBCPclose(conn, pstmt);
		}
		
		return true;
	}
	
	// [로그인 체크] -selectOne
	public MemberVO loginCheck(MemberVO vo) {
		MemberVO data = null;
		
		try {
			conn = DBCP(); // DBCP연결 및 반환
			pstmt = conn.prepareStatement(sql_SELECT_ONE);
			pstmt.setString(1, "%"+vo.getUserID()+"%");
			pstmt.setString(2, "%"+vo.getUserPW()+"%");
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new MemberVO();
				data.setMnum(rs.getInt("mnum"));
				data.setUserID(rs.getString("userID"));
				data.setUserPW(rs.getString("userPW"));
				data.setUserName(rs.getString("userName"));
			}
			rs.close();
		}catch (SQLException e) {
			System.out.println("loginCheck 에러");
			e.printStackTrace();
		}finally {// CLOSE 해줌에 따라 자원반납을 체크하는 시간을 줄임
			DBCPclose(conn, pstmt);
		}
		
		return data;
	}
	// [회원가입] -selectAll
	public ArrayList<MemberVO> memLists(){
		
		ArrayList<MemberVO> datas = new ArrayList<MemberVO>();
		try {
			conn = DBCP();
			pstmt = conn.prepareStatement(sql_SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVO data = new MemberVO();
				data.setMnum(rs.getInt("mnum"));
				data.setUserID(rs.getString("userID"));
				data.setUserPW(rs.getString("userPW"));
				data.setUserName(rs.getString("userName"));
				datas.add(data);
				System.out.println(data);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("memLists 에러");
			e.printStackTrace();
		}finally {// CLOSE 해줌에 따라 자원반납을 체크하는 시간을 줄임
			DBCPclose(conn, pstmt);
		}
	
		return datas;
	}
	// [회원수정] -update
	public boolean memUpdate(MemberVO vo) {
		conn = DBCP();
		
		try {
			pstmt = conn.prepareStatement(sql_UPDATE);
			pstmt.setString(1, vo.getUserPW());
			pstmt.setString(2, vo.getUserName());
			pstmt.setInt(3, vo.getMnum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("memUpdate 에러");
			e.printStackTrace();
			return false;
		}finally {// CLOSE 해줌에 따라 자원반납을 체크하는 시간을 줄임
			DBCPclose(conn, pstmt);
		}
		
		
		return true;
	}
	// [회원탈퇴] -delete
	public boolean memDelete(MemberVO vo) {
		conn = DBCP();
		
		try {
			pstmt = conn.prepareStatement(sql_DELETE);
			pstmt.setInt(1, vo.getMnum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("memDelete 에러");
			e.printStackTrace();
			return false;
		}finally {// CLOSE 해줌에 따라 자원반납을 체크하는 시간을 줄임
			DBCPclose(conn, pstmt);
		}
		
		
		return true;
	}
}
