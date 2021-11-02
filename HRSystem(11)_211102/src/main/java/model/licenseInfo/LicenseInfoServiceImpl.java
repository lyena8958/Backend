package model.licenseInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("licenseInfoService")
public class LicenseInfoServiceImpl implements LicenseInfoService{

	@Autowired
	private LicenseInfoDAO dao;
	
	@Override
	public LicenseInfoVO getData(LicenseInfoVO vo) {
		return dao.getData(vo);
	}

	@Override
	public List<LicenseInfoVO> getList(LicenseInfoVO vo) {
		return dao.getList(vo);
	}

	@Override
	public boolean insertLicense(LicenseInfoVO vo) {
		return dao.insertLicense(vo);
	}

	@Override
	public boolean updateLicense(LicenseInfoVO vo) {
		return dao.updateLicense(vo);
	}

	@Override
	public boolean deleteLicense(LicenseInfoVO vo) {
		return dao.deleteLicense(vo);
	}

}
