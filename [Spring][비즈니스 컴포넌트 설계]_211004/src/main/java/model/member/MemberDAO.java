package model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import model.common.JDBC;

@Repository("memberDAO")
public class MemberDAO {
	String INSERT_SQL = "INSERT INTO MEMBER2 VALUES (?, ?, ?, ?)";
	String UPDATE_SQL = "UPDATE MEMBER2 SET PASSWORD=?, NAME=?, ROLE=? WHERE ID=?";
	String DELETE_SQL = "DELETE FROM MEMBER2 WHERE ID=?";
	String SELECTALL_SQL = "SELECT * FROM MEMBER2";
	String SELECT_SQL = "SELECT * FROM MEMBER2 WHERE ID=?";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public boolean insertMember(MemberVO vo) {
		conn = JDBC.getConnection();
		try {
			pstmt = conn.prepareStatement(INSERT_SQL);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getRole());
			pstmt.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			JDBC.close(conn, pstmt);
		}
		
		
	}
	public boolean updateMember(MemberVO vo) {
		
		conn = JDBC.getConnection();
		try {
			pstmt = conn.prepareStatement(UPDATE_SQL);
			pstmt.setString(1, vo.getPassword());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getRole());
			pstmt.setString(4, vo.getId());
			pstmt.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			JDBC.close(conn, pstmt);
		}
	}
	public boolean deleteMember(MemberVO vo) {
		
		conn = JDBC.getConnection();
		try {
			pstmt = conn.prepareStatement(DELETE_SQL);
			pstmt.setString(1, vo.getId());
			pstmt.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			JDBC.close(conn, pstmt);
		}
	
	}
	public List<MemberVO> getAll() {
		
		conn = JDBC.getConnection();
		List<MemberVO> datas = new ArrayList<MemberVO>();
		try {
			pstmt = conn.prepareStatement(SELECTALL_SQL);
			rs  = pstmt.executeQuery();
			while(rs.next()) {
				MemberVO data = new MemberVO();
				data.setId(rs.getString("id"));
				data.setPassword(rs.getString("password"));
				data.setName(rs.getString("name"));
				data.setRole(rs.getString("role"));
				datas.add(data);
			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		
		
		return datas;
	}
	public MemberVO getOne(MemberVO vo) {
		
		conn = JDBC.getConnection();
		MemberVO data = null;
		try {
			pstmt = conn.prepareStatement(SELECT_SQL);
			rs  = pstmt.executeQuery();
			if(rs.next()) {
				data = new MemberVO();
				data.setId(rs.getString("id"));
				data.setPassword(rs.getString("password"));
				data.setName(rs.getString("name"));
				data.setRole(rs.getString("role"));
			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		
		return data;
	}

}
