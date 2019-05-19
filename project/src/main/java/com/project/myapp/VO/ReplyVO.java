package com.project.myapp.VO;

import lombok.Data;

@Data
public class ReplyVO {

	int reply_no;
	int writing_no; // 게시글에 댓글수 넣을 것
	String reply_id;
	String reply_comment;

	//점수들
	int design_score;
	int prr_score;
	int durablity_score;
	
	String reply_date;

}
