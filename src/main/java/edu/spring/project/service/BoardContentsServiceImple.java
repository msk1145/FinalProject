package edu.spring.project.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.project.domain.BoardContents;

import edu.spring.project.domain.BoardContentsVO;
import edu.spring.project.domain.Menu;

import edu.spring.project.pageutil.PaginationCriteria;

import edu.spring.project.persistence.BoardContentsDao;

@Service
public class BoardContentsServiceImple implements BoardContentsService {
	private static final Logger logger =
			LoggerFactory.getLogger(BoardContentsServiceImple.class);
	
	@Autowired
	private BoardContentsDao boardConDao;
	
	@Override
	public List<BoardContents> readPaging(String category, PaginationCriteria c) {
		return boardConDao.readPaging(category, c);
	}
	
	@Override
	public int totalCount(String category) {
		return boardConDao.totalCount(category);
	}

	@Override
	public List<BoardContents> readSearchedPaging(String category, PaginationCriteria c, String keyword,
			int searchType) {
		return boardConDao.readSearchedPaging(category, c, keyword, searchType);
	}

	@Override
	public int searchedTotalCount(String category, String keyword, int searchType) {
		return boardConDao.searchedTotalCount(category, keyword, searchType);
	}
	
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
	public int updatecount(int bno) {
		
		return boardConDao.countupdate(bno);
	}


	@Override
	public List<List<BoardContentsVO>> selectmenu() {
		List<Menu> list = boardConDao.selectMenu();
		List<List<BoardContentsVO>> boardlist = new ArrayList<>();
		for(Menu m : list) {
			List<BoardContentsVO> li = boardConDao.selectbyCategoryBoard(m.getHref());
			
			for(int i = li.size(); i < 5; i++) {
				BoardContentsVO vo = new BoardContentsVO();
				// 게시물하나도 없는경우
				if(li.size() == 0) {
					vo.setTitle("none");
					li.add(vo);
					break;
				// 게시물이 5개 미만인 경우
				} else {
					vo.setTitle("blank");
					li.add(vo);
				}
			}
			
			/*
			if(li.size() == 0) {
				BoardContentsVO vo = new BoardContentsVO();
				vo.setTitle("등록된 게시글이 없음");
				li.add(vo);
			}
			*/
			boardlist.add(li);
		}
		
		return boardlist;
	}

}
