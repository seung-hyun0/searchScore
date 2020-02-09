package com.java.self.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.CommandAction;
import com.java.member.dao.MemberDao;
import com.java.member.dto.MemberDto;

public class registerOkSchool implements CommandAction{

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		
		MemberDto memberDto = new MemberDto();
		memberDto.setId(request.getParameter("id"));
		memberDto.setPwd(request.getParameter("pwd"));
		memberDto.setName(request.getParameter("name"));
		
		memberDto.setStu_number(request.getParameter("stu_number"));
		memberDto.setZipcode(request.getParameter("zipcode"));
		memberDto.setAddress(request.getParameter("address"));
		memberDto.setJob(request.getParameter("job"));
		
		logger.info(logMsg+ "회원가입 정보: " + memberDto.toString());
		
		int check = MemberDao.getInstance().insert(memberDto);
		logger.info(logMsg + "check: " +check);
		
		request.setAttribute("check", check);
		
		return "/WEB-INF/view/member/registerOk.jsp";
	}	
}
