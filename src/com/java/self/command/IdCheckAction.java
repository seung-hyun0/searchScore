package com.java.self.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.CommandAction;
import com.java.member.dao.MemberDao;

public class IdCheckAction implements CommandAction{

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String id = request.getParameter("id");
		logger.info(logMsg + "입력한 id: " +id);
		
		int check = MemberDao.getInstance().idCheck(id);
		logger.info(logMsg + "기존에 있는 아이디면 1 / 아니면 0: " + check);
		
		request.setAttribute("check", check);
		request.setAttribute("id", id);
		
		return "/WEB-INF/view/member/idCheck.jsp";
	}



}
