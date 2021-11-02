package model.hradmin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import model.member.MemberDAO;


//SELETE 쿼리문 MappeR Class
class HRAdminRowMapper implements RowMapper<HRAdminVO>{

	@Override
	public HRAdminVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		HRAdminVO data = new HRAdminVO();
		
		data.setHnum(rs.getInt("HNUM"));
		data.setPw(rs.getString("PW"));
		data.setHmem(rs.getInt("HMEM"));
		
		return data;
	}
	
}
@Repository
public class HRAdminDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private MemberDAO Memberdao;
	
	// 쿼리문
	private String GET_ONE = "SELECT * FROM HRADMIN WHERE hmem=? AND PW=?";
	private String GET_LIST = "SELECT * FROM HRADMIN";
	private String INSERT = "INSERT INTO HRADMIN (HNUM, HMEM, PW) VALUES ((SELECT NVL(MAX(HNUM),0)+1 FROM HRADMIN), ?, ?)";
	private String UPDATE = "UPDATE HRADMIN SET PW=? WHERE HNUM=?";
	private String DELETE = "DELETE FROM HRADMIN WHERE HNUM=?";
	
	private String GET_ONE_MEMBER = "SELECT * FROM MEMBER WHERE MNUM=?";
	
	//[ONE]
	public HRAdminVO getData(HRAdminVO vo) {
		Object[] args = {vo.getHmem(), vo.getPw()};
	
		try {
			return jdbcTemplate.queryForObject(GET_ONE, args, new HRAdminRowMapper());
			
		}catch(Exception e) {
			return null;
		}
	}
	
	//[LIST]
	public List<HRAdminVO> getList(HRAdminVO vo) {
		//Object[] args = {};
		return jdbcTemplate.query(GET_LIST, new HRAdminRowMapper());
		
	}
	
	//[INSERT]
	public boolean insertHRAdmin(HRAdminVO vo) {
		Object[] args = {vo.getHmem(), vo.getPw()};
		
		try {
			 // member테이블에 사번이 조회가 된 경우, insert진행
			if(Memberdao.getData(vo.getHmem())!=null) {
				jdbcTemplate.update(INSERT, args);
				return true;
			}			
			
		}catch(Exception e) {
			return false;
		}
		
		return false;
	}
	
	//[UPDATE]
	public boolean updateHRAdmin(HRAdminVO vo) {
		Object[] args = {vo.getPw(), vo.getHnum()};
		jdbcTemplate.update(UPDATE, args);
		
		return true;
	}
	
	//[DELETE]
	public boolean deleteHRAdmin(HRAdminVO vo) {
		jdbcTemplate.update(DELETE, vo.getHnum());
		
		return true;
	}
}
