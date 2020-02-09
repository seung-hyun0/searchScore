package com.java.fileQnA.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;


import com.java.db.ConnectionProvider;
import com.java.db.JdbcUtil;
import com.java.fileQnA.dto.fileQnADto;

public class fileQnADao {
	private static fileQnADao instance = new fileQnADao();
	public static fileQnADao getInstance() {
		return instance;
	}
	
	private fileQnADao() {	}

	public int insert(fileQnADto qnaDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int value = 0;
		
		writeNumber(conn, qnaDto);
		
		try {
			// 파일 업로드 안하는 경우
			if(qnaDto.getFile_size()==0) {
				
				String sql = "INSERT INTO fileqna(board_number,name, stu_number, subject, content, password, write_date, read_count, group_number,sequence_number, sequence_level) values(fileqna_board_number.nextval, ?,?,?,?,?,?,?,?,?,?)";
				
				conn = ConnectionProvider.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, qnaDto.getName());
				pstmt.setInt(2, qnaDto.getStu_number());
				pstmt.setString(3, qnaDto.getSubject());
				pstmt.setString(4, qnaDto.getContent().replace("\r\n", "<br/>"));	//내용입력시 엔터가 적용되게 함
				pstmt.setString(5, qnaDto.getPassword());
				
				pstmt.setTimestamp(6, new Timestamp(qnaDto.getWrite_date().getTime()));
				pstmt.setInt(7, qnaDto.getRead_count());
				pstmt.setInt(8, qnaDto.getGroup_number());
				pstmt.setInt(9, qnaDto.getSequence_number());
				pstmt.setInt(10, qnaDto.getSequence_level());
			
			
			}else {
				
				String sql = "INSERT INTO fileqna(board_number,name, stu_number, subject, content, password, write_date, read_count, group_number,sequence_number, sequence_level, file_name,path,file_size) values(fileqna_board_number.nextval, ?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
				
				conn = ConnectionProvider.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, qnaDto.getName());
				pstmt.setInt(2, qnaDto.getStu_number());
				pstmt.setString(3, qnaDto.getSubject());
				pstmt.setString(4, qnaDto.getContent().replace("\r\n", "<br/>"));	//내용입력시 엔터가 적용되게 함
				pstmt.setString(5, qnaDto.getPassword());
				
				pstmt.setTimestamp(6, new Timestamp(qnaDto.getWrite_date().getTime()));
				pstmt.setInt(7, qnaDto.getRead_count());
				pstmt.setInt(8, qnaDto.getGroup_number());
				pstmt.setInt(9, qnaDto.getSequence_number());
				pstmt.setInt(10, qnaDto.getSequence_level());
				
				pstmt.setString(11, qnaDto.getFile_name());
				pstmt.setString(12, qnaDto.getPath());
				pstmt.setLong(13, qnaDto.getFile_size());
				
			}
			value = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			
		}
		return value;
	}

	private void writeNumber(Connection conn, fileQnADto qnaDto) {
		// TODO Auto-generated method stub
		int board_number = qnaDto.getBoard_number();		//0
		int group_number = qnaDto.getGroup_number();		//1
		int sequence_number = qnaDto.getSequence_number();	//0
		int sequence_level = qnaDto.getSequence_level();	//0
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql=null;
		
		try {
			if(board_number == 0) { //원글
				sql = "SELECT max(group_number) FROM fileqna";
				conn = ConnectionProvider.getConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					qnaDto.setGroup_number(rs.getInt(1)+1);
					
					}
				}else {
					//답글 (그룹번호가 같으면서 현재 본인 글 순서보다 크면 sequence_number에 +1)
					sql = "UPDATE fileqna SET sequence_number=sequence_number+1 WHERE group_number=? AND sequence_number>?";
				
					conn = ConnectionProvider.getConnection();
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setInt(1, group_number);
					pstmt.setInt(2, sequence_number);
				
					pstmt.executeUpdate();
					
					qnaDto.setSequence_number(sequence_number+1);
					qnaDto.setSequence_level(sequence_level+1);
				}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
	}

	public int getCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			String sql = "SELECT count(*) FROM fileqna";
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) count = rs.getInt(1);
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return count;
	}

	public ArrayList<fileQnADto> getQnaList(int startRow, int endRow) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<fileQnADto> qnaList = null;
		
		try {
			
			String sql = "SELECT * FROM(SELECT ROWNUm rnum, A.* FROM (SELECT * FROM fileqna ORDER BY group_number DESC, sequence_number ASC) A) WHERE rnum >= ? and rnum <= ?";
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs=pstmt.executeQuery();
			
			qnaList = new ArrayList<fileQnADto>();
			
			while(rs.next()) {
				fileQnADto qnaDto = new fileQnADto();
				
				qnaDto.setBoard_number(rs.getInt("board_number"));
				qnaDto.setName(rs.getString("name"));
				qnaDto.setStu_number(rs.getInt("stu_number"));
				qnaDto.setSubject(rs.getString("subject"));
				qnaDto.setContent(rs.getString("content"));
				qnaDto.setPassword(rs.getString("password"));
				qnaDto.setWrite_date(new Date(rs.getTimestamp("write_date").getTime()));
				qnaDto.setRead_count(rs.getInt("read_count"));
				qnaDto.setGroup_number(rs.getInt("group_number"));
				qnaDto.setSequence_number(rs.getInt("sequence_number"));
				qnaDto.setSequence_level(rs.getInt("sequence_level"));
				
				qnaList.add(qnaDto);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return qnaList;
	}

	public fileQnADto readqna(int board_number) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		fileQnADto qnaDto = null;
		
		try {
			conn=ConnectionProvider.getConnection();
			conn.setAutoCommit(false);	// 자동 커밋을 사용하지 않음
			
			//update 
			// 조회수 증가
			
			String sqlUp = "UPDATE fileqna SET read_count=read_count+1 WHERE board_number=?";
			pstmt=conn.prepareStatement(sqlUp);
			pstmt.setInt(1, board_number);
			pstmt.executeUpdate();
			
			if(pstmt != null) pstmt.close();
			
			// select 
			// 해당 게시물 선택
			String sqlSel = "SELECT * FROM fileqna WHERE board_number=?";
			pstmt = conn.prepareStatement(sqlSel);
			pstmt.setInt(1, board_number);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				qnaDto = new fileQnADto();
				
				qnaDto.setBoard_number(rs.getInt("board_number"));
				qnaDto.setName(rs.getString("name"));
				qnaDto.setStu_number(rs.getInt("stu_number"));
				qnaDto.setSubject(rs.getString("subject"));
				qnaDto.setContent(rs.getString("content"));
				qnaDto.setPassword(rs.getString("password"));
				qnaDto.setWrite_date(new Date(rs.getTimestamp("write_date").getTime()));
				qnaDto.setRead_count(rs.getInt("read_count"));
				qnaDto.setGroup_number(rs.getInt("group_number"));
				qnaDto.setSequence_number(rs.getInt("sequence_number"));
				qnaDto.setSequence_level(rs.getInt("sequence_level"));
				
				qnaDto.setFile_name(rs.getString("file_name"));	//fileName: 시간으로 설정해서 넣은 값_파일 이름
				qnaDto.setPath(rs.getString("path"));
				qnaDto.setFile_size(rs.getLong("file_size"));
			}
			
			// 자동 커밋 하지 않았으니 커밋시켜 줌
			conn.commit();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		return qnaDto;
	}

	public fileQnADto update(int board_number) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; //넘어가는 값이 있으므로
		fileQnADto qnaDto = null;
	
		try {
			String sql = "SELECT * FROM fileqna WHERE board_number =?";
			
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_number);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				qnaDto = new fileQnADto();
				qnaDto.setBoard_number(rs.getInt("board_number"));
				qnaDto.setName(rs.getString("name"));
				qnaDto.setStu_number(rs.getInt("stu_number"));
				qnaDto.setSubject(rs.getString("subject"));
				qnaDto.setContent(rs.getString("content"));
				qnaDto.setPassword(rs.getString("password"));
				qnaDto.setWrite_date(rs.getTimestamp("write_date"));
				qnaDto.setRead_count(rs.getInt("read_count"));
				qnaDto.setGroup_number(rs.getInt("group_number"));
				qnaDto.setSequence_number(rs.getInt("sequence_number"));
				qnaDto.setSequence_level(rs.getInt("sequence_level"));
				
				qnaDto.setFile_name(rs.getString("file_name"));	//fileName: 시간으로 설정해서 넣은 값_파일 이름
				qnaDto.setPath(rs.getString("path"));
				qnaDto.setFile_size(rs.getLong("file_size"));
			}
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		return qnaDto;
	}

	public String checkpwd(String password, int board_number) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String value=null;
		
		try {
			
			String sql = "SELECT name FROM fileqna WHERE password=? and board_number=?";
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, password);
			pstmt.setInt(2, board_number);
			rs= pstmt.executeQuery();
		
			if(rs.next()) value=rs.getString("name");
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			
		}
		
		return value;
	}

	public int updateOk(fileQnADto qnaDto) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		int check=0;
		
		try {
			
		
			/*
			 * pstmt.setString(1, guestDto.getPassword()); pstmt.setString(2,
			 * guestDto.getMessage()); pstmt.setInt(3, guestDto.getNum());
			 */
			
				if(qnaDto.getFile_name() == null) {
					
					String sql = "Update fileqna set subject=?, content=?, password=?, write_date=? where board_number=?";
					conn = ConnectionProvider.getConnection();
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, qnaDto.getSubject());
					pstmt.setString(2, qnaDto.getContent());
					pstmt.setString(3, qnaDto.getPassword());
					pstmt.setTimestamp(4, new Timestamp(qnaDto.getWrite_date().getTime())); 
					pstmt.setInt(5, qnaDto.getBoard_number());
			
					check=pstmt.executeUpdate();
				}
				else {
					String sql = "Update fileqna set subject=?, content=?, password=?,write_date=?,file_name=?,path=?,file_size=? where board_number=?";
					conn = ConnectionProvider.getConnection();
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, qnaDto.getSubject());
					
					pstmt.setString(2, qnaDto.getContent());
					pstmt.setString(3, qnaDto.getPassword());
					pstmt.setTimestamp(4, new Timestamp(qnaDto.getWrite_date().getTime()));
					pstmt.setString(5, qnaDto.getFile_name());
					pstmt.setString(6, qnaDto.getPath());
					pstmt.setLong(7, qnaDto.getFile_size());
				
					pstmt.setInt(8, qnaDto.getBoard_number());
				
					check=pstmt.executeUpdate();
				}
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return check;
	}

	public String checkdel(String password, int board_number) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String value=null;
		int check=0;
		
		try {
			
			String sqlSel = "SELECT name FROM fileqna WHERE password=? and board_number=?";
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sqlSel);
			
			pstmt.setString(1, password);
			pstmt.setInt(2, board_number);
			rs= pstmt.executeQuery();
		
			if(rs.next()) value=rs.getString("name");
		
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			
		}
		
		return value;
	}

	public int delete(String password, int board_number) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int check= 0;
		try {
			
			String sql="DELETE FROM fileqna WHERE password=? and board_number=?";
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, password);
			pstmt.setInt(2, board_number);
			check= pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return check;
	}
	
}
