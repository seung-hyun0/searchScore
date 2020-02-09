package com.java.fileQnA.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.command.CommandAction;
import com.java.fileQnA.dao.fileQnADao;

public class qnaUpdatePwd implements CommandAction{

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		/*
		 * HttpSession session = request.getSession(); String id =
		 * (String)session.getAttribute("id");
		 */
		HttpSession session = request.getSession(); 
		 int board_number = (int) session.getAttribute("board_number"); 
	
		String pageNumber = (String)session.getAttribute("pageNumber");
		/* String qnaDto = (String) session.getAttribute("qnaDto"); */
		
		String password = request.getParameter("password");
		
		String name = fileQnADao.getInstance().checkpwd(password,board_number);
		logger.info(logMsg + password + board_number + name);
		
		if(name != null) {
			/* request.setAttribute("id", id); */
			request.setAttribute("password", password);
			request.setAttribute("board_number", board_number);
			/* logger.info(logMsg + id + password + board_number); */
		}else {
			return "/WEB-INF/view/qna/pwdFalse.jsp";
		}
		return "/WEB-INF/view/qna/update.jsp";
	}

}
