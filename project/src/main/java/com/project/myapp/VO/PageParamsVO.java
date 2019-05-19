package com.project.myapp.VO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor //인자 전달받는 생성자 생성 가능
public class PageParamsVO {

	private int page; // 현재 페이지
	private int limit; // 페이지당 글 수
	
	// 검색 관련 검색어 
	private String searchingKeyword;
    // 검색 옵션
	private String searchOption;

	//검색옵션으로 넘길 파라미터
	private String id;
	private String title;
	private String content;
	

}
