package com.project.myapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.myapp.VO.PageInfoVO;
import com.project.myapp.VO.PageParamsVO;
import com.project.myapp.VO.WritingVO;
import com.project.myapp.service.ReplyService;
import com.project.myapp.service.WritingDAOService;

import io.swagger.annotations.Api;

/**
 * Handles requests for the application home page.
 */

@Api(value = "HomeController", description = "HomeController 역할", basePath = "/")
@Controller
public class HomeController {

	@Autowired
	private WritingDAOService writingDaoService;


	@Autowired
	private ReplyService replyService;
	// TEST
	/*
	 * @RequestMapping("/") public String main(Model model, HttpServletRequest
	 * req) { System.out.println("    HomeController       main()    ");
	 * List<WritingVO> writingList = writingDaoService.getAllWriting();
	 * 
	 * List<String> dateList = new ArrayList<>(); // JSP에서 날짜가 파싱이 안돼서 for (int
	 * i = 0; i < writingList.size(); i++) {
	 * dateList.add(writingList.get(i).getW_date()); }
	 * model.addAttribute("writingList", writingList); // DB에 글을 보냄
	 * 
	 * System.out.println(writingList.get(1).toString());
	 * model.addAttribute("dateList", dateList);// 날짜를 main.jsp에 전송 return
	 * "main"; }
	 */

	
	@RequestMapping("/")
	public String main(Model model, HttpServletRequest req) {
		System.out.println("     HomeController       main()    ");
		return "redirect:/boardList.do/1";
		// boardList.do/1
	}

	// main 화면 및 게시글 목록
	@RequestMapping("/boardList.do/{page}")
	public String pagedMain(Model model, HttpServletRequest req, @PathVariable("page") int page,
			@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "") String searchOption) {
		System.out.println("    HomeController    pageMain()    ");

		String movePage = "main";

		///// paging 처리 ///////////////////////////////////////////////
		int limit = 10; // 페이지당 글수

		page = page != 0 ? page : 1; // page 설정

		// 현재 페이지에 보여줄 시작 페이지 수 (1, 11, 21,...)
		int startPage = (((int) ((double) page / 10 + 0.9)) - 1) * 10 + 1;
		// 현재 페이지에 보여줄 마지막 페이지 수(10, 20, 30, ...)
		int endPage = startPage + 10 - 1;

		PageParamsVO pageParamsVO = new PageParamsVO(page, limit, keyword.trim(), searchOption.trim(), "", "", "");
		System.out.println("pageParamsVO    :    " + pageParamsVO);

		if (pageParamsVO.getSearchingKeyword() == null || pageParamsVO.getSearchOption() == null
				|| pageParamsVO.getSearchingKeyword() == "" || pageParamsVO.getSearchOption() == "") {
			// 검색어가 없는 경우 모든 데이터를 select 한다
			int listCount = writingDaoService.countAllWriting();
			int maxPage = (int) ((double) listCount / limit + 0.95);
			// 0.95를 더해서 올림
			List<WritingVO> writingList = writingDaoService.pagedWritingList(pageParamsVO);
			// 메소드 실행결과 List 형태로 출력이 되기 떄문에 이 것을 그대로 List 변수에 집어 넣음

			// 게시물의 댓글수를 구해서 s_writingList에 넣어준다
			for (int i = 0; i < writingList.size(); i++) {
				writingList.get(i).setReply_count(replyService.countReply(writingList.get(i).getW_no()));
			}

			System.out.println(" 아래는 댓글 수 표기 ");
			for (int i = 0; i < writingList.size(); i++) {
				System.out.println(writingList.get(i).getReply_count());
			}

			// 평가 점수 평균 구하기
			for (int i = 0; i < writingList.size(); i++) {
				writingList.get(i).setAvg_design_score(writingDaoService.getDesign_score(writingList.get(i).getW_no()));
				writingList.get(i).setAvg_prr_score(writingDaoService.getPrr_score(writingList.get(i).getW_no()));
				writingList.get(i).setAvg_durablity_score(writingDaoService.getDurablity_score(writingList.get(i).getW_no()));
			}

			if (endPage > maxPage) {
				endPage = maxPage;
			} // 처리.

			PageInfoVO pageInfo = new PageInfoVO();
			pageInfo.setEndPage(endPage);
			pageInfo.setListCount(listCount);
			pageInfo.setMaxPage(maxPage);
			pageInfo.setPage(page);
			pageInfo.setStartPage(startPage);

			// 레코드의 갯수 구하기
			int count = writingDaoService.searchCountWritingList(pageParamsVO);

			model.addAttribute("count", count); // 레코드의 갯수
			model.addAttribute("searchOption", searchOption); // 검색옵션
			model.addAttribute("keyword", keyword); // 검색키워드
			model.addAttribute("limit", limit); // 페이지당 나오는 레코드
			model.addAttribute("pageInfo", pageInfo);
			model.addAttribute("writingList", writingList);

			// 게시글에 달린 댓글스 출력하기 위해 다음과 같이 리스트에 하나씩 게시글에 대한 댓글 수를 넣어준다.

		} else {// 검색어가 있는 경우 검색어에 해당하는 데이터만 가져온다.

			// 검색어가 있는 경우 다른 페이지로 이동하기 위해 설정
			movePage = "Main";

			if (pageParamsVO.getSearchOption().equals("id")) {
				pageParamsVO.setId(pageParamsVO.getSearchingKeyword());
			} else if (pageParamsVO.getSearchOption().equals("title")) {
				pageParamsVO.setTitle(pageParamsVO.getSearchingKeyword());
			} else if (pageParamsVO.getSearchOption().equals("content")) {
				pageParamsVO.setContent(pageParamsVO.getSearchingKeyword());
			}

			System.out.println(" 여기는 검색어가 있는 경우    pageParamsVO   :   " + pageParamsVO);
			int s_listCount = writingDaoService.searchCountWritingList(pageParamsVO);

			//////////////////////////////////////////////////////////////////////////////

			List<WritingVO> s_writingList = writingDaoService.searchWritingList(pageParamsVO);

			// 게시물의 댓글수를 구해서 s_writingList에 넣어준다
			for (int i = 0; i < s_writingList.size(); i++) {
				s_writingList.get(i).setReply_count(replyService.countReply(s_writingList.get(i).getW_no()));
			}

			System.out.println(" 아래는 댓글 수 표기 ");
			for (int i = 0; i < s_writingList.size(); i++) {
				System.out.println(s_writingList.get(i).getReply_count());
			}

			// 평가 점수 평균 구하기
			for (int i = 0; i < s_writingList.size(); i++) {
				s_writingList.get(i).setAvg_design_score(writingDaoService.getDesign_score(s_writingList.get(i).getW_no()));
				s_writingList.get(i).setAvg_design_score(writingDaoService.getPrr_score(s_writingList.get(i).getW_no()));
				s_writingList.get(i).setAvg_design_score(writingDaoService.getDurablity_score(s_writingList.get(i).getW_no()));			}

			int maxPage = (int) ((double) s_listCount / limit + 0.95);
			// 0.95를 더해서 올림

			System.out.println("  s_writingList.size()  : " + s_writingList.size());
			
			/*
			 * for(WritingVO writingVO : s_writingList) {
			 * System.out.println(writingVO); }
			 */

			if (endPage > maxPage) {
				endPage = maxPage;
			} // 처리.

			PageInfoVO s_pageInfo = new PageInfoVO();
			s_pageInfo.setEndPage(endPage);
			s_pageInfo.setListCount(s_listCount);
			s_pageInfo.setMaxPage(maxPage);
			s_pageInfo.setPage(page);
			s_pageInfo.setStartPage(startPage);

			// 레코드의 갯수 구하기
			int count = writingDaoService.searchCountWritingList(pageParamsVO);

			model.addAttribute("count", count); // 레코드의 갯수
			model.addAttribute("searchOption", searchOption); // 검색옵션
			model.addAttribute("keyword", keyword); // 검색키워드
			model.addAttribute("limit", limit); // 페이지당 나오는 레코드
			model.addAttribute("pageInfo", s_pageInfo);
			model.addAttribute("writingList", s_writingList);

		}

		return movePage;
	}

	
}
