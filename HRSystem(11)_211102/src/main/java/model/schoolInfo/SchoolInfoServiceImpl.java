package model.schoolInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("schoolInfoService")
public class SchoolInfoServiceImpl implements SchoolInfoService{

	@Autowired
	private SchoolInfoDAO dao;
	
	@Override
	public SchoolInfoVO getData(SchoolInfoVO vo) {
		return dao.getData(vo);
	}

	@Override
	public List<SchoolInfoVO> getList(SchoolInfoVO vo) {
		return dao.getList(vo);
	}

	@Override
	public boolean insertSchool(SchoolInfoVO vo) {
		return dao.insertSchool(vo);
	}

	@Override
	public boolean updateSchool(SchoolInfoVO vo) {
		return dao.updateSchool(vo);
	}

	@Override
	public boolean deleteSchool(SchoolInfoVO vo) {
		return dao.deleteSchool(vo);
	}
	
	
}
