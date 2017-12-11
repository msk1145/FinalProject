package edu.spring.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.project.domain.Member;
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

}
