/**
 * 
 */
package com.project.myapp.mapper;

import java.util.List;

import com.project.myapp.VO.PageInfoVO;
import com.project.myapp.VO.PageParamsVO;
import com.project.myapp.VO.WritingVO;

//mapper
public interface WritingMapper {

	void insertWriting(WritingVO writing);

	void updateWriting(WritingVO writingVO);

	// 전체 글 보기
	List<WritingVO> getAllWriting();
	// 전체 글 수 카운트
	int countAllWriting();

	// 페이징 된 글 목록 보기
	WritingVO pagedWritingList(PageParamsVO pageParamsVO);

	WritingVO getWriting(int w_no);

	void deleteWriting(int w_no);

	// 검색 결과를 페이징 (
	List<WritingVO> searchWritingList(PageParamsVO pageParamsVo);

	// 검색 결과를 페이징한후 튜플 카운팅
	int searchCountWritingList(PageParamsVO pageParamsVo);

	WritingVO referWriting(int w_no);

	void truncateAll();
	
	void viewCount(int w_no);
	
	// 각각 점수 평균 내서 가져오기
	String getDesign_score(int w_no);
	String getPrr_score(int w_no);
	String getDurablity_score(int w_no);
}
