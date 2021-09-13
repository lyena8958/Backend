package model.message;

import java.util.Date;

public class MessageVO {
	private int mid; // PK
	private String id; // (내정 FK)
	private String msg; // 댓글내용
	private int favcount; // 좋아요수
	private int replycount; // 조회수
	private Date datetime; // 작성날짜
	
	
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
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getFavcount() {
		return favcount;
	}
	public void setFavcount(int favcount) {
		this.favcount = favcount;
	}
	public int getReplycount() {
		return replycount;
	}
	public void setReplycount(int replycount) {
		this.replycount = replycount;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	@Override
	public String toString() {
		return "MessageVO [mid=" + mid + ", id=" + id + ", msg=" + msg + ", favcount=" + favcount + ", replycount="
				+ replycount + ", datetime=" + datetime + "]";
	}
	
	
	
}
