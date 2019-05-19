package com.practice.PostgreSQL.dao;

import java.util.List;

import com.practice.PostgreSQL.VO.BoardVO;
import com.practice.PostgreSQL.VO.MemberVO;

public interface MemberDAO {

	public int sign_up_member(MemberVO memberVO) throws Exception;

	
}
