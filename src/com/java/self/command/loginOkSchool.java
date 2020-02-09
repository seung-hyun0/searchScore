package com.java.self.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.CommandAction;
import com.java.member.dao.MemberDao;

public class loginOkSchool implements CommandAction{

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		logger.info(logMsg + "입력한 id: " + id + "\t\t" + "입력한 pwd: " + pwd);
		
		String stu_number = MemberDao.getInstance().login(id,pwd);	//MemberDao의 login메소드에 id와 pwd에 맞는 stu_number값이 리턴되어 stu_number에 저장
		logger.info(logMsg +"학번 (회원이 아닐경우 null값): "+ stu_number);
		
		if(stu_number != null) {	//stu_number에 값이 있는 경우, 즉 기존 회원인 경우
			request.setAttribute("stu_number", stu_number);	//String stu_number에 stu_number의 값(준회원 BA)을 넣어준다 
			request.setAttribute("id", id);
		}
		
		return "/WEB-INF/view/member/loginOk.jsp";
	}

}
