package day44_0827_testDB;

public class MemberVO {
	private int onum;
	private String userID;
	private String userPW;
	private String userName;
	
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
	
	public int getOnum() {
		return onum;
	}
	public void setOnum(int onum) {
		this.onum = onum;
	}
	@Override
	public String toString() {
		return "MemberVO [onum=" + onum + ", userID=" + userID + ", userPW=" + userPW + ", userName=" + userName + "]";
	}


	
	
	
}
