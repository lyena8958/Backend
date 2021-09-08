package model.review;

import java.sql.Date;

public class ReviewVO {	
	
	private int onum;
	private int rnum;
	private String writer;
	private	String title;
	private String content;
	Date wdate;
	
	public int getOnum() {
		return onum;
	}
	public void setOnum(int onum) {
		this.onum = onum;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
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
		return "ReviewVO [onum=" + onum + ", writer=" + writer + ", title=" + title + ", content=" + content + "]";
	}
	
	
	
}
