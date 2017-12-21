package edu.spring.project.service;

import java.util.List;

import edu.spring.project.domain.BoardContents;
import edu.spring.project.domain.BoardFree;
import edu.spring.project.domain.Member;
import edu.spring.project.domain.Menu;
import edu.spring.project.pageutil.PaginationCriteria;

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

	// 게시물 삭제,수정를 위한 게시물 select
	List<BoardContents> selectBoard(PaginationCriteria c);

	// 게시글 삭제,수정를 위한 category 별 출력
	List<Object> selectByConCategory(String category, PaginationCriteria c);

	// 게시글 수정, 삭제를 위한 특정 boardContents, boardContents 출력
	Object boardDetail(int bno, String category);

	// 게시글 삭제,
	int boardConDelete(int bno);

	// Free 게시글 삭제
	int boardFreeDelete(int fbno);

	// 페이징 처리를 위한 전체 게시물 조회
	int getTotalCount();

	// 자유게시판 게시글 개수
	int getFreeTotalCount();

	// 컨텐츠별 게시글 개수
	int getConTotalCount(String category);

	// Con 게시글 수정
	int boardConUpdate(BoardContents b);

	// Free 게시글 수정
	int boardFreeUpdate(BoardFree b);

}
