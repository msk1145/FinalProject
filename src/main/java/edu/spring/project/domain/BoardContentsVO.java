package edu.spring.project.domain;

public class BoardContentsVO {
	private int bno;
	private String title;
	private int count;
	private String menuname;
	private String href;
	
	public BoardContentsVO() {}
	public BoardContentsVO(int bno, String title, int count, String menuname, String href) {
		this.bno = bno;
		this.title = title;
		this.count = count;
		this.menuname = menuname;
		this.href = href;
	}
	
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	
	
	
	
}
