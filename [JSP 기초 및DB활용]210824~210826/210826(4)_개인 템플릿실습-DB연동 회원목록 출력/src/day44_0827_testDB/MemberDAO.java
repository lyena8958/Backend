package day44_0827_testDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
	
	String sql_SELECT_ONE = "select * from orderMember where userID=?";
	String sql_SELECT_ALL = "select * from orderMember";
	String sql_INSERT = "insert into orderMember values((select nvl(max(onum), 0)+1 from orderMember) ,?, ?, ?)";
	String sql_UPDATE = "update orderMember set userName=?, userPW=? where onum=?";
	String sql_DELETE = "delete from orderMember where onum=";
	
	//ArrayList<MemberVO> datas = new ArrayList<MemberVO>();
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	
	//[메서드] insert - 데이터 삽입(==회원가입)
	public void memInsert(MemberVO vo) {
		conn = JDBC.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql_INSERT); // sql문으로 DB연동한conn을통해  → db접근
			pstmt.setString(1, vo.getUserName());
			pstmt.setString(2, vo.getUserID());
			pstmt.setString(3, vo.getUserPW());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
	}
	
	//[메서드] selectOne --> 단일 data반환
	public MemberVO memSelectOne(MemberVO vo) {
		MemberVO data = null;
		
		conn = JDBC.getConnection(); //DB연결
		
		try {
			pstmt = conn.prepareStatement(sql_SELECT_ONE); // sql문으로 db접근
			pstmt.setString(1, vo.getUserID());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new MemberVO();
				data.setOnum(rs.getInt("onum"));
				data.setUserID(rs.getString("userID"));
				data.setUserPW(rs.getString("userPW"));
				data.setUserName(rs.getString("userName"));
			}
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			JDBC.close(conn, pstmt);
		}
		
		System.out.println("memSelectOne 수행완료");
		
		return data;
	}
	//[메서드] selectALL --> 전체 datas 반환
		public ArrayList<MemberVO> memSelectAll() {
			ArrayList<MemberVO> datas = new ArrayList<MemberVO>();
			System.out.println(datas.size());
			conn = JDBC.getConnection(); //DB연결
			
			try {
				pstmt = conn.prepareStatement(sql_SELECT_ALL); // sql문으로 db접근
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) { //여러 데이터를 받아올 예정으로 1회당==1객체 -> 반복문으로 데이터를 받아온다.
					MemberVO data = new MemberVO(); // 임시저장공간(1객체)
					data.setOnum(rs.getInt("onum"));
					data.setUserID(rs.getString("userID"));
					data.setUserPW(rs.getString("userPW"));
					data.setUserName(rs.getString("userName"));
					datas.add(data); // 반환할 datas에 객체단위로 저장
				}
				rs.close();
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}finally {
				JDBC.close(conn, pstmt);
			}
			
			System.out.println("memSelectAll 수행완료");
			
			return datas;
		}
		
	//[메서드] update --> 회원정보변경 - 이름,비밀번호 (onum pk로 정보를 찾음)
	public void memUpdate(MemberVO vo) {
		
		conn = JDBC.getConnection(); //DB연결
		try {
			pstmt = conn.prepareStatement(sql_UPDATE); // sql문으로 db접근
			pstmt.setString(1, vo.getUserName()); // 첫번째 인자 set
			pstmt.setString(2, vo.getUserPW()); // 두번째 인자 set
			pstmt.setInt(3, vo.getOnum()); // 세번째 인자 set
			pstmt.executeUpdate(); // 입력데이터 업데이트(DB반영)
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			JDBC.close(conn, pstmt);
		}
		
		System.out.println("memUpdate 수행완료");
	}

	//[메서드] dalete --> 회원탈퇴
	public void memDelete(MemberVO vo) {
		
		conn = JDBC.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql_DELETE);
			pstmt.setInt(1, vo.getOnum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		System.out.println("memDelete 수행완료");
	}
	
	//[메서드] 로그인여부 --> selectOne메서드활용
	public boolean loginCheck(MemberVO vo) {
		MemberVO data = memSelectOne(vo);
		System.out.println(data);
		// selectOne 반환시 null로 받았다면 == 아이디정보없음 == 로그인 실패
		//또는
		// PW가 서로 같지않다면 == 로그인 실패
		if(data==null ||
				!data.getUserPW().equals(vo.getUserPW())) {
			System.out.println("로그인실패");
			return false;
		}
		
		return true;
		
	}
	
}
