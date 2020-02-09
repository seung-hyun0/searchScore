package com.java.self.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.CommandAction;
import com.java.member.dao.MemberDao;
import com.java.member.dto.ZipcodeDto;

public class zipCodeSchool implements CommandAction{

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String checkAd = request.getParameter("dong");
		logger.info(logMsg +"검색한 동: "+ checkAd);
		
		if(checkAd != null) {
			ArrayList<ZipcodeDto> zipcodeList = MemberDao.getInstance().zipcodeRead(checkAd);
			
			logger.info(logMsg +"검색한 동의 갯수: "+ zipcodeList.size());
			
			request.setAttribute("zipcodeList", zipcodeList);
		}
		
		return "/WEB-INF/view/member/zipcode.jsp";
	}

}
