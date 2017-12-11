package edu.spring.project.service;

import java.util.List;

import edu.spring.project.domain.BoardContents;


public interface BoardContentsService {
	// 게시글 전체 리스트 출력
	List<BoardContents> read();

	// 한 게시글 출력
	BoardContents read(int bno);

	// 게시글 작성
	int insert(BoardContents b);

	// 게시글 수정
	int update(BoardContents b);

	// 게시글 삭제
	int delete(int bno);
	
	// Top Movie 가져오기
	List<BoardContents> selectTopMovie();
		
	// Top Drama 가져오기
	List<BoardContents> selectTopDrama();
		
	// Top Animation 가져오기
	List<BoardContents> selectTopAnimation();
		
	// Top Variety 가져오기
	List<BoardContents> selectTopVariety();
}
