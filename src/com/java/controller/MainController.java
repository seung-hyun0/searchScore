package com.java.controller;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.CommandAction;

public class MainController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private final Logger logger = Logger.getLogger(MainController.class.getName()); 
	private final String logMsg = "Main logMsg───────────────";
	private HashMap<String, Object> commandMap = new HashMap<String, Object>();
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		String configFile = config.getInitParameter("configFile");	//web.xml에 지정한 파라미터 값을 받아옴
		logger.info(logMsg + "properties: " + configFile);	//param-value값인 \WEB-INF\selfURI.properties
		
		// properties의 실제 경로를 가져오는 방법
		String path = config.getServletContext().getRealPath(configFile);
		logger.info(logMsg + "real Path: " + path);
		
		// 파일 입출력
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		Properties pro = new Properties();
		
		try {
			fis = new FileInputStream(path);
			bis = new BufferedInputStream(fis);
			pro.load(bis);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			try {
			if(bis != null) bis.close();
			if(fis != null) fis.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		Iterator<Object> keyIter = pro.keySet().iterator();
		while(keyIter.hasNext()) {
			String key = (String)keyIter.next();
			String value = pro.getProperty(key);
			logger.info(logMsg + "key: " + key + "\t" + "value: " + value);
			
			try {
				Class<?>handlerClass = Class.forName(value);
				Object handlerInstance = handlerClass.getDeclaredConstructor().newInstance();
				
				commandMap.put(key, handlerInstance);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	
	public MainController() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cmd = request.getRequestURI();
		cmd = cmd.substring(request.getContextPath().length());
		
		logger.info(logMsg + "cmd: " + cmd);
		String view = null;
		
		
		try {
			CommandAction command = (CommandAction) commandMap.get(cmd);
			view = command.proRequest(request,response);
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} if(view != null) {
			RequestDispatcher rd= request.getRequestDispatcher(view);
			rd.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
