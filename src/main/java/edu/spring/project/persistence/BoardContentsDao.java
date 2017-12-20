package edu.spring.project.persistence;

import java.util.List;
import java.util.Map;

import edu.spring.project.domain.BoardContents;
import edu.spring.project.domain.BoardContentsVO;
import edu.spring.project.domain.Menu;

	
public interface BoardContentsDao {
	
	// 게시글 전체 리스트 출력
	List<BoardContents> read(String category);
	
	// 한 게시글 출력
	BoardContents read(int bno);
	
	// 게시글 작성
	int insert(BoardContents b);
	
	// 게시글 수정
	int update(BoardContents b);
	
	// 게시글 삭제
	int delete(int bno);
	
	// 조회수 업데이트
	int countupdate(int bno);

	// 메뉴 카테고리와 행 갯수 조회
	List<Menu> selectMenu();
	
	// 메인 메뉴 탑 5개 리스트 조회
	List<BoardContentsVO> selectbyCategoryBoard(String href);
}
