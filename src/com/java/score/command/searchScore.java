package com.java.score.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.CommandAction;
import com.java.score.dao.ScoreDao;
import com.java.score.dto.ScoreDto;

public class searchScore implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		
		
		return "/WEB-INF/view/score/searchScore.jsp";
	}

}
