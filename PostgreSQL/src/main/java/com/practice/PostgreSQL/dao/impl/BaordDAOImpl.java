package com.practice.PostgreSQL.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.practice.PostgreSQL.VO.BoardVO;
import com.practice.PostgreSQL.dao.BoardDAO;

@Repository
public class BaordDAOImpl implements BoardDAO{

	SqlSession sqlSession;

   String MapperName = "mybatis.BoardMapper";
	
	@Override
	public List<BoardVO> selectAll_BoardList(BoardVO boardVO) throws Exception {
		return sqlSession.selectList(MapperName + ".selectAll_BoardList");
	}

	@Override
	public int reg_board(BoardVO boardVO) throws Exception {
		return sqlSession.insert(MapperName+".reg_board",boardVO);
	}

}
