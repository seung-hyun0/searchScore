package com.java.score.command;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.java.command.CommandAction;
import com.java.score.dao.ScoreDao;
import com.java.score.dto.ScoreDto;

public class insertScoreOkAction implements CommandAction{

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		
		ScoreDto scoreDto = new ScoreDto();
		
		scoreDto.setName(request.getParameter("name"));
		scoreDto.setStu_number(request.getParameter("stu_number"));
		scoreDto.setYear(request.getParameter("year"));
		scoreDto.setSemester(request.getParameter("semester"));
		scoreDto.setEnglish(Integer.parseInt(request.getParameter("english")));
		scoreDto.setMath(Integer.parseInt(request.getParameter("math")));
		scoreDto.setSocial(Integer.parseInt(request.getParameter("social")));
		scoreDto.setWrite_date(new Date());
		

		logger.info(logMsg +"작성한 정보: "+ scoreDto.toString());

	   int check = ScoreDao.getInstance().insert(scoreDto);
	    logger.info(logMsg +"check: "+ check);
		request.setAttribute("check", check);
		
		return "/WEB-INF/view/score/InsertScoreOk.jsp";
	}

	
}
