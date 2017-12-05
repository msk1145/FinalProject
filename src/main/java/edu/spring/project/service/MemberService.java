package edu.spring.project.service;

import edu.spring.project.domain.Member;

public interface MemberService {
	
	// 로그인
	Member login(String userid, String password);
	
	// 회원 가입
	int insert(Member m);
	
	// 아이디 체크
	boolean idCheck(String userid);
	
	
}
