package edu.spring.project.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.project.domain.ReplyContents;

@Repository
public class ReplyContentsDaoImple implements ReplyContentsDao {
	private static final Logger logger =
			LoggerFactory.getLogger(BoardContentsDaoImple.class);
	private static final String NAMESPACE = 
			"edu.spring.project.mappers.ReplyMapper";
	@Autowired
	private SqlSession session;
	
	
	// 댓글목록 
	@Override
	public List<ReplyContents> read(int bno) {
		return session.selectList(NAMESPACE + ".selectReplyConBybno", bno);
	}
	
	// 대댓글 목록
	@Override
	public List<ReplyContents> readReReplies(int rrno) {
		
		return session.selectList(NAMESPACE + ".selectReReplyConByRrno", rrno);
	}
	
	// 댓글 갯수
	@Override
	public int totalCountBybno(int bno) {
		
		return session.selectOne(NAMESPACE + ".selectReplyCountBybno", bno);
	}

	
	// 댓글 추가
	@Override
	public int insert(ReplyContents r) {
		int result = 0;
		if (r.getRrno() == 0) {
			logger.info("rno == 0");
			result = session.insert(NAMESPACE + ".insertReplyCon", r); 
		} else {
			logger.info("rno != 0");
			result = session.insert(NAMESPACE + ".insertRReplyCon", r);
		}
		return result;
	}

	// 댓글 수정
	@Override
	public int update(ReplyContents r) {
		return session.update(NAMESPACE + ".updateReplyCon", r);
	}

	// 댓글 삭제
	@Override
	public int delete(int rno, int rrno) {
		Map<String, Integer> args = new HashMap<>();
		args.put("rno", rno);
		args.put("rrno", rrno);
		return session.delete(NAMESPACE + ".deleteReplyCon", args);
	}

	
	

}
