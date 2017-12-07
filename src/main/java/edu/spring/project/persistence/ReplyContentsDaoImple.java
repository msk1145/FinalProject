package edu.spring.project.persistence;

import java.util.List;

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
	public int insert(ReplyContents r) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ReplyContents r) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int rno) {
		// TODO Auto-generated method stub
		return 0;
	}

}
