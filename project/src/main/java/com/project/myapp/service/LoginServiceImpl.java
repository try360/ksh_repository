package com.project.myapp.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.project.myapp.DAO.LoginDAO;
import com.project.myapp.VO.LoginVO;
import com.project.myapp.VO.MemberVO;

@Service
public class LoginServiceImpl implements LoginService {

	@Inject
	private LoginDAO loginDAO;

	@Override
	public MemberVO login(LoginVO loginVO) {
		// TODO Auto-generated method stub

		System.out.println("         LoginSerivceImpl login()         " + loginVO);
		return loginDAO.login(loginVO);
	}

}
