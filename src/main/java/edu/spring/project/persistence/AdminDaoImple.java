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
	public List<BoardContents> selectBoard() {
		return session.selectList(NAMESPACE+".BoardContentsSelectAll2");
	}

	// Contents 일 경우
	@Override
	public List<Object> selectByConCategory(String category) {
		return session.selectList(NAMESPACE+".selectByConCategory",category);
	}

	// Free일 경우
	@Override
	public List<Object> BoardFreeSelectAll() {
		return session.selectList(NAMESPACE+".BoardFreeSelectAll");
	}

	@Override
	public Object boardConDetail(int bno) {
		return session.selectOne(NAMESPACE+".boardConDetail", bno);
	}

	@Override
	public Object boardFreeDetail(int fbno) {
		return session.selectOne(NAMESPACE+".boardFreeDetail", fbno);
	}

}
