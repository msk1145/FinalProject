package edu.spring.project.service;

import java.util.List;

import edu.spring.project.domain.Member;

public interface AdminService {
	
	// 어드민 로그인
	Member login(String userid, String password);
	// 전체 회원 목록
	List<Member> memberList(); 
}
