package com.practice.PostgreSQL.service;

import java.util.List;

import com.practice.PostgreSQL.VO.BoardVO;
import com.practice.PostgreSQL.VO.MemberVO;

public interface MemberService {

	public int sign_up_member(MemberVO memberVO) throws Exception;

}
