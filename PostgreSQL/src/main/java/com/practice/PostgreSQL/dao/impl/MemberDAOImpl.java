package com.practice.PostgreSQL.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.practice.PostgreSQL.VO.MemberVO;
import com.practice.PostgreSQL.dao.MemberDAO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	// @Autowired
	SqlSession sqlSession;

	//@Autowired 대신에 스프링 4.3에서는 이게 가능하다
	public MemberDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	String MapperName = "mybatis.mapper.memberMapper";

	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);

	@Override
	public int sign_up_member(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(MapperName+".sign_up_member", memberVO);
	}

	
}
