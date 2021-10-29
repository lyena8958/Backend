package model.hradmin;

import java.util.List;

public interface HRAdminService {
	HRAdminVO getData(HRAdminVO vo);
	List<HRAdminVO> getList(HRAdminVO vo);
	boolean insertHRAdmin(HRAdminVO vo);
	boolean updateHRAdmin(HRAdminVO vo);
	boolean deleteHRAdmin(HRAdminVO vo);
}
