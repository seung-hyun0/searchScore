package com.java.self.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.CommandAction;
import com.java.member.dao.MemberDao;
import com.java.member.dto.MemberDto;

public class upDateInfoOk implements CommandAction{

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		MemberDto memberDto = new MemberDto();
		
		memberDto.setNum(Integer.parseInt(request.getParameter("num")));
		memberDto.setId(request.getParameter("id"));
		memberDto.setPwd(request.getParameter("pwd"));
		memberDto.setName(request.getParameter("name"));
		memberDto.setStu_number(request.getParameter("stu_number"));
		memberDto.setZipcode(request.getParameter("zipcode"));
		memberDto.setAddress(request.getParameter("address"));
		memberDto.setJob(request.getParameter("job"));
		
		logger.info(logMsg +"수정된 정보: " + memberDto.toString());
		
		int check = MemberDao.getInstance().updateOk(memberDto);
		logger.info(logMsg +"제대로 수정이 되었으면 1, 아니면 0 :"+ check);
		
		request.setAttribute("check", check);
		return "/WEB-INF/view/member/updateOk.jsp";
	}

}
