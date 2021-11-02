package model.licenseInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import model.careerInfo.CareerInfoVO;


//SELETE 쿼리문 MappeR Class
class LicenseRowMapper implements RowMapper<LicenseInfoVO>{

	@Override
	public LicenseInfoVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		LicenseInfoVO data = new LicenseInfoVO();
		
		data.setLnum(rs.getInt("LNUM"));
		data.setGetDate(rs.getDate("GETDATE"));
		data.setExpireDate(rs.getDate("EXPIREDATE"));
		data.setLname(rs.getString("LNAME"));
		data.setGrade(rs.getString("GRADE"));
		data.setLmem(rs.getInt("LMEM"));
		
		return data;
	}
	
}

@Repository
public class LicenseInfoDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// 쿼리문
	private String GET_ONE = "SELECT * FROM LICENSEINFO WHERE LNUM=?";
	private String GET_LIST = "SELECT * FROM LICENSEINFO WHERE LMEM=? ORDER BY LMEM ASC";
	private String INSERT = "INSERT INTO LICENSEINFO (LNUM, GETDATE, EXPIREDATE, LNAME, GRADE, LMEM) VALUES ((SELECT NVL(MAX(LNUM),0)+1 FROM LICENSEINFO), ?, ?, ?, ?, ?)";
	private String UPDATE = "UPDATE LICENSEINFO SET GETDATE=?, EXPIREDATE=?, LNAME=?, GRADE=? WHERE LNUM=?";
	private String DELETE = "DELETE FROM LICENSEINFO WHERE LNUM=?";
	
	//[ONE]
	public LicenseInfoVO getData(LicenseInfoVO vo) {
		Object[] args = {vo.getLnum()};
		return jdbcTemplate.queryForObject(GET_ONE, args, new LicenseRowMapper());
		
	}
	
	//[LIST]
	public List<LicenseInfoVO> getList(LicenseInfoVO vo) {
		Object[] args = {vo.getLmem()};
		List<LicenseInfoVO> datas = jdbcTemplate.query(GET_LIST, args, new LicenseRowMapper());
		return datas = (datas.size()==0)? null : datas; // 삼항연산 : 참이라면 null반환, 아니라면 데이터 반환
	}
	
	//[INSERT]
	public boolean insertLicense(LicenseInfoVO vo) {
		Object[] args = {vo.getGetDate(), vo.getExpireDate(), vo.getLname(), vo.getGrade(), vo.getLmem()};
		jdbcTemplate.update(INSERT, args);
		
		return true;
	}
	
	//[UPDATE]
	public boolean updateLicense(LicenseInfoVO vo) {
		Object[] args = {vo.getGetDate(), vo.getExpireDate(), vo.getLname(), vo.getGrade(), vo.getLnum()};
		jdbcTemplate.update(UPDATE, args);
		
		return true;
	}
	
	//[DELETE]
	public boolean deleteLicense(LicenseInfoVO vo) {
		jdbcTemplate.update(DELETE, vo.getLnum());
		
		return true;
	}
}
