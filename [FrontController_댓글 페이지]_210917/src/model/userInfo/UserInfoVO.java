package model.userInfo;

import java.util.Date;

public class UserInfoVO {
	
	String userID;
	String userPW;
	String userName;
	Date datetime;
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPW() {
		return userPW;
	}
	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	@Override
	public String toString() {
		return "UserInfoVO [userID=" + userID + ", userPW=" + userPW + ", userName=" + userName + "]";
	}
	
	
}
