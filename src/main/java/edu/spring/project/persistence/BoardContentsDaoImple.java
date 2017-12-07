package edu.spring.project.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.spring.project.domain.BoardContents;

@Repository
public class BoardContentsDaoImple implements BoardContentsDao {

	@Override
	public List<BoardContents> read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardContents> read(int bno) {
		// TODO Auto-generated method stub
		return null;
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
