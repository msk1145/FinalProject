package edu.spring.project.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.project.domain.ReplyContents;
import edu.spring.project.persistence.ReplyContentsDao;

@Service
public class ReplyContentsServiceImple implements ReplyContentsService {
	private static final Logger logger =
			LoggerFactory.getLogger(ReplyContentsServiceImple.class);
	
	@Autowired
	private ReplyContentsDao replyConDao;
	
	
	@Override
	public List<ReplyContents> read(int bno) {
		return replyConDao.read(bno);
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
