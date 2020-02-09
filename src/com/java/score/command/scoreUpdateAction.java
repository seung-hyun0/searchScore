package com.java.score.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.command.CommandAction;
import com.java.score.dao.ScoreDao;
import com.java.score.dto.ScoreDto;

public class scoreUpdateAction implements CommandAction{

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		/*
		 * HttpSession session = request.getSession(); String score_num =
		 * (String)session.getAttribute("score_num");
		 */
		
		  int score_num = Integer.parseInt(request.getParameter("score_num")); 
		  String name = request.getParameter("name");
		 
		
		logger.info(logMsg +"선택한 입력번호: " + score_num);
		
		ScoreDto scoreDto = ScoreDao.getInstance().updateScore(score_num);
		
		logger.info(logMsg + "선택된 사람의 성적 내용: "+ scoreDto.toString());
		
		/* request.setAttribute("score_num", score_num); */
		request.setAttribute("scoreDto", scoreDto);
		
		
		return "/WEB-INF/view/score/scoreUpdate.jsp";
	}


}
