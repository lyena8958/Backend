package model.licenseInfo;

import java.util.List;

public interface LicenseInfoService {
	LicenseInfoVO getData(LicenseInfoVO vo);
	List<LicenseInfoVO> getList(LicenseInfoVO vo);
	boolean insertLicense(LicenseInfoVO vo);
	boolean updateLicense(LicenseInfoVO vo);
	boolean deleteLicense(LicenseInfoVO vo);
}
