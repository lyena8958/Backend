package model.member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

// get류를 받아오기 위한 맵핑 Class
class MemRowMapper implements RowMapper<MemberVO>{

	@Override
	public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberVO data = new MemberVO();
		data.setId(rs.getString("id"));
		data.setName(rs.getString("name"));
		data.setPassword(rs.getString("password"));
		data.setRole(rs.getString("role"));
		
		return data;
	}
	
	
}


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
	
	// [비즈니스 메서드]
	public void insertMember(MemberVO vo) {
		Object[] args = {vo.getId(), vo.getPassword(), vo.getName(), vo.getRole()};
		jdbcTemplate.update(INSERT, args);
	}
	 
	public void updateMember(MemberVO vo) {
		Object[] args = {vo.getPassword(), vo.getName(), vo.getRole(), vo.getId()};
		jdbcTemplate.update(UPDATE, args);
	}
	public void deleteMember(MemberVO vo) {
		jdbcTemplate.update(DELETE, vo.getId());
	}
	public MemberVO getMember(MemberVO vo) {
		Object[] args = {vo.getId(), vo.getPassword()};
		try {
			return jdbcTemplate.queryForObject(SELECT_ONE, args, new MemRowMapper());
		}catch(EmptyResultDataAccessException emptyExcep){
			System.out.println("로그인 실패!");
			return null;
		}
	}
	public List<MemberVO> getListMember(){ 
		return jdbcTemplate.query(SELECT_LIST, new MemRowMapper());
	}
	
}
