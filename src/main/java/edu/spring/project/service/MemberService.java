package edu.spring.project.service;

import edu.spring.project.domain.Member;

public interface MemberService {
	
	// 로그인
	Member login(String userid, String password);
	
	// 회원 가입
	int insert(Member m);
	
	// 아이디 체크
	boolean idCheck(String userid);
	
	// 회원 수정을 위한 회원 정보 출력
	Member readDetail(String userid);
	
	// 회원 정보 수정
	Member updateDetail(Member m);
	
	// 회원 탈퇴
	int memberdelete(String userid);
	
	Member findId(Member m);
}
