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
	public List<BoardContents> read(String category) {
		return boardConDao.read(category);
	}

	@Override
	public BoardContents read(int bno) {
		return boardConDao.read(bno);
	}

	@Override
	public int insert(BoardContents b) {
		// TODO Auto-generated method stub
		return boardConDao.insert(b);
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

	@Override
	public List<BoardContents> selectTopMovie() {
		return boardConDao.readTopMovie();
	}

	@Override
	public List<BoardContents> selectTopDrama() {
		return boardConDao.readTopDrama();
	}

	@Override
	public List<BoardContents> selectTopAnimation() {
		return boardConDao.readTopAnimation();
	}

	@Override
	public List<BoardContents> selectTopVariety() {
		return boardConDao.readTopVariety();
	}

	@Override
	public int updatecount(int bno) {
		
		return boardConDao.countupdate(bno);
	}

}
