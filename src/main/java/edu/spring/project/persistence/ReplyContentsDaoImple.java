package edu.spring.project.persistence;

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
	
	
	@Override
	public List<ReplyContents> read(int bno) {
		return session.selectList(NAMESPACE + ".selectReplyConBybno", bno);
	}
	
	@Override
	public List<ReplyContents> readReReplies(int rrno) {
		
		return session.selectList(NAMESPACE + ".selectReReplyConByRrno", rrno);
	}

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

	@Override
	public int update(ReplyContents r) {
		return session.update(NAMESPACE + ".updateReplyCon", r);
	}

	@Override
	public int delete(int rno) {
		return session.delete(NAMESPACE + ".deleteReplyCon", rno);
	}

	

}
