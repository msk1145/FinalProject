package edu.spring.project.domain;

import java.util.Date;

public class BoardContents {
	
	/* 멤버 변수 */
	private int bno;
	private String title;
	private String content;
	private Date regdate;
	private int count;
	private String category;
	
	/* 생성자 */
	public BoardContents(){}
	public BoardContents(int bno, String title, String content, Date regdate, int count, String category) {
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.count = count;
		this.category = category;
	}
	
	/* getter , setter */
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
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
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
	
}
