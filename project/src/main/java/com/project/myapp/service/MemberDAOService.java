package com.project.myapp.service;

import java.util.List;

import com.project.myapp.VO.MemberVO;
import com.project.myapp.VO.WritingVO;

public interface MemberDAOService {

	public void insertMember(MemberVO memberVO);
	
	public List<MemberVO> getAllMembers();
	
	
	
}
