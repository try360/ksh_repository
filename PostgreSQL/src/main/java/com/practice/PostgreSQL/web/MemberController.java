package com.practice.PostgreSQL.web;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practice.PostgreSQL.VO.MemberVO;
import com.practice.PostgreSQL.service.MemberService;

@Controller
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	MemberService memberService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("/")
	public String login(Locale locale, Model model) {

		return "login";
	}

	@RequestMapping("sign_up")
	public String sign_up(Model model) {
		return "sign_up";
	}

	@RequestMapping("sign_up.do")
	public String sign_up_do(Model model, @ModelAttribute MemberVO memberVO) throws Exception {

		memberService.sign_up_member(memberVO);

		return "login";
	}

}
