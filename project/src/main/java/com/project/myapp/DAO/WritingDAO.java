package com.project.myapp.DAO;

import java.util.List;

import com.project.myapp.VO.PageParamsVO;
import com.project.myapp.VO.WritingVO;

public interface WritingDAO {

	public void insertWriting(WritingVO writingVO);

	public void deleteWriting(int w_no);

	public List<WritingVO> getAllWriting(); // 게시글 전체 목록
	
	public int countAllWriting();// 전체 게시글 카운트

	public void updateWriting(WritingVO writingVO); // 게시글 수정

	public void inscreaseWritingCount(int w_count); // 게시글 조회수 증가

	// 페이징 된 글 목록 보기
	public List<WritingVO> pagedWritingList(PageParamsVO pageParamsVO);

	// 검색후 페이징
	public List<WritingVO> searchWritingList(PageParamsVO pageParamsVO);

	// 검색후 페이징한 결과의 레코드를 카운팅
	public int searchCountWritingList(PageParamsVO pageParamsVO);

	public WritingVO referWriting(int w_no);

	public void truncateAll();

	public WritingVO getWriting(int w_no);

	//조회수 증가
	public void viewCount(int w_no);
	
	// 각각 점수 평균 내서 가져오기
	public String getDesign_score(int w_no);
	public String getPrr_score(int w_no);
	public String getDurablity_score(int w_no);

}
