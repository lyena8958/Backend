package test;

public class CafeBean {
	private int cnt;
	private	String type;
	private int result;
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public void totalAccount() {
		if(cnt < 1) {
			this.result = 0;
		}
		else {
			if(this.type.equals("아메리카노")) {
				result = 2000*cnt;
			}
			else if(this.type.equals("카페라떼")) {
				result = 2500*cnt;
			}
		}
		
		
	}
	
}
