package edu.spring.project.domain;

public class Member {
	
	/* 멤버 변수 */
	private String userid;
	private String password;
	private String email;
	private String nickname;
	private String grade;
	
	/* 생성자 */
	public Member(){}
	public Member(String userid, String password, String email, String nickname, String grade) {
		this.userid = userid;
		this.password = password;
		this.email = email;
		this.nickname = nickname;
		this.grade = grade;
	}
	
	/* getter , setter */
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
	
	
	
}
