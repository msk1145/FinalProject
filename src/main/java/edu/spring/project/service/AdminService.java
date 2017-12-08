package edu.spring.project.service;

import java.util.List;

import edu.spring.project.domain.Member;

public interface AdminService {
	
	// 어드민 로그인
	Member login(String userid, String password);
	// 전체 회원 목록
	List<Member> memberList();
	// 회원 정보 검색
	Member memberDetail(String userid);
	// 회원 정보 업데이트
	int memberUpdate(Member m);
	// 회원 등급 업데이트
	int memberGradeUpdate(String userid, String grade);
}
