package com.project.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.myapp.service.WritingDAOService;

@Controller
public class TruncateAllController {
	
	@Autowired
	private WritingDAOService writingDaoService;
	
	@RequestMapping("/truncateAll")
	String truncateAll()
	{
		System.out.println("   TruncateAll       writingDaoService()");
	writingDaoService.truncateAll();	
		return "redirect:/";
	}
}
