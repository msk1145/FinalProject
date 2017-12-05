package edu.spring.project.persistence;

import java.util.List;

import edu.spring.project.domain.BoardFree;


public interface BoardFreeDao {

	// 게시글 전체 리스트 출력
	List<BoardFree> read();
	
	// 한 게시글 출력
	List<BoardFree> read(int bno);
	
	// 게시글 작성
	int insert(BoardFree b);

	// 게시글 수정
	int update(BoardFree b);

	// 게시글 삭제
	int delete(int fbno);
}
