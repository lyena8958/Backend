package model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import model.common.JDBC;



@Repository
public class MemberDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// [sql구문]
	String INSERT = "INSERT INTO MEMBER2 (id, password, name, role) VALUES (?, ?, ?, ?)";
	String UPDATE = "UPDATE MEMBER2 SET PASSWORD=?, NAME=?, ROLE=? WHERE ID=?";
	String DELETE = "DELETE FROM MEMBER2 WHERE ID=?";
	String SELECT_ONE = "SELECT * FROM MEMBER2 WHERE ID=? AND PASSWORD=?";
	String SELECT_LIST= "SELECT * FROM MEMBER2";
	
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	// [비즈니스 메서드]
	public boolean insertMember(MemberVO vo) {
		System.out.println("DAO insertMember");
		conn = JDBC.getConnection();
		try {
			pstmt = conn.prepareStatement(INSERT);
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
		System.out.println("DAO updateMember");
		conn = JDBC.getConnection();
		try {
			pstmt = conn.prepareStatement(UPDATE);
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
		System.out.println("DAO deleteMember");
		conn = JDBC.getConnection();
		try {
			pstmt = conn.prepareStatement(DELETE);
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
	public MemberVO getMember(MemberVO vo) {
		System.out.println("DAO getOne");
		// 로그인에 성공한다면, MemberVO 객체가 리턴(반환)
		// 실패한다면, 리턴이 null
		conn = JDBC.getConnection();
		MemberVO data = null;
		try {
			pstmt = conn.prepareStatement(SELECT_ONE);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
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
	public List<MemberVO> getListMember(){ 
		System.out.println("DAO getAll");
		conn = JDBC.getConnection();
		List<MemberVO> datas = new ArrayList<MemberVO>();
		try {
			pstmt = conn.prepareStatement(SELECT_LIST);
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
	
}
