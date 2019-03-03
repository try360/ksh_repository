package com.practice.PostgreSQL.service;

import java.util.List;

import com.practice.PostgreSQL.VO.BoardVO;

public interface BoardService {

	public List<BoardVO> selectAll_BoardList(BoardVO boardVO) throws Exception;	

	public int reg_board(BoardVO boardVO) throws Exception;
	
}
