package model.userMsg;

import java.util.Date;

public class UserMsgVO {
	
	private String id; // PK
	private String name; // ����
	private String passwd; // ��й�ȣ
	private Date datetime; // ���Գ�¥
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	@Override
	public String toString() {
		return "UserMsgVO [id=" + id + ", name=" + name + ", passwd=" + passwd + ", datetime=" + datetime + "]";
	}
	
}
