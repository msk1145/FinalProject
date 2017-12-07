package edu.spring.project.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.project.domain.BoardFree;

@Repository
public class BoardFreeDaoImple implements BoardFreeDao {
	private static final Logger logger =
			LoggerFactory.getLogger(BoardFreeDaoImple.class);
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<BoardFree> read() {
		return null;
	}

	@Override
	public List<BoardFree> read(int bno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(BoardFree b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BoardFree b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int fbno) {
		// TODO Auto-generated method stub
		return 0;
	}

}
