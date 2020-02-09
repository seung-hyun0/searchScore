package com.java.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil {
	
	
	public static void close(Connection conn) {	// connection 연결을 끊어주는 메소드
		if(conn != null) {	
			try {
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	public static void close(PreparedStatement pstmt) {	// PrepatedStatement 연결을 끊어주는 메소드
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	public static void close(ResultSet rs) {	// ResultSet 연결을 끊어주는 메소드
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	public static void rollBack(Connection conn) {
		if(conn != null) {
			try {
				conn.rollback();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
