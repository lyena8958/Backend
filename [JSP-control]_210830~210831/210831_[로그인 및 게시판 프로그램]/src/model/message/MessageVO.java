package model.message;

import java.sql.Date;

public class MessageVO {
	private int mid;
	private String title;
	private String writer;
	private String content;
	private Date wdate;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	@Override
	public String toString() {
		return "MessageVO [mid=" + mid + ", title=" + title + ", writer=" + writer + ", content=" + content + ", wdate="
				+ wdate + "]";
	}
	
}
