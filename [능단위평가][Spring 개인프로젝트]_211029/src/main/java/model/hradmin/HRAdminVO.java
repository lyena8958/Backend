package model.hradmin;

public class HRAdminVO {
	
	private int hnum; // PK
	private int hmem; // FK
	private String pw;

	
	public int getHnum() {
		return hnum;
	}
	public void setHnum(int hnum) {
		this.hnum = hnum;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getHmem() {
		return hmem;
	}
	public void setHmem(int hmem) {
		this.hmem = hmem;
	}
	@Override
	public String toString() {
		return "HRAdminVO [hnum=" + hnum + ", hmem=" + hmem + ", pw=" + pw + "]";
	}
	

	
	
}
