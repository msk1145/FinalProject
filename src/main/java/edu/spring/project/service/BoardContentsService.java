package edu.spring.project.service;

import java.util.List;
import java.util.Map;

import edu.spring.project.domain.BoardContents;
import edu.spring.project.domain.BoardContentsVO;


public interface BoardContentsService {
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
	
	
	// 조회수 올리기
	int updatecount(int bno);

	List<List<BoardContentsVO>> selectmenu();
}
