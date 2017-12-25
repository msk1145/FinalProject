package edu.spring.project.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.project.domain.Member;
import edu.spring.project.persistence.MemberDao;

@Service
public class MemberServiceImple implements MemberService {

	@Autowired MemberDao dao;
	
	// 회원 가입
	@Override
	public int insert(Member m) {
		return dao.insert(m);
	}

	@Override
	public boolean idCheck(String userid) {
		Member m = dao.idCheck(userid);
		if(m == null) {
			// id 존재하지 않음 id 생성 가능
			return false;
		}else {
			// id 존재
			return true;
		}
	}

	@Override
	public Member login(String userid, String password) {
		Map<String, String> map = new HashMap<>();
		map.put("userid", userid);
		map.put("password", password);

		return dao.login(map);
	}

	@Override
	public Member readDetail(String userid) {
		return dao.readDetail(userid);
	}

	@Override
	public Member updateDetail(Member m) {
		if(m != null) {
			Integer i = dao.updateDetail(m);
			System.out.println(i);
			if(i > 0) {
				return dao.readDetail(m.getUserid());
			}else {
				return null;
			}
		}else {
			return null;
		}
	}

	@Override
	public int memberdelete(String userid) {
		return dao.memberdelete(userid);
	}

	@Override
	public Member findInfo(Member m) {
		return dao.findInfo(m);
	}

	@Override
	public int setTempPw(Member m) {
		return dao.setTempPw(m);
	}

}
