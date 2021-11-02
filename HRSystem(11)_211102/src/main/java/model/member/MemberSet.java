package model.member;

import java.util.ArrayList;
import java.util.List;

import model.careerInfo.CareerInfoVO;
import model.licenseInfo.LicenseInfoVO;
import model.schoolInfo.SchoolInfoVO;

public class MemberSet {
	private MemberVO member;
	private List<SchoolInfoVO> school = new ArrayList<SchoolInfoVO>();
	private List<CareerInfoVO> career = new ArrayList<CareerInfoVO>();
	private List<LicenseInfoVO> license = new ArrayList<LicenseInfoVO>();
	
	public MemberVO getMember() {
		return member;
	}
	public void setMember(MemberVO member) {
		this.member = member;
	}
	public List<SchoolInfoVO> getSchool() {
		return school;
	}
	public void setSchool(List<SchoolInfoVO> school) {
		this.school = school;
	}
	public List<CareerInfoVO> getCareer() {
		return career;
	}
	public void setCareer(List<CareerInfoVO> career) {
		this.career = career;
	}
	public List<LicenseInfoVO> getLicense() {
		return license;
	}
	public void setLicense(List<LicenseInfoVO> license) {
		this.license = license;
	}
	
	
	
}
