package com.practice.PostgreSQL.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.practice.PostgreSQL.VO.BoardVO;
import com.practice.PostgreSQL.dao.BoardDAO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	SqlSession sqlSession;

	//@Autowired 대신에 스프링 4.3에서는 이게 가능하다
	public BoardDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	String MapperName = "mybatis.mapper.BoardMapper";

	private static final Logger logger = LoggerFactory.getLogger(BoardDAOImpl.class);

	@Override
	public List<BoardVO> selectAll_BoardList(BoardVO boardVO) throws Exception {
		return sqlSession.selectList(MapperName + ".selectAll_BoardList");
	}

	@Override
	public int reg_board(BoardVO boardVO) throws Exception {
		logger.info("넘어온 값   :   " + boardVO);
		return sqlSession.insert(MapperName + ".reg_board", boardVO); // 글 넣기
	}

	@Override
	public int truncate_board_list() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(MapperName + ".truncate_board_list");
	}

}
