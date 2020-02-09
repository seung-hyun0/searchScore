package com.java.fileQnA.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.CommandAction;
import com.java.fileQnA.dao.fileQnADao;
import com.java.fileQnA.dto.fileQnADto;

public class qnaDelete implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		int board_number = Integer.parseInt(request.getParameter("board_number"));
		int pageNumber=Integer.parseInt(request.getParameter("pageNumber"));
		
		
		logger.info(logMsg + board_number + "번째 게시글, " + "\t" + "페이지 번호: " + pageNumber);
		
		fileQnADto qnaDto = fileQnADao.getInstance().update(board_number);
		
		////////11-06/////////////
		if (qnaDto.getFile_name()!=null) {
			int index = qnaDto.getFile_name().indexOf("_")+1;
			qnaDto.setFile_name(qnaDto.getFile_name().substring(index));
		}
		/////////11-06///////////
		
		
		logger.info(logMsg + "선택된 게시글의 내용: "+ qnaDto.toString());
	
		request.setAttribute("qnaDto", qnaDto);
		request.setAttribute("board_number", board_number);
		request.setAttribute("pageNumber", pageNumber);
		
		return "/WEB-INF/view/qna/delete.jsp";
	}

}
