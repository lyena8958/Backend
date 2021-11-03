package com.lee.app.board;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Entity implementation class for Entity: Board
 *
 */

// 테이블맵핑을 위한 어노테이션 설정
@Entity
@Table(name="BOARD")
public class Board{ //  implements Serializable 제거
	
	// VO의 멤버변수를 가져오자 (DB의 칼럼)
	
	@Id // 아이디 
	@GeneratedValue // 값을 구분
	private int id; // 식별자 필드 == PK // VO의 멤버변수를 가져오자 (DB의 칼럼)
	private String title;
	private String writer;
	private String content;
	@Temporal(TemporalType.DATE)
	private Date wdate;
	@Transient
	private String condition;
	@Transient
	private String keyword;
	
	//private String fupath;
	
	
	private static final long serialVersionUID = 1L;

	public Board() {
		super();
	}

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

	public Date getWdate() {
		return wdate;
	}

	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Board [id=" + id + ", title=" + title + ", writer=" + writer + ", content=" + content + ", wdate="
				+ wdate + ", condition=" + condition + ", keyword=" + keyword + "]";
	}
	
   
}
