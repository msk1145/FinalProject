package edu.spring.project.domain;

import java.util.Date;

public class BoardFree {
	/* 멤버 변수 */
	private int fbno;
	private String ftitle;
	private String fcontent;
	private String fuserid;
	private int count;
	private Date fregdate;
	
	/* 생성자 */
	public BoardFree() {}
	public BoardFree(int fbno, String ftitle, String fcontent, String fuserid, int count, Date fregdate) {
		this.fbno = fbno;
		this.ftitle = ftitle;
		this.fcontent = fcontent;
		this.fuserid = fuserid;
		this.count = count;
		this.fregdate = fregdate;
	}
	
	/* getter , setter */
	public int getFbno() {
		return fbno;
	}
	public void setFbno(int fbno) {
		this.fbno = fbno;
	}
	public String getFtitle() {
		return ftitle;
	}
	public void setFtitle(String ftitle) {
		this.ftitle = ftitle;
	}
	public String getFcontent() {
		return fcontent;
	}
	public void setFcontent(String fcontent) {
		this.fcontent = fcontent;
	}
	public String getFuserid() {
		return fuserid;
	}
	public void setFuserid(String fuserid) {
		this.fuserid = fuserid;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getFregdate() {
		return fregdate;
	}
	public void setFregdate(Date fregdate) {
		this.fregdate = fregdate;
	}
	
}
