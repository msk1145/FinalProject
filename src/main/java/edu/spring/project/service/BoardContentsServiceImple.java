package edu.spring.project.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.project.domain.BoardContents;
import edu.spring.project.persistence.BoardContentsDao;

@Service
public class BoardContentsServiceImple implements BoardContentsService {
	private static final Logger logger =
			LoggerFactory.getLogger(BoardContentsServiceImple.class);
	
	@Autowired
	private BoardContentsDao boardConDao;
	
	@Override
	public List<BoardContents> read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardContents read(int bno) {
		return boardConDao.read(bno);
	}

	@Override
	public int insert(BoardContents b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BoardContents b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int bno) {
		// TODO Auto-generated method stub
		return 0;
	}

}