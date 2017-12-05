package edu.spring.project.persistence;

import java.util.Map;

import edu.spring.project.domain.Member;

public interface MemberDao {
	
	// 로그인
	Member login (Map<String,String> map);
	
	// 회원 가입
	int insert(Member m);
	
	// id 체크
	Member idCheck(String userid);
}
