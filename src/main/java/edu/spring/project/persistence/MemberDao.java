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
	
	// 회원 수정을 위한 회원 정보 출력
	Member readDetail(String userid);
	
	// 회원 정보 수정
	int updateDetail(Member m);
	
	// 회원 탈퇴
	int memberdelete(String userid);
	
	// id 찾기(별명, 이메일)
	Member findId(Member m);
	
}
