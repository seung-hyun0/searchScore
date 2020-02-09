package com.java.score.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.command.CommandAction;
import com.java.score.dao.ScoreDao;
import com.java.score.dto.ScoreDto;

public class insertScoreAction implements CommandAction{

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		int score_number = 0;
		
		if(request.getParameter("score_number") != null) {
			score_number = Integer.parseInt(request.getParameter("score_number"));
		}
		
		request.setAttribute("score_number", score_number);
		
		return "/WEB-INF/view/score/insertScore.jsp";
	}

}
