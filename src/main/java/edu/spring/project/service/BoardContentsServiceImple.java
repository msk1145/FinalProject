package edu.spring.project.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.project.domain.BoardContents;
import edu.spring.project.domain.BoardContentsVO;
import edu.spring.project.domain.Menu;
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
	public int updatecount(int bno) {
		
		return boardConDao.countupdate(bno);
	}

	@Override
	public List<List<BoardContentsVO>> selectmenu() {
		List<Menu> list = boardConDao.selectMenu();
		List<List<BoardContentsVO>> boardlist = new ArrayList<>();
		for(Menu m : list) {
			List<BoardContentsVO> li = boardConDao.selectbyCategoryBoard(m.getHref());
			if(li.size() == 0) {
				BoardContentsVO vo = new BoardContentsVO();
				vo.setMenuname("123");
				vo.setTitle("등록된 영상이 없음");
				li.add(vo);
			}
			boardlist.add(li);
		}
		/*for (List<BoardContentsVO> l : boardlist) {
			for (BoardContentsVO vo : l) {
				
			}
		}*/
		return boardlist;
	}

}
