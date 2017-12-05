package edu.spring.project.domain;

import java.util.Date;

public class ReplyContents {
	/* 멤버 변수 */
	private int rno;
	private int bno;
	private String content;
	private Date regdate;
	private String userid;
	private int rrno;
	
	/* 생성자 */
	public ReplyContents() {}
	public ReplyContents(int rno, int bno, String content, Date regdate, String userid, int rrno) {
		this.rno = rno;
		this.bno = bno;
		this.content = content;
		this.regdate = regdate;
		this.userid = userid;
		this.rrno = rrno;
	}
	
	/* getter , setter */
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
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
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getRrno() {
		return rrno;
	}
	public void setRrno(int rrno) {
		this.rrno = rrno;
	}
	
}
