package model.licenseInfo;

import java.sql.Date;

public class LicenseInfoVO {
	 
	private int lnum; // PK
	private Date getDate; // �����
	private Date expireDate; // ������
	private String lname; // �ڰ�����
	private String grade; // ���
	private int lmem; // FK
	
	public int getLnum() {
		return lnum;
	}
	public void setLnum(int lnum) {
		this.lnum = lnum;
	}
	public Date getGetDate() {
		return getDate;
	}
	public void setGetDate(Date getDate) {
		this.getDate = getDate;
	}
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}	
	public int getLmem() {
		return lmem;
	}
	public void setLmem(int lmem) {
		this.lmem = lmem;
	}
	@Override
	public String toString() {
		return "LicenseInfoInfoVO [lnum=" + lnum + ", getDate=" + getDate + ", expireDate=" + expireDate + ", lname="
				+ lname + ", grade=" + grade + ", lmem=" + lmem + "]";
	}
	
	
	
}
