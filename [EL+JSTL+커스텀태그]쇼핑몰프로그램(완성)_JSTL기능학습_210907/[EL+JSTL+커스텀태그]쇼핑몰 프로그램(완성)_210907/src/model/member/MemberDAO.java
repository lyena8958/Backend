package model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.commit.JDBC;

public class MemberDAO {
	String sql_INSERT = "INSERT INTO MEMBER (MNUM, USERID, USERPW, USERNAME) VALUES "
			+ "((SELECT NVL(MAX(MNUM), 0)+1 FROM MEMBER), ?, ?, ?)";
	String sql_SELECT_ALL = "SELECT * FROM MEMBER";
	String sql_SELECT_ONE = "SELECT * FROM MEMBER WHERE USERID LIKE ? AND USERPW LIKE ?";
	String sql_UPDATE = "UPDATE MEMBER SET USERPW=?, USERNAME=? WHERE MNUM=?";
	String sql_DELETE = "DELETE FROM MEMBER WHERE MNUM=?";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	// [회원가입]
	public boolean signUp(MemberVO vo) {
		//System.out.println(vo);
		
		try {
			//conn = JDBC.getConnection();
			// 중복ID 여부 확인
			MemberVO data = new MemberVO();
			data.setUserID(vo.getUserID());
			data.setUserPW(""); // ID만 조회할 예정으로 PW는 공백으로 전송
			data = MemData(data); // 단일 데이터 조회
			if(data!=null) {// 받아온 데이터가 조회가 된다면 == 중복ID존재 == 가입불가
				return false;
			}
			conn = JDBC.getConnection();
			// return 되지 않았다면,
			// 회원가입 INSERT 진행
			pstmt = conn.prepareStatement(sql_INSERT);
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getUserPW());
			pstmt.setString(3, vo.getUserName());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("signUpCheck 오류발생");
			return false;
		}finally {
			JDBC.close(conn, pstmt);
		}
		
		return true;
	}
	
	// [회원 전체목록 반환]
	public ArrayList<MemberVO> MemDataList(){
		ArrayList<MemberVO> datas = new ArrayList<MemberVO>();
		
		try {
			conn = JDBC.getConnection();
			pstmt = conn.prepareStatement(sql_SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVO data = new MemberVO();
				data.setMnum(rs.getInt("MNUM"));
				data.setUserID(rs.getString("USERID"));
				data.setUserPW(rs.getString("USERPW"));
				data.setUserName(rs.getString("USERNAME"));
				datas.add(data); // 인데스 별 객체삽입
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("MemDataList 오류발생");
		}finally {
			JDBC.close(conn, pstmt);
		}
		
		return datas; // 저장된 데이터 리턴 
	}
	
	// [단일회원 반환]
	public MemberVO MemData(MemberVO vo){
		MemberVO data = null;
		conn = JDBC.getConnection();
		try {
			pstmt = conn.prepareStatement(sql_SELECT_ONE);
			pstmt.setString(1, "%"+vo.getUserID()+"%");
			pstmt.setString(2, "%"+vo.getUserPW()+"%"); // ID만 조회할 예정으로 PW는 공백으로 전송
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new MemberVO();
				data.setMnum(rs.getInt("MNUM"));
				data.setUserID(rs.getString("USERID"));
				data.setUserPW(rs.getString("USERPW"));
				data.setUserName(rs.getString("USERNAME"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("MemData 오류발생");
		}finally {
			JDBC.close(conn, pstmt);
		}
			
		return data;
	}

	// [회원정보 수정]
	public boolean MemUpdate(MemberVO vo) {
		conn = JDBC.getConnection();
		try {
			pstmt = conn.prepareStatement(sql_UPDATE);
			pstmt.setString(1, vo.getUserPW());
			pstmt.setString(2, vo.getUserName()); 
			pstmt.setInt(3, vo.getMnum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("MemUpdate 오류발생");
			return false;
		}finally {
			JDBC.close(conn, pstmt);
		}
		
		return true;
	}
	
	// [회원탈퇴]
	public boolean MemDelete(MemberVO vo) {
		conn = JDBC.getConnection();
		try {
			pstmt = conn.prepareStatement(sql_DELETE);
			pstmt.setInt(1, vo.getMnum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("MemDelete 오류발생");
		}finally {
			JDBC.close(conn, pstmt);
		}
		
		return true;
	}
}
