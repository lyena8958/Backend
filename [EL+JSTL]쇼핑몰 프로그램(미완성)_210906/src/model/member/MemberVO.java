package model.member;

public class MemberVO {
	
	private int mnum;
	private String userID;
	private String userPW;
	private String userName;
	
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
	
	
	@Override
	public String toString() {
		return "MemberVO [mnum=" + mnum + ", userID=" + userID + ", userPW=" + userPW + ", userName=" + userName + "]";
	}
	
}
