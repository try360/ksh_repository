package com.project.myapp.DAO;

import java.util.List;

import com.project.myapp.VO.ReplyVO;

public interface ReplyDAO {

	// 댓글 목록
	public List<ReplyVO> replyList(int bno);

	// 댓글 입력
	public void replyInsert(ReplyVO vo);

	// 댓글 수정
	public void replyUpdate(ReplyVO vo);

	// 댓글 삭제
	public void deleteReply(int reply_no);
	
	// 댓글 갯수
	public int countReply(int writing_no);

}
