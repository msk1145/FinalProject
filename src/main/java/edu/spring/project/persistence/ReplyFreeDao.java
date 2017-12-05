package edu.spring.project.persistence;

import java.util.List;

import edu.spring.project.domain.ReplyFree;

public interface ReplyFreeDao {

	// 한 게시물에 전체 댓글
	List<ReplyFree> read(int fbno);

	// 댓글 입력
	int insert(ReplyFree r);

	// 댓글 수정
	int update(ReplyFree r);

	// 댓글 삭제
	int delete(int frno);
}
