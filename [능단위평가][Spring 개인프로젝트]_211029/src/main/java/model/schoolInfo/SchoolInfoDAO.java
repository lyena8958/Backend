package model.schoolInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

//SELETE Äõ¸®¹® MappeR Class
class SchoolRowMapper implements RowMapper<SchoolInfoVO>{

	@Override
	public SchoolInfoVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		SchoolInfoVO data = new SchoolInfoVO();
		
		data.setSnum(rs.getInt("SNUM"));
		data.setStype(rs.getString("STYPE"));
		data.setSname(rs.getString("SNAME"));
		data.setStartDate(rs.getDate("STARTDATE"));
		data.setEndDate(rs.getDate("ENDDATE"));
		data.setField(rs.getString("FIELD"));
		data.setMajor(rs.getString("MAJOR"));
		data.setFinish(rs.getString("FINISH"));
		data.setsMem(rs.getInt("SMEM"));
		
		return data;
	}
	
}
@Repository
public class SchoolInfoDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// Äõ¸®¹®
	private String GET_ONE = "SELECT * FROM SCHOOLINFO WHERE SNUM=?";
	private String GET_LIST = "SELECT * FROM SCHOOLINFO";
	private String INSERT = "INSERT INTO SCHOOLINFO (SNUM, STYPE, SNAME, STARTDATE, ENDDATE, FIELD, MAJOR, FINISH, SMEM) VALUES ((SELECT NVL(MAX(SNUM),0)+1 FROM SCHOOLINFO), ?, ?, ?, ?, ?, ?, ?, ?)";
	private String UPDATE = "UPDATE SCHOOLINFO SET STYPE=?, SNAME=?, STARTDATE=?, ENDDATE=?, FIELD=?, MAJOR=?, FINISH=? WHERE SNUM=?";
	private String DELETE = "DELETE FROM SCHOOLINFO WHERE SNUM=?";
	
	//[ONE]
	public SchoolInfoVO getData(SchoolInfoVO vo) {
		Object[] args = {vo.getSnum()};
		return jdbcTemplate.queryForObject(GET_ONE, args, new SchoolRowMapper());
		
	}
	
	//[LIST]
	public List<SchoolInfoVO> getList(SchoolInfoVO vo) {
		//Object[] args = {};
		return jdbcTemplate.query(GET_LIST, new SchoolRowMapper());
		
	}
	
	//[INSERT]
	public boolean insertSchool(SchoolInfoVO vo) {
		Object[] args = {vo.getStype(), vo.getSname(), vo.getStartDate(), vo.getEndDate(), vo.getField(), vo.getMajor(), vo.getFinish(), vo.getsMem()};
		jdbcTemplate.update(INSERT, args);
		
		return true;
	}
	
	//[UPDATE]
	public boolean updateSchool(SchoolInfoVO vo) {
		Object[] args = {vo.getStype(), vo.getSname(), vo.getStartDate(), vo.getEndDate(), vo.getField(), vo.getMajor(), vo.getFinish(), vo.getSnum()};
		jdbcTemplate.update(UPDATE, args);
		
		return true;
	}
	
	//[DELETE]
	public boolean deleteSchool(SchoolInfoVO vo) {
		jdbcTemplate.update(DELETE, vo.getSnum());
		
		return true;
	}
}
