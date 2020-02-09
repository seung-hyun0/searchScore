package com.java.fileQnA.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.CommandAction;
import com.java.fileQnA.dao.fileQnADao;
import com.java.fileQnA.dto.fileQnADto;

public class qnaRead implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		int board_number = Integer.parseInt(request.getParameter("board_number"));
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		logger.info(logMsg + "게시글 번호: " + board_number +"\t" + "페이지 번호: " + pageNumber);
		
		fileQnADto qnaDto = fileQnADao.getInstance().readqna(board_number);
		logger.info(logMsg + qnaDto.toString());
		
		if(qnaDto.getFile_name() != null) {
			int index = qnaDto.getFile_name().indexOf("_")+1;
			qnaDto.setFile_name(qnaDto.getFile_name().substring(index));
		}
			logger.info(logMsg + "파일명만 : " + qnaDto.toString());
			
			request.setAttribute("pageNumber", pageNumber);
			request.setAttribute("qnaDto", qnaDto);
		
		
		return "/WEB-INF/view/qna/read.jsp";
	}

}
