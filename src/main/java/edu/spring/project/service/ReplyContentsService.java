package edu.spring.project.service;

import java.util.List;
import java.util.Map;

import edu.spring.project.domain.ReplyContents;

public interface ReplyContentsService {

	// 한 게시물에 전체 댓글
	List<ReplyContents> read(int bno);

	// 댓글의 댓글
	List<ReplyContents> readReReplies(int rrno);
	
	// 한 게시물의 전체 댓글 갯수(대댓글 포함)
	int totalCountBybno(int bno);
	
	// 댓글 입력
	int insert(ReplyContents r);

	// 댓글 수정
	int update(ReplyContents r);

	// 댓글 삭제
	int delete(int rno, int rrno);
}
