package model.reply;

import java.util.Date;

public class ReplyVO {
	private int rid; // PK
	private int mid; // FK
	private String id; // (내정 FK)
	private String rmsg; // 대댓글 내용
	private Date datetime; // 작성날짜
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public String getRmsg() {
		return rmsg;
	}
	public void setRmsg(String rmsg) {
		this.rmsg = rmsg;
	}
	
	@Override
	public String toString() {
		return "ReplyVO [rid=" + rid + ", mid=" + mid + ", id=" + id + ", datetime=" + datetime + ", rmsg=" + rmsg
				+ "]";
	}
	
	
	
}
