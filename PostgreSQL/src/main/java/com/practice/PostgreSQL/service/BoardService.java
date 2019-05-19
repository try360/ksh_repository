package com.practice.PostgreSQL.service;

import java.util.List;

import com.practice.PostgreSQL.VO.BoardVO;
import com.practice.PostgreSQL.VO.MemberVO;

public interface BoardService {

	public List<BoardVO> selectAll_BoardList(BoardVO boardVO) throws Exception;	
	
	public int reg_board(BoardVO boardVO) throws Exception;
	
	public int truncate_board_list() throws Exception;

	
	
}
