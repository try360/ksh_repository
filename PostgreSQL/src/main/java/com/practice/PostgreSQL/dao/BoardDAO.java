package com.practice.PostgreSQL.dao;

import java.util.List;

import com.practice.PostgreSQL.VO.BoardVO;

public interface BoardDAO {

	public List<BoardVO> selectAll_BoardList(BoardVO boardVO) throws Exception;
	
	public int reg_board(BoardVO boardVO) throws Exception;
	
}
