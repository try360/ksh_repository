package com.project.myapp.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.myapp.VO.MemberVO;
import com.project.myapp.VO.ReplyVO;
import com.project.myapp.service.ReplyService;

import lombok.extern.slf4j.Slf4j;

// REST : Representational State Transfer
// 하나의 URI가 하나의 고유한 리소스를 대표하도록 설계된 개념

// http://localhost/spring02/list?bno=1 ==> url+파라미터
// http://localhost/spring02/list/1 ==> url
// RestController은 스프링 4.0부터 지원
// @Controller, @RestController 차이점은 메서드가 종료되면 화면전환의 유무
//@Controller

@RestController
@Slf4j
@RequestMapping("/reply")
public class ReplyContoller {

	@Inject
	ReplyService replyService;

	// 댓글 입력
	@RequestMapping(value = "/insert.do", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded; charset=UTF-8")
	// public void insert(@ModelAttribute ReplyVO replyVO, HttpSession session){
	/*
	 * public void insert(@RequestParam("replytext") String
	 * replytext, @RequestParam("writing_no") int writing_no, HttpSession
	 * session) {
	 */
	public void insertReply(@RequestParam Map<String, Object> paramMap, HttpSession session) {
		System.out.println("    ReplyController insertReply()    ");

		System.out.println("session ID  :  " + session.getAttribute("login"));
      System.out.println( "   paramMap    :   " +  paramMap);
		// 로그인중인 id값을 가져온다 (session 값을 통해서 가져옴)
		//String userID = ((MemberVO) session.getAttribute("login")).getId();
		// System.out.println("replyController에서 유지중인 세션 : " + userID);
		ReplyVO replyVO = new ReplyVO();

		replyVO.setWriting_no(Integer.parseInt(paramMap.get("w_no").toString())); // 문자열을
																					// 숫자로
		replyVO.setReply_id(paramMap.get("id").toString());
		replyVO.setReply_comment(paramMap.get("replyText").toString());
		replyVO.setDesign_score(Integer.parseInt(paramMap.get("design").toString())); // 문자열을
		replyVO.setPrr_score(Integer.parseInt(paramMap.get("prr").toString())); // 숫자로
		replyVO.setDurablity_score(Integer.parseInt(paramMap.get("durability").toString()));
		
		replyService.insertReply(replyVO);
		// System.out.println(replyVO);
		//
	}



	@RequestMapping(value = "/replyListJson.do", produces = "application/x-www-form-urlencoded; charset=UTF-8")
	public String replyListJson(@RequestParam("writing_no") int writing_no) {//
		System.out.println("  ReplyController      에서            replyListJson()");
		List<ReplyVO> replyList = replyService.listReply(writing_no);
		System.out.println("  replyList 확인해라  " + replyList.get(0));

		// return "writingDetail.do?w_no="+ Integer.toString(writing_no); //
		// referwriting.jsp로 포워딩

		String json = "";
		ObjectMapper mapper = new ObjectMapper();
		// ObjectMapper : porm.xml에 jackson (json관한 라이브러리) 선언후 사용 가능

		try {
			json = mapper.writeValueAsString(replyList);
		} catch (JsonProcessingException e) {
			log.debug("json1 exception !");
			e.printStackTrace();
		}
		return json;
		// referWriting.jsp가서 자바스크립트 부분에 json이란 이름으로 보냄, 거기 찾아보면 함수에서 json으로
		// 매개변수를 받음
	}

	@RequestMapping("/deleteReply.action")
	public String deleteReply(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		System.out.println("    ReplyController     deleteReply    ");
		
		String reply_no = httpServletRequest.getParameter("reply_no");
		// @RequestParam 으로 안받아와져서 HttpServleRequest로 받음
		
		System.out.println(" 받아온 댓글 번호  " + reply_no);
		
		replyService.deleteReply(Integer.parseInt(reply_no));
		return "String";
	}

}