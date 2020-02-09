package com.java.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.java.db.ConnectionProvider;
import com.java.db.JdbcUtil;
import com.java.member.dto.MemberDto;
import com.java.member.dto.ZipcodeDto;

public class MemberDao {

	private static MemberDao instance = new MemberDao();	
	public static MemberDao getInstance(){		
		return instance;
	}
	
	private MemberDao() { }
	
	public int insert(MemberDto memberDto) {	//학교 회원가입
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int check = 0;
		
		try {
			String sql = "INSERT INTO member VALUES(memberSchool_num_seq.nextval, ?,?,?,?,?,?,?)";
			
			conn = ConnectionProvider.getConnection();	//db연결
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberDto.getId());
			pstmt.setString(2, memberDto.getPwd());
			pstmt.setString(3, memberDto.getName());
			pstmt.setString(4, memberDto.getStu_number());
			pstmt.setString(5, memberDto.getZipcode());
			pstmt.setString(6, memberDto.getAddress());
			pstmt.setString(7, memberDto.getJob());
			
			check = pstmt.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		return check;
	}

	public int idCheck(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int check=0;
		
		try {
			String sql = "SELECT id FROM member WHERE id=?";
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs= pstmt.executeQuery();	
			if(rs.next())  check=1;	
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return check;	//check를 반환해주어 쿼리에 해당하는 값이 있는지 없는지 판단
	}

	public ArrayList<ZipcodeDto> zipcodeRead(String checkAd) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ZipcodeDto> valueList = null;	
		
		
		try {
			String sql = "SELECT * FROM zipcode WHERE dong=?";
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, checkAd);
			
			rs= pstmt.executeQuery();
			valueList = new ArrayList<ZipcodeDto>();	// List 생성
			
			while(rs.next())  {
				ZipcodeDto address = new ZipcodeDto();	//address라는 이름으로 ZipcodeDto 객체생성
				address.setZipcode(rs.getString("zipcode")); //address에 Zipcode는 rs의 zipcode값 저장 (쿼리를 통해 나온 값들 중 zipcode)
				address.setSido(rs.getString("sido"));
				address.setGugun(rs.getString("gugun"));
				address.setDong(rs.getString("dong"));
				address.setRi(rs.getString("ri"));
				address.setBunji(rs.getString("bunji"));
				
				valueList.add(address);	// 쿼리에 맞는 값들(address에 저장된 값)을 valueList에 저장
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		return valueList;
	}

	public String login(String id, String pwd) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String value=null;
		
		try {
			
			String sql = "SELECT stu_number FROM member WHERE id=? and pwd=?";
			
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs= pstmt.executeQuery(); //sql쿼리에 맞는 값들 rs에 저장
			
			if(rs.next())  value=rs.getString("stu_number");	//rs에 값이 존재할 경우 DB에서 해당 아이디와 비번을 가진 사람의  stu_number에 저장된 값을 value에 넣는다
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
			
		}
		
		return value;	//DB의 stu_number값을 리턴
	}

	public MemberDto update(String id) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;	
		ResultSet rs = null;	
		MemberDto memberDto = null;
		
		try {
			String sql = "SELECT * FROM member WHERE id=?";
			
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				memberDto = new MemberDto();
				memberDto.setNum(rs.getInt("num"));
				memberDto.setId(rs.getString("id"));
				memberDto.setPwd(rs.getString("pwd"));
				memberDto.setName(rs.getString("name"));
				memberDto.setStu_number(rs.getString("stu_number"));
				memberDto.setZipcode(rs.getString("zipcode"));
				memberDto.setAddress(rs.getString("address"));
				memberDto.setJob(rs.getString("job"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
		
		}
		return memberDto;
	}

	public int updateOk(MemberDto memberDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;	
		int check =0;
		
		try {
			String sql = "UPDATE member SET pwd=?, zipcode=?, address=?, job=? WHERE num=?";
			
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberDto.getPwd());
			pstmt.setString(2, memberDto.getZipcode());
			pstmt.setString(3, memberDto.getAddress());
			pstmt.setString(4, memberDto.getJob());
			pstmt.setInt(5, memberDto.getNum());
			
			check = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
		return check;
	}
}
