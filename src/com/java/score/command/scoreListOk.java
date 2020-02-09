package com.java.score.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.CommandAction;
import com.java.score.dao.ScoreDao;
import com.java.score.dto.ScoreDto;

public class scoreListOk implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String checkName = request.getParameter("name");
		String checkStu_num = request.getParameter("stu_number");
		logger.info(logMsg +"검색한 이름: "+ checkName + " \t\t" +"검색한 학번 : " + checkStu_num);
		
		if(checkName != null) {
			ArrayList<ScoreDto> NameList = ScoreDao.getInstance().nameReader(checkName, checkStu_num);
			//logger.info(logMsg +"해당 이름의 데이터 갯수: "+ NameList.size());
			logger.info(logMsg+"리스트 : "+ NameList.toString());
			request.setAttribute("NameList", NameList);

		}
		return "/WEB-INF/view/score/scoreListOk.jsp";
	}

}
