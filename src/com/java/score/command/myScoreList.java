package com.java.score.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.command.CommandAction;
import com.java.score.dao.ScoreDao;
import com.java.score.dto.ScoreDto;

public class myScoreList implements CommandAction{

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id"); 

		logger.info(logMsg +"id: "+ id);
		/*
		 * ScoreDto scoreDto = ScoreDao.getInstance().myScore(id); logger.info(logMsg+
		 * "해당 아이디를 가진 사람의 정보:" + scoreDto.toString());
		 */
		
		if(id != null) {
			ArrayList<ScoreDto> myList = ScoreDao.getInstance().myReader(id);
			logger.info(logMsg + "myList: " + myList.toString());
			request.setAttribute("myList", myList);
		}
		request.setAttribute("id", id);
		//request.setAttribute("scoreDto", scoreDto);
		return "/WEB-INF/view/score/myScore.jsp";
	}
	
}
