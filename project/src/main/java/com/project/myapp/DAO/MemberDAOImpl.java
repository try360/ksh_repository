package com.project.myapp.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.myapp.VO.MemberVO;

@Service
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	// @Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;

	/*
	 * @SuppressWarnings("unchecked") public List selectList(Map param) { List
	 * result = sqlsession.selectList("boardSql.selectList", param); return result;
	 * }
	 */

	@Override
	public void insertMember(MemberVO memberVO) {
		System.out.println("   MemberDAOImpl      insertMemmber()      ");
		sqlSession.insert("insertMember", memberVO);

	}

	@Override
	public List<MemberVO> listAll() {
		return null;
	}

	@Override
	public List<MemberVO> getAllMembers() {
		System.out.println("   MemberDAOImpl      getAllMembers()      ");

		return sqlSession.selectList("getAllMembers");
	}

}
