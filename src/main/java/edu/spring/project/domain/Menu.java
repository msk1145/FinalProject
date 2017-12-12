package edu.spring.project.domain;

public class Menu {
	
	private String mnum;
	private String menuname;
	private String href;
	private String hideandshow;
	
	public Menu() {}
	public Menu(String mnum, String menuname, String href, String hideandshow) {
		this.mnum = mnum;
		this.menuname = menuname;
		this.href = href;
		this.hideandshow = hideandshow;
	}
	
	public String getMnum() {
		return mnum;
	}
	public void setMnum(String mnum) {
		this.mnum = mnum;
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
	public String getHideandshow() {
		return hideandshow;
	}
	public void setHideandshow(String hideandshow) {
		this.hideandshow = hideandshow;
	}

}
