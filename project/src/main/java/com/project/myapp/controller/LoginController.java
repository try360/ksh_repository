package com.project.myapp.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.myapp.VO.LoginVO;
import com.project.myapp.VO.MemberVO;
import com.project.myapp.service.LoginService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j // 로그써주는 어노 lombok 받아서 써주는거
@RequestMapping("/user") // 맨 위에 경로 /user
public class LoginController {
	@Inject
	private LoginService loginService;

	@RequestMapping(value = "/login", method = {RequestMethod.POST,RequestMethod.GET})
	public void loginGET(@ModelAttribute("dto") LoginVO loginVO) {
		// @ModelAttribute 로 jsp 에서 보낸 값들을 "dto" 란 이름으로 한꺼번에 받음
		System.out.println("      LoginController   loginGET ()     ");
	}

	@RequestMapping(value = "/loginCheck", method = {RequestMethod.POST,RequestMethod.GET})
	//@ResponseBody 
	public String loginPOST(@ModelAttribute("dto") LoginVO loginVO, HttpSession session, Model model) {
		// @ModelAttribute 로 jsp 에서 보낸 값들을 "dto" 란 이름으로 한꺼번에 받음
		System.out.println("               LoginController loginPOST()              ");
		MemberVO memberVO = loginService.login(loginVO);

		if (memberVO == null) {
			System.out.println("        null         ");
			return "main";
		} else {
			System.out.println("     인증성공    ");
			//session.setAttribute("login",memberVO);
			model.addAttribute("memberVO", memberVO);
			
		}
		System.out.println("    return전       LoginController   loginPOST()              ");
		return "loginSuccess";
		//return loginVO.toString();
	}

	@RequestMapping("/loginSuccess")
	public String loginSuccess(HttpSession session) {
		System.out.println(  "##   session check :       " + session.getAttribute("login")   );
		return "loginSuccess";
	}

}
