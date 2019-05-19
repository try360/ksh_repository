package com.project.myapp.mapper;

import java.util.List;

import com.project.myapp.VO.ReplyVO;

public interface ReplyMapper {

	public interface CommentMapper {

		// 댓글 개수
		public int countReply(int writing_no) ;

		// 댓글 목록
		public List<ReplyVO> listReply() ;

		// 댓글 작성
		public void insertReply(ReplyVO replyVO) ;

		// 댓글 수정
		public void updateReply(ReplyVO replyVO) ;

		// 댓글 삭제
		public void deleteReply(int reply_no);

	}

}
