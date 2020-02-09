package com.java.db;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class DBCPInit extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		
		try {
			
			String jdbcDriver = config.getInitParameter("jdbcDriver");
			Class.forName(jdbcDriver);	//jdbcDriver클래스의 정보를 담은 Class 클래스의 인스턴스를 얻어옴
			
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
	}
}
