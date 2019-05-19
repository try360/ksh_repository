package com.project.myapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	private static final String LOGIN = "login";
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("      인터셉터 PostHandle   시작         ");
		HttpSession session = request.getSession();
		ModelMap modelMap = modelAndView.getModelMap();
		Object memberVO = modelMap.get("memberVO");
		System.out.println( "  1. memberVO  :   " + memberVO.toString()  );
		if (memberVO != null) {
			System.out.println("       2.  LoginInterceptor  postHandle()    ♣♣♣♣  new login success ♣♣♣♣♣♣       ");
			
			session.setAttribute(LOGIN, memberVO);
			 // 세션 유지시간 1시간
		    session.setMaxInactiveInterval(60*60) ;
			
			System.out.println(" 3.세션 내용     :     " + session.getAttribute(LOGIN).toString() +" In LoginInterceptor  postHandle()  " );
			//response.sendRedirect(request.getContextPath());
			response.sendRedirect(request.getContextPath()+"/user/loginSuccess");
			// request.getContextPath() : 처음 경로로 들가게 함
		}
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
	System.out.println("       4.   인터셉터    prehanle 시작              ");
		HttpSession session = request.getSession();

		if (session.getAttribute(LOGIN) != null) {
			logger.info("  5. clear login data before  ");
			//session.removeAttribute(LOGIN);
			session.invalidate();
			System.out.println("       prehandle에서              세션 소멸 성공     ");
		}
		return true;
	}

}
