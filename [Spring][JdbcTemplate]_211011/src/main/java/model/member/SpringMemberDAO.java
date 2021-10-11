package model.member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

class MemberRowMapper implements RowMapper<MemberVO>{

	@Override
	public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberVO data = new MemberVO();
		
		data.setId(rs.getString("id"));
		data.setPassword(rs.getString("password"));
		data.setName(rs.getString("name"));
		data.setRole(rs.getString("role"));

		return data;
	}
}
@Repository()
public class SpringMemberDAO {
	String INSERT_SQL = "INSERT INTO MEMBER2 VALUES (?, ?, ?, ?)";
	String UPDATE_SQL = "UPDATE MEMBER2 SET PASSWORD=?, NAME=?, ROLE=? WHERE ID=?";
	String DELETE_SQL = "DELETE FROM MEMBER2 WHERE ID=?";
	String SELECTALL_SQL = "SELECT * FROM MEMBER2";
	String SELECT_SQL = "SELECT * FROM MEMBER2 WHERE ID=? and PASSWORD=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	public void insertMember(MemberVO vo) {
		System.out.println("JdbcTemplate insertMember");
		System.out.println(jdbcTemplate.update(INSERT_SQL, vo.getId(), vo.getPassword(), vo.getName(), vo.getRole()));
		
		/*conn = JDBC.getConnection();
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
		}*/
		
		
	}
	public void updateMember(MemberVO vo) {
		System.out.println("JdbcTemplate updateMember");
		jdbcTemplate.update(UPDATE_SQL, vo.getPassword(), vo.getName(), vo.getRole(), vo.getId());
		
		/*conn = JDBC.getConnection();
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
		}*/
	}
	public void deleteMember(MemberVO vo) {
		System.out.println("JdbcTemplate deleteMember");
		jdbcTemplate.update(DELETE_SQL, vo.getId());
		
		/*conn = JDBC.getConnection();
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
		}*/
	
	}
	public List<MemberVO> getAll() {
		System.out.println("JdbcTemplate getAll");
		return jdbcTemplate.query(SELECTALL_SQL, new MemberRowMapper());
		
		/*conn = JDBC.getConnection();
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
		
		
		return datas;*/
	}
	public MemberVO getOne(MemberVO vo) {
		System.out.println("JdbcTemplate getOne");
		Object[] args = {vo.getId(), vo.getPassword()};
		return jdbcTemplate.queryForObject(SELECT_SQL, args, new MemberRowMapper());
		
		// 로그인에 성공한다면, MemberVO 객체가 리턴(반환)
		// 실패한다면, 리턴이 null
		/*conn = JDBC.getConnection();
		MemberVO data = null;
		try {
			pstmt = conn.prepareStatement(SELECT_SQL);
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
		
		return data;*/
	}
}
// 1. Support 상속
// 2. <bean> 주입☆