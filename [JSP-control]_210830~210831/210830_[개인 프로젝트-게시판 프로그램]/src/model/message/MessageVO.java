package model.message;

import java.sql.Date;

public class MessageVO {
	int mnum;
	String writer;
	String title;
	String content;
	Date wdate; // String 해도 무관
	// import시 util.Date, sql.Date가 있는데,
	// 프레임워크 사용시를 대비하여 sql.Date로 쓰는 것이 좋다.
	
	public int getMnum() {
		return mnum;
	}
	public void setMnum(int mnum) {
		this.mnum = mnum;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
		return "MessageVO [mnum=" + mnum + ", writer=" + writer + ", title=" + title + ", content=" + content
				+ ", wdate=" + wdate + "]";
	}
	
	
	
}
