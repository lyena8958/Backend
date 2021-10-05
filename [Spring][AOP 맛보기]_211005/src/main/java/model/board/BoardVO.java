package model.board;

import java.sql.Date;

public class BoardVO {
	// �������
	private int id;
	private String title;
	private String writer;
	private String content;
	private Date wdate; // �̶� ���¸� ���߱����ؼ� sql�� import����
	
	
	// getter, setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Date getWDate() {
		return wdate;
	}
	public void setWDate(Date wdate) {
		this.wdate = wdate;
	}
	
	// toString
	@Override
	public String toString() {
		return "BoardVO [id=" + id + ", title=" + title + ", writer=" + writer + ", content=" + content + ", date="
				+ wdate + "]";
	}
	
}
