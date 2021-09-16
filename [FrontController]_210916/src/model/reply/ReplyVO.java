package model.reply;

import java.util.Date;

public class ReplyVO {
	
	int rnum;
	int mnum;
	String userID;
	String rmsg;
	Date datetime;
	
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
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
	public String getRmsg() {
		return rmsg;
	}
	public void setRmsg(String rmsg) {
		this.rmsg = rmsg;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	@Override
	public String toString() {
		return "ReplyVO [rnum=" + rnum + ", mnum=" + mnum + ", userID=" + userID + ", rmsg=" + rmsg + ", datetime="
				+ datetime + "]";
	}
	

	
}
