package com.project.myapp.DAO;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.project.myapp.VO.LoginVO;
import com.project.myapp.VO.MemberVO;

@Service
public class LoginDAOImpl implements LoginDAO {

	@Inject
	private SqlSession sqlSession;

	private static String namespace = "com.project.myapp.mapper.LoginMapper";

	@Override
	public MemberVO login(LoginVO loginVO) {
		// TODO Auto-generated method stub
		System.out.println("      LoginDAOImpl login()     "  + loginVO);
		return (MemberVO) sqlSession.selectOne(namespace + ".login", loginVO); // Mapper.xml에 login 으로 접근하라!!
	}

}
