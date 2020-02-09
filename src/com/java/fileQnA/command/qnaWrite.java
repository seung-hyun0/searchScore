package com.java.fileQnA.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.command.CommandAction;
import com.java.score.dao.ScoreDao;
import com.java.score.dto.ScoreDto;

public class qnaWrite implements CommandAction{

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		int board_number = 0;
		int group_number = 1;
		int sequence_number = 0;
		int sequence_level = 0;
		
		/*
		 * HttpSession session = request.getSession(); String id =
		 * (String)session.getAttribute("id");
		 * 
		 * logger.info(logMsg +"id: "+ id);
		 * 
		 * request.setAttribute("id", id);
		 */
		
		if(request.getParameter("board_number") != null) {
			// 답글이면
			board_number = Integer.parseInt(request.getParameter("board_number"));
			group_number=Integer.parseInt(request.getParameter("group_number"));
			sequence_number=Integer.parseInt(request.getParameter("sequence_level"));
			sequence_level=Integer.parseInt(request.getParameter("sequence_level"));
		}
		
		request.setAttribute("board_number", board_number);
		request.setAttribute("group_number", group_number);
		request.setAttribute("sequence_number", sequence_number);
		request.setAttribute("sequence_level", sequence_level);
		
		
		return "/WEB-INF/view/qna/write.jsp";
	}

}
