package com.java.self.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.command.CommandAction;

public class mainPage implements CommandAction{

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		HttpSession session = request.getSession();
		if(!session.isNew()) {	// 세션이 새로 만들어 진게 아니면
			logger.info(logMsg + "session에 존재하는 아이디 값: "+ (String) session.getAttribute("id"));
		}
		
		return "/WEB-INF/view/member/main.jsp";
	}
	

}
