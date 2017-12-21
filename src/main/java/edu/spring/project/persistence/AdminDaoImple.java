package edu.spring.project.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.project.domain.BoardContents;
import edu.spring.project.domain.BoardFree;
import edu.spring.project.domain.Member;
import edu.spring.project.domain.Menu;
import edu.spring.project.pageutil.PaginationCriteria;

@Repository
public class AdminDaoImple implements AdminDao {

	private static final String NAMESPACE = "edu.spring.project.mappers.AdminMapper";
	@Autowired SqlSession session;
	
	@Override
	public Member login(Map<String, String> map) {

		return session.selectOne(NAMESPACE+".adminLogin", map);
	}

	@Override
	public List<Member> memberList() {
		return session.selectList(NAMESPACE + ".MemberSelectAll");
	}

	@Override
	public Member memberDetail(String userid) {
		return session.selectOne(NAMESPACE + ".MemberSelectById", userid);
	}

	@Override
	public int memberUpdate(Member m) {
		
		return session.update(NAMESPACE + ".DetailUpdate", m);
	}

	@Override
	public int memberGradeUpdate(String userid, String grade) {
		Map<String, String> args = new HashMap<>();
		args.put("userid", userid);
		args.put("grade", grade);
		return session.update(NAMESPACE + ".MemberGradeUpdate", args);
	}

	@Override
	public int memberDelete(String userid) {
		return session.delete(NAMESPACE+".MemberDelete", userid);
	}

	@Override
	public List<Menu> menuselect() {
		return session.selectList(NAMESPACE+".selectMenu");
	}

	@Override
	public Menu detailmenu(String mnum) {
		return session.selectOne(NAMESPACE+".detailMenu", mnum);
	}

	@Override
	public int menuUpdate(Menu menu) {
		return session.update(NAMESPACE+".updateMenu", menu);
	}

	@Override
	public int menuInsert(Menu menu) {
		return session.insert(NAMESPACE+".insertMenu", menu);
	}

	@Override
	public List<BoardContents> selectBoard(PaginationCriteria c) {
		return session.selectList(NAMESPACE+".BoardContentsSelectAll2",c);
	}

	// Contents 일 경우
	@Override
	public List<Object> selectByConCategory(Map<String, Object> map) {
		return session.selectList(NAMESPACE+".selectByConCategory",map);
	}

	// Free일 경우
	@Override
	public List<Object> BoardFreeSelectAll(PaginationCriteria c) {
		return session.selectList(NAMESPACE+".BoardFreeSelectAll",c);
	}

	@Override
	public Object boardConDetail(int bno) {
		return session.selectOne(NAMESPACE+".boardConDetail", bno);
	}

	@Override
	public Object boardFreeDetail(int fbno) {
		return session.selectOne(NAMESPACE+".boardFreeDetail", fbno);
	}

	@Override
	public int boardConDelete(int bno) {
		return session.delete(NAMESPACE+".boardConDelete", bno);
	}

	@Override
	public int getTotalCount() {
		return session.selectOne(NAMESPACE+".totalCount");
	}

	@Override
	public int getFreeTotalCount() {
		return session.selectOne(NAMESPACE+".FreeTotalCount");
	}
	
	@Override
	public int getConTotalCount(String category) {
		return session.selectOne(NAMESPACE+".ConTotalCount", category);
	}

	@Override
	public int boardFreeDelete(int fbno) {
		return session.delete(NAMESPACE+".boardFreeDelete", fbno);
	}

	@Override
	public int boardConUpdate(BoardContents b) {
		return session.update(NAMESPACE+".boardConUpdate", b);
	}

	@Override
	public int boardFreeUpdate(BoardFree b) {
		return session.update(NAMESPACE+".boardFreeUpdate", b);
	}

}
