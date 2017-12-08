package edu.spring.project.persistence;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.project.domain.Member;

@Repository
public class AdminDaoImple implements AdminDao {

	private static final String NAMESPACE = "edu.spring.project.mappers.AdminMapper";
	@Autowired SqlSession session;
	
	@Override
	public Member login(Map<String, String> map) {
		return session.selectOne(NAMESPACE+".adminLogin");
	}

}
