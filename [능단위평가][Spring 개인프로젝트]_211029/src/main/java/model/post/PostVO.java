package model.post;

public class PostVO {
	private int pnum; // PK
	private int pmem; // ����FK
	private String category;
	private String content;
	private String password;
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public int getPmem() {
		return pmem;
	}
	public void setPmem(int pmem) {
		this.pmem = pmem;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "PostVO [pnum=" + pnum + ", pmem=" + pmem + ", category=" + category + ", content=" + content
				+ ", password=" + password + "]";
	}
	
	
}
