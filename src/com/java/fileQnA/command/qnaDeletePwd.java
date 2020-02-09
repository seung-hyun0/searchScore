package com.java.fileQnA.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.command.CommandAction;
import com.java.fileQnA.dao.fileQnADao;

public class qnaDeletePwd implements CommandAction{

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession(); 
		 int board_number = (int) session.getAttribute("board_number"); 
	
		String pageNumber = (String)session.getAttribute("pageNumber");
		/* String qnaDto = (String) session.getAttribute("qnaDto"); */
		
		String password = request.getParameter("password");
		
		String name = fileQnADao.getInstance().checkdel(password,board_number);
		
		
		logger.info(logMsg + "pwd: "+password +"  board_number: "+ board_number + "  name: "+ name);
		request.setAttribute("password", password);
		request.setAttribute("name", name);
		request.setAttribute("board_number", board_number);
		request.setAttribute("pageNumber", pageNumber);
		
		if(name != null) {
			int del = fileQnADao.getInstance().delete(password,board_number);
			if(del != 0) {
			
			request.setAttribute("del", del);
			/* logger.info(logMsg + id + password + board_number); */
			}
		}else {
			return"/WEB-INF/view/qna/pwdFalse.jsp";
		}
		return "/WEB-INF/view/qna/deleteOk.jsp";
	}

}
