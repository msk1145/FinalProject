package edu.spring.project.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.project.domain.BoardContents;

@Repository
public class BoardContentsDaoImple implements BoardContentsDao {
	private static final Logger logger =
			LoggerFactory.getLogger(BoardContentsDaoImple.class);
	private static final String NAMESPACE = 
			"edu.spring.project.mappers.BoardMapper";
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<BoardContents> read(String category) {
		return session.selectList(NAMESPACE+".selectBoard", category);
	}

	@Override
	public BoardContents read(int bno) {
		return session.selectOne(NAMESPACE + ".selectBybno", bno);
	}

	@Override
	public int insert(BoardContents b) {
		// TODO Auto-generated method stub
		return session.insert(NAMESPACE+".insertContents", b);
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
	public List<BoardContents> readTopMovie() {
		return session.selectList(NAMESPACE + ".selectTopMovie");
	}

	@Override
	public List<BoardContents> readTopDrama() {
		return session.selectList(NAMESPACE + ".selectTopDrama");
	}

	@Override
	public List<BoardContents> readTopAnimation() {
		return session.selectList(NAMESPACE +".selectTopAnimation");
	}

	@Override
	public List<BoardContents> readTopVariety() {
		return session.selectList(NAMESPACE + ".selectTopVariety");
	}

	@Override
	public int countupdate(int bno) {
		return session.update(NAMESPACE+".updateCount", bno);
		
	}

}
