package model.post;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

//SELETE Äõ¸®¹® MappeR Class
class PostRowMapper implements RowMapper<PostVO>{

	@Override
	public PostVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		PostVO data = new PostVO();
		
		data.setPnum(rs.getInt("PNUM"));
		data.setPmem(rs.getInt("PMEM"));
		data.setWdate(rs.getString("WDATE"));
		data.setCategory(rs.getString("CATEGORY"));
		data.setContent(rs.getString("CONTENT"));
		data.setPassword(rs.getString("PASSWORD"));
		data.setResult(rs.getString("RESULT"));
		return data;
	}
	
}
@Repository
public class PostDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// Äõ¸®¹®
	private String GET_ONE = "SELECT * FROM POST WHERE PNUM=?";
	private String GET_LIST = "SELECT * FROM POST ORDER BY WDATE DESC";
	private String INSERT = "INSERT INTO POST (PNUM, PMEM, WDATE, CATEGORY, CONTENT, PASSWORD) VALUES ((SELECT NVL(MAX(PNUM),0)+1 FROM POST), ?, SYSDATE, ?, ?, ?)";
	private String UPDATE = "UPDATE POST SET PMEM=?, CATEGORY=?, CONTENT=?, PASSWORD=?, RESULT=? WHERE PNUM=?";
	private String DELETE = "DELETE FROM POST WHERE PNUM=?";
	
	//[ONE]
	public PostVO getData(PostVO vo) {
		Object[] args = {vo.getPnum()};
		return jdbcTemplate.queryForObject(GET_ONE, args, new PostRowMapper());
		
	}
	
	//[LIST]
	public List<PostVO> getList(PostVO vo) {
		//Object[] args = {};
		return jdbcTemplate.query(GET_LIST, new PostRowMapper());
		
	}
	
	//[INSERT]
	public boolean insertPost(PostVO vo) {
		Object[] args = {vo.getPmem(), vo.getCategory(), vo.getContent(), vo.getPassword()};
		jdbcTemplate.update(INSERT, args);
		
		return true;
	}
	
	//[UPDATE]
	public boolean updatePost(PostVO vo) {
		Object[] args = {vo.getPmem(), vo.getCategory(), vo.getContent(), vo.getPassword(),vo.getResult(), vo.getPnum()};
		jdbcTemplate.update(UPDATE, args);
		
		return true;
	}
	
	//[DELETE]
	public boolean deletePost(PostVO vo) {
		jdbcTemplate.update(DELETE, vo.getPnum());
		
		return true;
	}
}
