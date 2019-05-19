package com.project.myapp.service;

import java.util.List;

import com.project.myapp.VO.PageParamsVO;
import com.project.myapp.VO.WritingVO;

public interface WritingDAOService {

	public void inserWriting(WritingVO writingVO);

	public void deleteWriting(int w_no);

	public List<WritingVO> listPage(int page);

	// 전체 게시글 카운트
	public int countAllWriting();
	// 게시글 전체 가져오기
	public List<WritingVO> getAllWriting();
	
	// 페이징 된 글 목록 보기
	public List<WritingVO> pagedWritingList(PageParamsVO pageParamsVO);
	
	//게시글 검색 및 페이징
	public List<WritingVO> searchWritingList(PageParamsVO pageParamsVO);
	
	// 게시글 검색결과 레코드 카운팅
	public int searchCountWritingList(PageParamsVO pageParamsVO);
	
	public WritingVO referWriting(int bno); // 게시글 조회 
	
	public void truncateAll();
	
	//글 번호에 해당하는 레코드 가져오기
	public WritingVO getWriting(int w_no);
	
	//조회수 세기
	public void viewCount(int w_no);
	
	public void updateWriting(WritingVO writingVO);
	
	// 각각 점수 평균 내서 가져오기
	public String getDesign_score(int w_no);
	public String getPrr_score(int w_no);
	public String getDurablity_score(int w_no);
}
