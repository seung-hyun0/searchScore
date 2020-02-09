package com.java.score.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.java.db.ConnectionProvider;
import com.java.db.JdbcUtil;
import com.java.member.dto.MemberDto;
import com.java.score.dto.ScoreDto;

public class ScoreDao {

	private static ScoreDao instance = new ScoreDao();
	
	public static ScoreDao getInstance() {
		return instance;
	}
	public ScoreDao() {	}
	
	/*
	 * public ScoreDto insertScore(String id) { // TODO Auto-generated method stub
	 * 
	 * Connection conn = null; PreparedStatement pstmt = null; // 쿼리문 ResultSet rs =
	 * null; // 결과값 ScoreDto scoreDto = null;
	 * 
	 * try { String sql = "SELECT * FROM member WHERE id=?";
	 * 
	 * conn = ConnectionProvider.getConnection(); pstmt =
	 * conn.prepareStatement(sql); pstmt.setString(1, id); rs =
	 * pstmt.executeQuery();
	 * 
	 * if(rs.next()) { scoreDto = new ScoreDto();
	 * scoreDto.setScore_num(rs.getInt("score_num"));
	 * scoreDto.setName(rs.getString("name"));
	 * scoreDto.setStu_number(rs.getString("stu_number"));
	 * scoreDto.setYear(rs.getString("year"));
	 * scoreDto.setSemester(rs.getString("semester"));
	 * scoreDto.setEnglish(rs.getString("english"));
	 * scoreDto.setMath(rs.getString("math"));
	 * scoreDto.setSocial(rs.getString("social")); scoreDto.setWrite_date(new
	 * Date(rs.getTimestamp("write_date").getTime()));
	 * scoreDto.setName(rs.getString("name"));
	 * 
	 * 
	 * }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * 
	 * return scoreDto; }
	 */
	public int insert(ScoreDto scoreDto) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		int value = 0;
		
		try {
			String sql = "INSERT INTO score(score_num, name, stu_number, year, semester, english, math, social, write_date) VALUES(score_num_seq.nextval,?,?,?,?,?,?,?,?)";
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, scoreDto.getName());
			pstmt.setString(2, scoreDto.getStu_number());
			pstmt.setString(3, scoreDto.getYear());
			pstmt.setString(4, scoreDto.getSemester());
			pstmt.setInt(5, scoreDto.getEnglish());
			pstmt.setInt(6, scoreDto.getMath());
			pstmt.setInt(7, scoreDto.getSocial());
			pstmt.setTimestamp(8, new Timestamp(scoreDto.getWrite_date().getTime()));
			
			
			value = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		return value;
	}
	public ArrayList<ScoreDto> nameReader(String checkName, String checkStu_number) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ScoreDto> NameList = null;
		
		try {
			
			String sql = "SELECT * FROM score WHERE name=? and stu_number=? order by score_num desc";
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, checkName);
			pstmt.setString(2, checkStu_number);
			
			rs = pstmt.executeQuery();
			
			NameList = new ArrayList<ScoreDto>();
			
			while(rs.next()) {
				ScoreDto scoreDto = new ScoreDto();
				scoreDto.setScore_num(rs.getInt("score_num"));
				scoreDto.setName(rs.getString("name"));
				scoreDto.setStu_number(rs.getString("stu_number"));
				scoreDto.setYear(rs.getString("year"));
				scoreDto.setSemester(rs.getString("semester"));
				scoreDto.setEnglish(rs.getInt("english"));
				scoreDto.setMath(rs.getInt("math"));
				scoreDto.setSocial(rs.getInt("social"));
				scoreDto.setWrite_date(rs.getDate("write_date"));
				scoreDto.setAvg((rs.getInt("english")+rs.getInt("math")+rs.getInt("social"))/3);
				scoreDto.setSum(rs.getInt("english")+rs.getInt("math")+rs.getInt("social"));
				
				NameList.add(scoreDto);
			}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		return NameList;
	}
	public ScoreDto updateScore(int score_num) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ScoreDto scoreDto = null;
		
		try {
			
			String sql = "SELECT * FROM score WHERE score_num=?";
			
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, score_num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				scoreDto = new ScoreDto();
				scoreDto.setScore_num(rs.getInt("score_num"));
				scoreDto.setName(rs.getString("name"));
				scoreDto.setStu_number(rs.getString("stu_number"));
				scoreDto.setYear(rs.getString("year"));
				scoreDto.setSemester(rs.getString("semester"));
				scoreDto.setEnglish(rs.getInt("english"));
				scoreDto.setMath(rs.getInt("math"));
				scoreDto.setSocial(rs.getInt("social"));
				scoreDto.setWrite_date(rs.getDate("write_date"));
				scoreDto.setAvg((rs.getInt("english")+rs.getInt("math")+rs.getInt("social"))/3);
				scoreDto.setSum(rs.getInt("english")+rs.getInt("math")+rs.getInt("social"));
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return scoreDto;
	}
	public int updateScoreOk(ScoreDto scoreDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int check=0;
		
		try {
			
			String sql = "UPDATE score SET year=?,semester=?,english=?,math=?,social=?,write_date=? WHERE score_num=?";
			
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, scoreDto.getYear());
			pstmt.setString(2, scoreDto.getSemester());
			pstmt.setInt(3, scoreDto.getEnglish());
			pstmt.setInt(4, scoreDto.getMath());
			pstmt.setInt(5, scoreDto.getSocial());
			pstmt.setTimestamp(6, new Timestamp(scoreDto.getWrite_date().getTime()));
			pstmt.setInt(7, scoreDto.getScore_num());
			
			check = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			/*
			 * JdbcUtil.close(pstmt); JdbcUtil.close(conn);
			 */
		}
		return check;
	}
	public ScoreDto myScore(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;	// 쿼리문
		ResultSet rs = null;
		ScoreDto scoreDto = null;
		
		try {
			String sql = "SELECT * FROM score WHERE id=?";
			
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				scoreDto = new ScoreDto();
				
				scoreDto.setScore_num(rs.getInt("score_num"));
				scoreDto.setName(rs.getString("name"));
				scoreDto.setStu_number(rs.getString("stu_number"));
				scoreDto.setYear(rs.getString("year"));
				scoreDto.setSemester(rs.getString("semester"));
				scoreDto.setEnglish(rs.getInt("english"));
				scoreDto.setMath(rs.getInt("math"));
				scoreDto.setSocial(rs.getInt("social"));
				scoreDto.setWrite_date(rs.getDate("write_date"));
				scoreDto.setAvg((rs.getInt("english")+rs.getInt("math")+rs.getInt("social"))/3.0);
				scoreDto.setSum(rs.getInt("english")+rs.getInt("math")+rs.getInt("social"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return scoreDto;
	}
	public ArrayList<ScoreDto> myReader(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ScoreDto> myList = null;
		
		try {
			
			String sql = "SELECT b.*  FROM member a JOIN score b ON a.stu_number=b.stu_number and a.id=? order by score_num desc";
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			  pstmt.setString(1, id);
			 
			
			rs = pstmt.executeQuery();
			
			
			myList = new ArrayList<ScoreDto>();
			
			while(rs.next()) {
				
				ScoreDto scoreDto = new ScoreDto();
				
				scoreDto.setScore_num(rs.getInt("score_num"));
				scoreDto.setName(rs.getString("name"));
				scoreDto.setStu_number(rs.getString("stu_number"));
				scoreDto.setYear(rs.getString("year"));
				scoreDto.setSemester(rs.getString("semester"));
				scoreDto.setEnglish(rs.getInt("english"));
				scoreDto.setMath(rs.getInt("math"));
				scoreDto.setSocial(rs.getInt("social"));
				scoreDto.setWrite_date(rs.getDate("write_date"));
				scoreDto.setAvg((rs.getInt("english")+rs.getInt("math")+rs.getInt("social"))/3.0);
				scoreDto.setSum(rs.getInt("english")+rs.getInt("math")+rs.getInt("social"));
				
				myList.add(scoreDto);
			}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		return myList;
	}

}
