package edu.spring.project.service;

import edu.spring.project.domain.Member;

public interface AdminService {
	
	// 어드민 로그인
	Member login(String userid, String password);
}
