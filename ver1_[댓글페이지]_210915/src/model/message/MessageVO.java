package model.message;

import java.util.Date;

public class MessageVO {
	
	int mnum;
	String userID;
	String msg;
	Date datetime;
	int likeCnt;
	int replyCnt;
	
	public int getMnum() {
		return mnum;
	}
	public void setMnum(int mnum) {
		this.mnum = mnum;
	}
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public int getLikeCnt() {
		return likeCnt;
	}
	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}
	public int getReplyCnt() {
		return replyCnt;
	}
	public void setReplyCnt(int replyCnt) {
		this.replyCnt = replyCnt;
	}
	@Override
	public String toString() {
		return "MessageVO [mnum=" + mnum + ", userID=" + userID + ", msg=" + msg + ", datetime=" + datetime
				+ ", likeCnt=" + likeCnt + ", replyCnt=" + replyCnt + "]";
	}
	
	
	
}
