package edu.spring.project.service;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.project.domain.BoardContents;
import edu.spring.project.domain.BoardFree;
import edu.spring.project.domain.Member;
import edu.spring.project.domain.Menu;
import edu.spring.project.pageutil.PaginationCriteria;
import edu.spring.project.persistence.AdminDao;

@Service
public class AdminServiceImple implements AdminService {

	@Autowired AdminDao dao;
	
	@Override
	public Member login(String userid, String password) {
		Map<String, String> map = new HashMap<>();
		map.put("userid", userid);
		map.put("password", password);
		return dao.login(map);
	}

	@Override
	public List<Member> memberList() {
		
		return dao.memberList();
	}

	@Override
	public Member memberDetail(String userid) {
		return dao.memberDetail(userid);
	}

	@Override
	public int memberUpdate(Member m) {
		return dao.memberUpdate(m);
	}

	@Override
	public int memberGradeUpdate(String userid, String grade) {
		return dao.memberGradeUpdate(userid, grade);
	}

	@Override
	public int memberDelete(String userid) {
		return dao.memberDelete(userid);
	}

	@Override
	public List<Menu> selectMenu() {
		return dao.menuselect();
	}

	@Override
	public Menu detailMenu(String mnum) {
		return dao.detailmenu(mnum);
	}

	@Override
	public int updateMenu(Menu menu) {
		return dao.menuUpdate(menu);
	}

	@Override
	public int insertMenu(Menu menu) {
		return dao.menuInsert(menu);
	}

	@Override
	public List<BoardContents> selectBoard(PaginationCriteria c) {
		Map<String,Integer> map = new HashMap<>();
		
		
		return dao.selectBoard(c);
	}

	@Override
	public List<Object> selectByConCategory(String category, PaginationCriteria c) {
		List<Object> list = null;
		if(category.equals("free")) {
			list = dao.BoardFreeSelectAll(c);
		}else {
			Map<String,Object> map = new HashMap<>();
			map.put("category", category);
			map.put("obj", c);
			list = dao.selectByConCategory(map);
		}
		
		return list;
	}

	@Override
	public Object boardDetail(int bno, String category) {
		if(category.equals("free")) {
			int fbno = bno;
			System.out.println(fbno);
			return dao.boardFreeDetail(fbno);
		}else {
			return dao.boardConDetail(bno);
		}
	}

	@Override
	public int boardConDelete(int bno) {
		return dao.boardConDelete(bno);
	}

	@Override
	public int getTotalCount() {
		return dao.getTotalCount();
	}

	@Override
	public int getFreeTotalCount() {
		return dao.getFreeTotalCount();
	}

	@Override
	public int getConTotalCount(String category) {
		return dao.getConTotalCount(category);
	}

	@Override
	public int boardFreeDelete(int fbno) {
		return dao.boardFreeDelete(fbno);
	}

	@Override
	public int boardConUpdate(BoardContents b) {
		return dao.boardConUpdate(b);
	}

	@Override
	public int boardFreeUpdate(BoardFree b) {
		return dao.boardFreeUpdate(b);
	}

}
