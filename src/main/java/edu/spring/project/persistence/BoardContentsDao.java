package edu.spring.project.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.spring.project.domain.BoardContents;

@Repository
public interface BoardContentsDao {
	
	// 게시글 전체 리스트 출력
	List<BoardContents> read();
	
	// 한 게시글 출력
	List<BoardContents> read(int bno);
	
	// 게시글 작성
	int insert(BoardContents b);
	
	// 게시글 수정
	int update(BoardContents b);
	
	// 게시글 삭제
	int delete(int bno);
	
}
