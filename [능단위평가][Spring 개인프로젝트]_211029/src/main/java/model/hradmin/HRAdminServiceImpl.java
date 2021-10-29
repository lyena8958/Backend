package model.hradmin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("hrAdminService")
public class HRAdminServiceImpl implements HRAdminService{

	@Autowired
	private HRAdminDAO dao;
	
	@Override
	public HRAdminVO getData(HRAdminVO vo) {
		return dao.getData(vo);
	}

	@Override
	public List<HRAdminVO> getList(HRAdminVO vo) {
		return dao.getList(vo);
	}

	@Override
	public boolean insertHRAdmin(HRAdminVO vo) {
		return dao.insertHRAdmin(vo);
	}

	@Override
	public boolean updateHRAdmin(HRAdminVO vo) {
		return dao.updateHRAdmin(vo);
	}

	@Override
	public boolean deleteHRAdmin(HRAdminVO vo) {
		return dao.deleteHRAdmin(vo);
	}
	
}
