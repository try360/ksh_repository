package com.project.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.myapp.DAO.MemberDAO;
import com.project.myapp.VO.MemberVO;

@Service
public class MemberDAOServiceImpl implements MemberDAOService {
	
	
	@Autowired
	private MemberDAO memberDao;

	public void insertMember(MemberVO memberVO) {
		memberDao.insertMember(memberVO);
	}

	@Override
	public List<MemberVO> getAllMembers() {
		System.out.println("    MemberDAOServiceImpl      getAllMemberS()   "  );
		return memberDao.getAllMembers();
	}

}
