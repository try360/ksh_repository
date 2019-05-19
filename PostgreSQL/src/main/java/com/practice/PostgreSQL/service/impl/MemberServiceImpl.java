package com.practice.PostgreSQL.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.practice.PostgreSQL.VO.MemberVO;
import com.practice.PostgreSQL.dao.MemberDAO;
import com.practice.PostgreSQL.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{

	@Inject
	MemberDAO memberDAO;

	@Override
	public int sign_up_member(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return memberDAO.sign_up_member(memberVO);
	}
	
	


}
