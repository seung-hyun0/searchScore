package com.java.self.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.java.command.CommandAction;


public class registerSchool implements CommandAction{
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) {
		/* logger.info(LogMsg); */
		
		
		return "/WEB-INF/view/member/register.jsp";
	}

}
