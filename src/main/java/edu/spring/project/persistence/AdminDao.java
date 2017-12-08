package edu.spring.project.persistence;

import java.util.Map;

import edu.spring.project.domain.Member;

public interface AdminDao {
	
	// 어드민 로그인
	Member login(Map<String, String> map);
}
