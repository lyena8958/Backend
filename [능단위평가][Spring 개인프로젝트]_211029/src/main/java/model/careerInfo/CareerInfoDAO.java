package model.careerInfo;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

// SELETE Äõ¸®¹® Mappet Class
class CareerRowMapper implements RowMapper<CareerInfoVO>{

	@Override
	public CareerInfoVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		CareerInfoVO data = new CareerInfoVO();
		
		data.setCnum(rs.getInt("CNUM"));
		data.setStartDate(rs.getDate("STARTDATE"));
		data.setEndDate(rs.getDate("ENDDATE"));
		data.setCompName(rs.getString("COMPNAME"));
		data.setPosition(rs.getString("POSITION"));
		data.setRank(rs.getInt("RANK"));
		data.setDuty(rs.getString("DUTY"));
		data.setCnum(rs.getInt("CNUM"));
		
		return data;
	}
	
}
@Repository
public class CareerInfoDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// Äõ¸®¹®
	private String GET_ONE = "SELECT * FROM CAREERINFO WHERE CNUM=?";
	private String GET_LIST = "SELECT * FROM CAREERINFO";
	private String INSERT = "INSERT INTO CAREERINFO (CNUM, STARTDATE, ENDDATE, COMPNAME, POSITION, RANK, DUTY, CMEM) VALUES ((SELECT NVL(MAX(CNUM),0)+1 FROM CAREERINFO), ?, ?, ?, ?, ?, ?, ?)";
	private String UPDATE = "UPDATE CAREERINFO SET STARTDATE=?, ENDDATE=?, COMPNAME=?, POSITION=?, RANK=?, DUTY=? WHERE CNUM=?";
	private String DELETE = "DELETE FROM CAREERINFO WHERE CNUM=?";
	
	//[ONE]
	public CareerInfoVO getData(CareerInfoVO vo) {
		Object[] args = {vo.getCnum()};
		return jdbcTemplate.queryForObject(GET_ONE, args, new CareerRowMapper());
		
	}
	
	//[LIST]
	public List<CareerInfoVO> getList(CareerInfoVO vo) {
		//Object[] args = {};
		return jdbcTemplate.query(GET_LIST, new CareerRowMapper());
		
	}
	
	//[INSERT]
	public boolean insertCareer(CareerInfoVO vo) {
		Object[] args = {vo.getStartDate(), vo.getEndDate(), vo.getCompName(), vo.getPosition(), vo.getRank(), vo.getDuty(), vo.getcMem()};
		jdbcTemplate.update(INSERT, args);
		
		return true;
	}
	
	//[UPDATE]
	public boolean updateCareer(CareerInfoVO vo) {
		Object[] args = {vo.getStartDate(), vo.getEndDate(), vo.getCompName(), vo.getPosition(), vo.getRank(), vo.getDuty()};
		jdbcTemplate.update(UPDATE, args);
		
		return true;
	}
	
	//[DELETE]
	public boolean deleteCareer(CareerInfoVO vo) {
		jdbcTemplate.update(DELETE, vo.getCnum());
		
		return true;
	}
}
