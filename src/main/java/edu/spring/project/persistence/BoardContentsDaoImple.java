package edu.spring.project.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.project.domain.BoardContents;

import edu.spring.project.domain.BoardContentsVO;
import edu.spring.project.domain.Menu;

import edu.spring.project.pageutil.PaginationCriteria;


@Repository
public class BoardContentsDaoImple implements BoardContentsDao {
	private static final Logger logger =
			LoggerFactory.getLogger(BoardContentsDaoImple.class);
	private static final String NAMESPACE = 
			"edu.spring.project.mappers.BoardMapper";
	
	@Autowired
	private SqlSession session;
	

	@Override
	public List<BoardContents> readSearchedPaging(String category, PaginationCriteria c, String keyword,
			int searchType) {
		Map<String, Object> args = new HashMap<>();
		args.put("category", category);
		args.put("searchType", searchType);
		args.put("keyword", "%" + keyword + "%");
		args.put("start", c.getStart());
		args.put("end", c.getEnd());
		return session.selectList(NAMESPACE +".selectSearchedBoardConPerPage", args);
	}


	@Override
	public int searchedTotalCount(String category, String keyword, int searchType) {
		Map<String, Object> args = new HashMap<>();
		args.put("category", category);
		args.put("keyword", keyword);
		args.put("searchType", searchType);
		return session.selectOne(NAMESPACE + ".searchedTotalCount", args);
	}

	
	@Override
	public List<BoardContents> readPaging(String category, PaginationCriteria c) {
		Map<String, Object> args = new HashMap<>();
		args.put("category", category);
		args.put("start", c.getStart());
		args.put("end", c.getEnd());
		return session.selectList(NAMESPACE + ".selectBoardConPerPage", args);
	}
	
	@Override
	public int totalCount(String category) {
		
		return session.selectOne(NAMESPACE + ".totalCount", category);
	}

	
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
	public int countupdate(int bno) {
		return session.update(NAMESPACE+".updateCount", bno);
		
	}

	@Override
	public List<Menu> selectMenu() {
		return session.selectList(NAMESPACE +".selectMenu");
	}


	@Override
	public List<BoardContentsVO> selectbyCategoryBoard(String href) {
		return session.selectList(NAMESPACE+".selectbyCategoryBoard", href);
	}



}
