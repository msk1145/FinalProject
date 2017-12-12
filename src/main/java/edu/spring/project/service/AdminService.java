package edu.spring.project.service;

import java.util.List;

import edu.spring.project.domain.Member;
import edu.spring.project.domain.Menu;

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
	// 회원 삭제
	int memberDelete(String userid);
	
	// 메뉴 select
	List<Menu> selectMenu();
	// 메뉴 detail select
	Menu detailMenu(String mnum);
	// 메뉴 update
	int updateMenu(Menu menu);
	// 메뉴 insert
	int insertMenu(Menu menu);
}
