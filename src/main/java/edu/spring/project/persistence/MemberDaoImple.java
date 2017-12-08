package edu.spring.project.persistence;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.project.domain.Member;

@Repository
public class MemberDaoImple implements MemberDao {
	
	private static final String NAMESPACE = "edu.spring.project.mappers.MemberMapper";
	
	@Autowired private SqlSession session;
	
	@Override
	public int insert(Member m) {
		return session.insert(NAMESPACE + ".memberInsert", m);
	}

	@Override
	public Member idCheck(String userid) {
		return session.selectOne(NAMESPACE + ".idCheck", userid);
	}

	@Override
	public Member login(Map<String, String> map) {
		return session.selectOne(NAMESPACE + ".login", map);
	}

	@Override
	public Member readDetail(String userid) {
		return session.selectOne(NAMESPACE+".detail", userid);
	}

	@Override
	public int updateDetail(Member m) {
		 System.out.println(m);
		 int i = session.update(NAMESPACE+".detailupdate", m);
		 System.out.println(i);
		 return i;
	}

	@Override
	public int memberdelete(String userid) {
		return session.delete(NAMESPACE+".memberdelete", userid);
	}

}
