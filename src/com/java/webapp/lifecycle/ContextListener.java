package com.java.webapp.lifecycle;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @개발자: 정승현
 * @작성일: 2019. 11. 4.
 * @설명 :  web application 생명 주기(lifeCycle) 리스너의 해당 메소드가 웹 어플리케이션 시작과 종료를 호출한다.
 */
public class ContextListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("School Web End -------------");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("School Web Start -------------");
		
	}

}
