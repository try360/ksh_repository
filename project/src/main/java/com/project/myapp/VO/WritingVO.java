package com.project.myapp.VO;


import lombok.Data;

@Data

public class WritingVO {

	/**
	 * 업로드한 이미지 파일이 저장될 경로
	 */

	int w_no;

	String id;

	String title;

	String model_name;

	String image_name = "";

	String thumbnail_name = "";

	String content;

	String w_date;

	int reply_count; // 게시글 댓글의 수 추가

	int viewcnt = 0; // 조회수

	// 평균 점수
	String avg_design_score;
	String avg_prr_score;
	String avg_durablity_score;

}
