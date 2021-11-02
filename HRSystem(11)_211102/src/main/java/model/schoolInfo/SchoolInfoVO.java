package model.schoolInfo;

import java.sql.Date;

public class SchoolInfoVO {
	
	private int snum; // PK
	private Date startDate; // ������
	private Date endDate; // ������ 
	private String stype; // �з�
	private String sname; // �б���
	private String field; // �����迭
	private String major; // ������
	private String finish; // �����з¿��� (Y, N)
	private int smem; // FK
	
	public int getSnum() {
		return snum;
	}
	public void setSnum(int snum) {
		this.snum = snum;
	}
	public String getStype() {
		return stype;
	}
	public void setStype(String stype) {
		this.stype = stype;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getFinish() {
		return finish;
	}
	public void setFinish(String finish) {
		this.finish = finish;
	}
	public int getSmem() {
		return smem;
	}
	public void setSmem(int smem) {
		this.smem = smem;
	}
	
	@Override
	public String toString() {
		return "SchoolInfoVO [snum=" + snum + ", stype=" + stype + ", sname=" + sname + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", field=" + field + ", major=" + major + ", finish=" + finish + ", smem="
				+ smem + "]";
	}
	
}
