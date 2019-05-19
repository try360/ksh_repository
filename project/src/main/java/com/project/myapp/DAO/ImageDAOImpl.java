package com.project.myapp.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.myapp.mapper.ImageMapper;

@Repository
public class ImageDAOImpl implements ImageDAO {

	@Autowired
	// @Resource(name = "sqlSession")
	// private SqlSessionTemplate sqlsession;
	private SqlSession sqlSession;
	
	@Override
	public int getWritingPrimaryKey() {
		
		return sqlSession.selectOne("getWritingPrimaryKey"); //== null ? 0 : sqlSession.selectOne("getWritingPrimaryKey");
		// 뒤에꺼 추가하면 sqlSession.selectOne("getWritingPrimaryKey")을  한번 더 실행 한다.
	   // list로 안가져오고 단일 값으로 가져오려면 selectOne 을 쓴다. 게시글을 처음 등록했을 때 프라이머리 키 값이 없으므로 삼항 연산자를 이용해 0으로 초기화 해준다.
	}

}
