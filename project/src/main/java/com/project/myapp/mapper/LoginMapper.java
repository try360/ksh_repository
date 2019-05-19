package com.project.myapp.mapper;

import com.project.myapp.VO.LoginVO;
import com.project.myapp.VO.MemberVO;

public interface LoginMapper {

	MemberVO login(LoginVO loginVO);
}
