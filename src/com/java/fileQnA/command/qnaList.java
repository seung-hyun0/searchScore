package com.java.fileQnA.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.command.CommandAction;
import com.java.fileQnA.dao.fileQnADao;
import com.java.fileQnA.dto.fileQnADto;

public class qnaList implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		logger.info(logMsg + "session id: " + id);
		
		String pageNumber = request.getParameter("pageNumber");
		
		if(pageNumber == null) {
			pageNumber="1";
		}
		int currentPage = Integer.parseInt(pageNumber);
		logger.info(logMsg + "요청페이지: " + currentPage);

		int count = fileQnADao.getInstance().getCount();
		logger.info(logMsg +"총 게시글 갯수: "+ count);
		
		int boardSize = 10;
		int startRow = (currentPage-1)*boardSize+1;
		int endRow = currentPage * boardSize;
		
		ArrayList<fileQnADto> qnaList = null;
		
		if(count > 0) {
			qnaList = fileQnADao.getInstance().getQnaList(startRow,endRow);
			logger.info(logMsg + "이 페이지의 Q&A 갯수: " + qnaList.size());
		}
		
		request.setAttribute("boardSize", boardSize);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("count", count);
		request.setAttribute("qnaList", qnaList);
		request.setAttribute("id", id);
		
		return "/WEB-INF/view/qna/list.jsp";
	}

}
