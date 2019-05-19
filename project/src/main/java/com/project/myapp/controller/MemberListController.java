package com.project.myapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.myapp.VO.MemberVO;
import com.project.myapp.service.MemberDAOService;

@Controller
public class MemberListController {

	
	@Autowired
	private MemberDAOService memberDaoService;
	
	
	@RequestMapping("/memberRegister.do") // 회원가입 서블릿 앱핑
	public String mebmerRegisterDo() {
		System.out.println("이 것은 MemberRegisterController에서 쓴 것");
		return "memberRegister";
	}

	/** * 회원가입 INSERT */
	@RequestMapping("/memberRegisterAction.do")
	public ModelAndView memberRegisterActionDo(HttpServletRequest req) {

		System.out.println("이 것은 memberRegisterAction.do에서 쓴 것");
		System.out.println("메인화면에서 가져온 것" + req.getParameter("id"));
		/*
		 * Map param = new HashMap(); param.put("title",
		 * req.getParameter("title")); param.put("contents",
		 * req.getParameter("contents"));
		 */
		MemberVO memberVO = new MemberVO();

		memberVO.setId(req.getParameter("id"));
		memberVO.setPassword(req.getParameter("password"));
		memberVO.setEmail(req.getParameter("email"));

		memberDaoService.insertMember(memberVO);
		ModelAndView mv = new ModelAndView("memberRegister");
		mv.setViewName("memberRegister");
		return mv;
	}
	
	
	// memberList 화면 및 회원 목록
	@RequestMapping("/memberList.do")
	public String memberList(Model model) {
		System.out.println("           MemberListController   memberList()        ");
		List<MemberVO> memberList = memberDaoService.getAllMembers();
		
		List<String> m_dateList = new ArrayList<>(); // JSP에서 날짜가 파싱이 안돼서 따로 날짜만
		for (int i = 0; i < memberList.size(); i++) {
			m_dateList.add(memberList.get(i).getMr_date());
		}
		model.addAttribute("memberList", memberList); // DB에 글을 보냄
        model.addAttribute("dateList", m_dateList);// 날짜를 main.jsp에 전송
		return "memberList";
	}
	
	
}
