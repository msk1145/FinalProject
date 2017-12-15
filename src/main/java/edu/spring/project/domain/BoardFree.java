package edu.spring.project.domain;

import java.util.Date;

public class BoardFree {
	/* 멤버 변수 */
	private int fbno;
	private String ftitle;
	private String fcontent;
	private String fuserid;
	private int fcount;
	private Date fregdate;
	private String fimagepath;
	
	/* 생성자 */
	public BoardFree() {}
	public BoardFree(int fbno, String ftitle, String fcontent, String fuserid, int fcount, Date fregdate, String fimagepath) {
		this.fbno = fbno;
		this.ftitle = ftitle;
		this.fcontent = fcontent;
		this.fuserid = fuserid;
		this.fcount = fcount;
		this.fregdate = fregdate;
		this.fimagepath = fimagepath;
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
	
	public int getFcount() {
		return fcount;
	}
	public void setFcount(int fcount) {
		this.fcount = fcount;
	}
	public Date getFregdate() {
		return fregdate;
	}
	public void setFregdate(Date fregdate) {
		this.fregdate = fregdate;
	}
	public String getFimagepath() {
		return fimagepath;
	}
	public void setFimagepath(String fimagepath) {
		this.fimagepath = fimagepath;
	}
	
	
	
}
