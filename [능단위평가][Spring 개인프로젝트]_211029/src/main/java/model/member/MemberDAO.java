package model.member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


//SELETE Äõ¸®¹® MappeR Class
class MemberRowMapper implements RowMapper<MemberVO>{

	@Override
	public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberVO data = new MemberVO();
		
		data.setMnum(rs.getInt("MNUM"));
		data.setmName(rs.getString("MNAME"));
		data.setPath(rs.getString("PATH"));
		data.setStartDate(rs.getDate("STARTDATE"));
		data.setEndDate(rs.getDate("ENDDATE"));
		data.setBirthDate(rs.getDate("BIRTHDATE"));
		data.setTeamName(rs.getString("TEAMNAME"));
		data.setDuty(rs.getString("DUTY"));
		data.setPosition(rs.getString("POSITION"));
		data.setMrank(rs.getInt("MRANK"));
				
		
		return data;
	}
	
}
@Repository
public class MemberDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// Äõ¸®¹®
	private String GET_ONE = "SELECT * FROM MEMBER WHERE MNUM=?";
	private String GET_LIST = "SELECT * FROM MEMBER";
	private String INSERT = "INSERT INTO MEMBER (MNUM, MNAME, PATH, STARTDATE, ENDDATE, BIRTHDATE, TEAMNAME, DUTY, POSITION, MRANK) VALUES ((SELECT NVL(MAX(MNUM),0)+1 FROM MEMBER), ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private String UPDATE = "UPDATE MEMBER SET MNAME=?, PATH=?, STARTDATE=?, ENDDATE=?, BIRTHDATE=?, TEAMNAME=?, DUTY=?, POSITION=?, MRANK=? WHERE MNUM=?";
	private String DELETE = "DELETE FROM MEMBER WHERE MNUM=?";
	
	//[SetList]
// ¡ÚÆ®·£Àè¼Ç ±¸Çö ÇÊ¿ä..!
	public MemberSet getSetList(MemberVO vo) {
		// setVO (member + license + career + school)
		MemberSet result = new MemberSet();
		
		Object[] args = {vo.getMnum()};
		//return jdbcTemplate.queryForObject(GET_ONE, args, new MemberRowMapper());
		return result;
	}
	
	//[ONE]
	public MemberVO getData(MemberVO vo) {
		Object[] args = {vo.getMnum()};
		return jdbcTemplate.queryForObject(GET_ONE, args, new MemberRowMapper());
		
	}
	
	//[LIST]
	public List<MemberVO> getList(MemberVO vo) {
		//Object[] args = {};
		return jdbcTemplate.query(GET_LIST, new MemberRowMapper());
		
	}
	
	//[INSERT]
	public boolean insertMember(MemberVO vo) {
		Object[] args = {vo.getmName(), vo.getPath(), vo.getStartDate(), vo.getEndDate(), vo.getBirthDate(), vo.getTeamName(), vo.getDuty(), vo.getPosition(), vo.getMrank()};
		jdbcTemplate.update(INSERT, args);
		
		return true;
	}
	
	//[UPDATE]
	public boolean updateMember(MemberVO vo) {
		Object[] args = {vo.getmName(), vo.getPath(), vo.getStartDate(), vo.getBirthDate(), vo.getTeamName(), vo.getDuty(), vo.getPosition(), vo.getMrank()};
		jdbcTemplate.update(UPDATE, args);
		
		return true;
	}
	
	//[DELETE]
	public boolean deleteMember(MemberVO vo) {
		jdbcTemplate.update(DELETE, vo.getMnum());
		
		return true;
	}
}
