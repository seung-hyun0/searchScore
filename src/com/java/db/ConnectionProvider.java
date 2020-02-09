package com.java.db;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionProvider {
	
	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			//서버 컨텍스트 객체 발생
			Context initContext = new InitialContext();
			
			// 리소스 (태그)가져온다
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			
			// 리소스 안에 있는 java/mvcDB
			DataSource ds = (DataSource)envContext.lookup("jdbc/selfDB");
		    conn=ds.getConnection();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
}
