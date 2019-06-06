package com.practice.PostgreSQL.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practice.PostgreSQL.VO.BoardVO;
import com.practice.PostgreSQL.service.BoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/")
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	BoardService boardService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws Exception 
	 */
	@RequestMapping("list_board")
	public String list_board(@ModelAttribute BoardVO boardVO,
			Locale locale, Model model) throws Exception {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		model.addAttribute("board_list", boardService.selectAll_BoardList(boardVO));

		
		return "home";
	}
	
	@RequestMapping("truncate_board_list")
	public String truncate_board_list() throws Exception {
		
		boardService.truncate_board_list();
		
		return "redirect:/list_board";
	}
	
	
}
