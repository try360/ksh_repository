package com.project.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.myapp.DAO.ReplyDAO;
import com.project.myapp.VO.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	ReplyDAO replyDAO;

	@Override
	public List<ReplyVO> listReply(int writing_no) {
		return replyDAO.replyList(writing_no);
	}

	@Override
	public void insertReply(ReplyVO replyVO) {
		replyDAO.replyInsert(replyVO);
	}

	@Override
	public void updateReply(ReplyVO replyVO) {
		// TODO Auto-generated method stub
	}

	@Override
	public int countReply(int writing_no) {
		// TODO Auto-generated method stub
		return replyDAO.countReply(writing_no);
	}

	@Override
	public void deleteReply(int reply_no) {
		replyDAO.deleteReply(reply_no);
	}

}
