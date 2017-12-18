package edu.spring.project.persistence;

import java.util.List;

import edu.spring.project.domain.BoardContents;
import edu.spring.project.domain.BoardFree;
import edu.spring.project.pageutil.PaginationCriteria;

	
public interface BoardContentsDao {
	// 게시글 페이징
	List<BoardContents> readPaging(String category, PaginationCriteria c);
	
	// 전체 게시글 갯수
	int totalCount(String category);
	
	// 검색된 리스트 페이징
	List<BoardContents> readSearchedPaging(String category, PaginationCriteria c,
				String keyword, int searchType);

	// 검색된 게시글 갯수
	int searchedTotalCount(String category, String keyword, int searchType);
	
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
	
	// Top Movie 가져오기
	List<BoardContents> readTopMovie();
	
	// Top Drama 가져오기
	List<BoardContents> readTopDrama();
	
	// Top Animation 가져오기
	List<BoardContents> readTopAnimation();
	
	// Top Variety 가져오기
	List<BoardContents> readTopVariety();
	
	// TOP Freeboard 가져오기
	List<BoardFree> readTopFree();
	// 조회수 업데이트
	int countupdate(int bno);
}
