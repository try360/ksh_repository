package com.practice.PostgreSQL.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.practice.PostgreSQL.VO.BoardVO;
import com.practice.PostgreSQL.service.BoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/insert")
public class WriteController {

	private static final Logger logger = LoggerFactory.getLogger(WriteController.class);

	@Inject
	BoardService boardService;
	
	@RequestMapping(value = "/write")
	public String write() {
		logger.info("글쓰러갑니다.");

		return "insertBoard";
	}

// hashmap으로 전달 받아서 찍어보는 controller
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String regist(Locale locale
			, Model model
			,@ModelAttribute BoardVO boardVO
			,@RequestParam HashMap<String, Object> paramMap) throws Exception {
	logger.info(" 넘어온 데이터 값 찍어보자    :  " + paramMap);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		
		boardService.reg_board(boardVO);

		return "home";
	}

}
