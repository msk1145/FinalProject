package edu.spring.project.persistence;

import java.util.List;
import java.util.Map;

import edu.spring.project.domain.BoardContents;
import edu.spring.project.domain.BoardFree;
import edu.spring.project.domain.Member;
import edu.spring.project.domain.Menu;
import edu.spring.project.pageutil.PaginationCriteria;

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
	// 회원 삭제
	int memberDelete(String userid);
	// 메뉴 select
	List<Menu> menuselect();
	// 메뉴 detail select
	Menu detailmenu(String mnum);
	// 메뉴 update
	int menuUpdate(Menu menu);
	// 메뉴 insert
	int menuInsert(Menu menu);

	// 게시글 삭제를 위한 select
	List<BoardContents> selectBoard(PaginationCriteria c);
	
	// 게시글 수정,삭제를 위한 category 별 출력
	List<Object> selectByConCategory(Map<String, Object> map);
	
	// 게시글 수정,삭제를 위한 BoardFree 출력	
	List<Object> BoardFreeSelectAll(PaginationCriteria c);
	
	// 게시글 수정, 삭제를 위한 특정 boardContents 출력
	Object boardConDetail(int bno);
	
	// 게시글 수정, 삭제를 위한 특정 boardFreetents 출력
	Object boardFreeDetail(int fbno);

	// Con 게시글 삭제
	int boardConDelete(int bno);
	
	// Free 게시글 삭제 
	int boardFreeDelete(int fbno);
		
	// Con 게시글 수정
	int boardConUpdate(BoardContents b); 
	
	// Free 게시글 수정
	int boardFreeUpdate(BoardFree b);
	
	// 페이징 처리를 위한 전체 게시물의 갯수 조회
	int getTotalCount();
	
	// 자유게시판 게시글 개수
	int getFreeTotalCount();
	
	// 컨텐츠별 게시글 개수
	int getConTotalCount(String category);
	
	
	
	
}
