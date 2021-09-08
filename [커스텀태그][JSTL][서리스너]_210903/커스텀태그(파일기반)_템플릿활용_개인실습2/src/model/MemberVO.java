package model;

public class MemberVO {
	private int onum;
	private String userID;
	private String userPW;
	public int getOnum() {
		return onum;
	}
	public void setOnum(int onum) {
		this.onum = onum;
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
	@Override
	public String toString() {
		return "MemberVO [onum=" + onum + ", userID=" + userID + ", userPW=" + userPW + "]";
	}

	
}
