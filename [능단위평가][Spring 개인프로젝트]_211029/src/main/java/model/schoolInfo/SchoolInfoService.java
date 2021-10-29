package model.schoolInfo;

import java.util.List;

public interface SchoolInfoService {

	SchoolInfoVO getData(SchoolInfoVO vo);
	List<SchoolInfoVO> getList(SchoolInfoVO vo);
	boolean insertSchool(SchoolInfoVO vo);
	boolean updateSchool(SchoolInfoVO vo);
	boolean deleteSchool(SchoolInfoVO vo);
}
