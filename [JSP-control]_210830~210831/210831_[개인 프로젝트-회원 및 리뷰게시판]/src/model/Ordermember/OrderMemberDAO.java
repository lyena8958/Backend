package model.Ordermember;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.commit.JDBC;

public class OrderMemberDAO {
	
	String sql_SELECT_ONE = "select * from orderMember where userID=? and userPW=?";
	String sql_SELECT_ALL = "select * from orderMember";
	String sql_INSERT = "insert into orderMember values((select nvl(max(onum), 0)+1 from orderMember) ,?, ?, ?)";
	String sql_UPDATE = "update orderMember set userName=?, userPW=? where onum=?";
	String sql_DELETE = "delete from orderMember where onum=";
	
	//ArrayList<MemberVO> datas = new ArrayList<MemberVO>();
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	
	//[메서드] insert - 데이터 삽입(==회원가입)
	public void memInsert(OrderMemberVO vo) {
		conn = JDBC.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql_INSERT); // sql문으로 DB연동한conn을통해  → db접근
			pstmt.setString(1, vo.getUserName());
			pstmt.setString(2, vo.getUserID());
			pstmt.setString(3, vo.getUserPW());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("memInsert에서 오류발생");
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
	}
	
	//[메서드] selectOne --> 단일 data반환
	public OrderMemberVO memSelectOne(OrderMemberVO vo) {
		OrderMemberVO data = null;
		
		conn = JDBC.getConnection(); //DB연결
		
		try {
			pstmt = conn.prepareStatement(sql_SELECT_ONE); // sql문으로 db접근
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getUserPW());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new OrderMemberVO();
				data.setOnum(rs.getInt("onum"));
				data.setUserID(rs.getString("userID"));
				data.setUserPW(rs.getString("userPW"));
				data.setUserName(rs.getString("userName"));
			}
			rs.close();
			
		} catch (Exception e) {
			System.out.println("memselectone에서 오류발생");
			e.printStackTrace();
			
		}finally {
			JDBC.close(conn, pstmt);
		}
		
		//System.out.println("memSelectOne 수행완료");
		
		return data;
	}
	//[메서드] selectALL --> 전체 datas 반환
		public ArrayList<OrderMemberVO> memSelectAll() {
			ArrayList<OrderMemberVO> datas = new ArrayList<OrderMemberVO>();
			System.out.println(datas.size());
			conn = JDBC.getConnection(); //DB연결
			
			try {
				pstmt = conn.prepareStatement(sql_SELECT_ALL); // sql문으로 db접근
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) { //여러 데이터를 받아올 예정으로 1회당==1객체 -> 반복문으로 데이터를 받아온다.
					OrderMemberVO data = new OrderMemberVO(); // 임시저장공간(1객체)
					data.setOnum(rs.getInt("onum"));
					data.setUserID(rs.getString("userID"));
					data.setUserPW(rs.getString("userPW"));
					data.setUserName(rs.getString("userName"));
					datas.add(data); // 반환할 datas에 객체단위로 저장
				}
				rs.close();
				
			} catch (Exception e) {
				System.out.println("memSelectAll에서 오류발생");
				e.printStackTrace();
				
			}finally {
				JDBC.close(conn, pstmt);
			}
			
			System.out.println("memSelectAll 수행완료");
			
			return datas;
		}
		
	//[메서드] update --> 회원정보변경 - 이름,비밀번호 (onum pk로 정보를 찾음)
	public void memUpdate(OrderMemberVO vo) {
		
		conn = JDBC.getConnection(); //DB연결
		try {
			pstmt = conn.prepareStatement(sql_UPDATE); // sql문으로 db접근
			pstmt.setString(1, vo.getUserName()); // 첫번째 인자 set
			pstmt.setString(2, vo.getUserPW()); // 두번째 인자 set
			pstmt.setInt(3, vo.getOnum()); // 세번째 인자 set
			pstmt.executeUpdate(); // 입력데이터 업데이트(DB반영)
			
		} catch (SQLException e) {
			System.out.println("memUpdate에서 오류발생");
			e.printStackTrace();
			
		}finally {
			JDBC.close(conn, pstmt);
		}
		
		System.out.println("memUpdate 수행완료");
	}

	//[메서드] dalete --> 회원탈퇴
	public void memDelete(OrderMemberVO vo) {
		
		conn = JDBC.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql_DELETE);
			pstmt.setInt(1, vo.getOnum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("memDelete에서 오류발생");
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		//System.out.println("memDelete 수행완료");
	}
	
	
	
	// 기능 메서드 ↓↓↓
	// 향후에 DAO클래스에서 타 클래스로 메서드만 분할해야할듯 
	
	//[메서드] 로그인여부 --> selectOne메서드활용
	public boolean loginCheck(OrderMemberVO vo) {
		OrderMemberVO data = memSelectOne(vo);
		//System.out.println(data);
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
