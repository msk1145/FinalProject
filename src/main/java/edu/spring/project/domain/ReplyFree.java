package edu.spring.project.domain;

import java.util.Date;

public class ReplyFree {
	/* 멤버 변수 */
	private int frno;
	private int fbno;
	private String fcontent;
	private Date fregdate;
	private String userid;
	private int frrno;
	
	/* 생성자 */
	public ReplyFree() {}
	public ReplyFree(int frno, int fbno, String fcontent, Date fregdate, String userid, int frrno) {
		this.frno = frno;
		this.fbno = fbno;
		this.fcontent = fcontent;
		this.fregdate = fregdate;
		this.userid = userid;
		this.frrno = frrno;
	}
	
	/* getter , setter */
	public int getFrno() {
		return frno;
	}
	public void setFrno(int frno) {
		this.frno = frno;
	}
	public int getFbno() {
		return fbno;
	}
	public void setFbno(int fbno) {
		this.fbno = fbno;
	}
	public String getFcontent() {
		return fcontent;
	}
	public void setFcontent(String fcontent) {
		this.fcontent = fcontent;
	}
	public Date getFregdate() {
		return fregdate;
	}
	public void setFregdate(Date fregdate) {
		this.fregdate = fregdate;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getFrrno() {
		return frrno;
	}
	public void setFrrno(int frrno) {
		this.frrno = frrno;
	}
	
}
