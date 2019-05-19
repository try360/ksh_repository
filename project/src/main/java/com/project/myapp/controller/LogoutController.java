package com.project.myapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutController {
@RequestMapping("/logout")
public String logout(HttpServletRequest request, HttpServletResponse response,  HttpSession session)
{
	System.out.println("   LogoutController   logout()    ");
	session.invalidate();
	System.out.println("       로그아웃 성공             ");
	return "redirect:/";
	
}
	
}
