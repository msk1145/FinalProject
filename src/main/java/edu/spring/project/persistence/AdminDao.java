package edu.spring.project.persistence;

import java.util.List;
import java.util.Map;

import edu.spring.project.domain.Member;

public interface AdminDao {
	
	// 어드민 로그인
	Member login(Map<String, String> map);
	// 전체 회원 목록
	List<Member> memberList();
	// 회원 정보 검색
	Member memberDetail(String userid);
	// 회원 정보 수정
	int memberUpdate(Member m);
	// 회원 등급 수정
	int memberGradeUpdate(String userid, String grade);
}
