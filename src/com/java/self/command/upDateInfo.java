package com.java.self.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.command.CommandAction;
import com.java.member.dao.MemberDao;
import com.java.member.dto.MemberDto;

public class upDateInfo implements CommandAction{

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		logger.info(logMsg + "id: " + id);
		
		MemberDto memberDto = MemberDao.getInstance().update(id);	
		logger.info(logMsg+ "해당 아이디를 가진 사람의 정보:" + memberDto.toString());	
		
		request.setAttribute("memberDto", memberDto);	
		return "/WEB-INF/view/member/update.jsp";
	}
}
