package com.project.myapp.service;

import java.util.List;

import com.project.myapp.VO.ReplyVO;

public interface ReplyService {

	// 댓글 목록
	public List<ReplyVO> listReply(int bno);

	// 댓글 입력
	public void insertReply(ReplyVO replyVO);

	// 댓글 수정
	public void updateReply(ReplyVO replyVO);

	// 댓글 삭제
	public void deleteReply(int reply_no);

	public int countReply(int writing_no);

}
