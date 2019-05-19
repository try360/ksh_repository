package com.practice.PostgreSQL.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.practice.PostgreSQL.VO.BoardVO;
import com.practice.PostgreSQL.dao.BoardDAO;
import com.practice.PostgreSQL.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService{

	@Inject
	BoardDAO boardDAO;
	
	@Override
	public List<BoardVO> selectAll_BoardList(BoardVO boardVO) throws Exception {
		return boardDAO.selectAll_BoardList(boardVO);
	}

	@Override
	public int reg_board(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.reg_board(boardVO);
	}

	@Override
	public int truncate_board_list() throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.truncate_board_list();
	}
	


}
