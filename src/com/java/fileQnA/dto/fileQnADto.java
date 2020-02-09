package com.java.fileQnA.dto;

import java.util.Date;
import java.util.HashMap;

public class fileQnADto {
	private int board_number;
	private String name;
	private int stu_number;
	private String subject; 
	private String content;
	private String password; 
	private Date write_date;  

	private int read_count; 
	private int group_number; 
	private int sequence_number; 
	private int sequence_level;
	
	private String file_name;
	private String path;
	private long file_size;
	
	private HashMap<String,String> dataMap;
	
	public fileQnADto() {}

	public fileQnADto(int board_number, String name, int stu_number, String subject, String content,
			String password, Date write_date, int read_count, int group_number, int sequence_number, int sequence_level,
			String file_name, String path, long file_size, HashMap<String, String> dataMap) {
		super();
		this.board_number = board_number;
		
		this.name = name;
		this.stu_number = stu_number;
		this.subject = subject;
		this.content = content;
		this.password = password;
		this.write_date = write_date;
		this.read_count = read_count;
		this.group_number = group_number;
		this.sequence_number = sequence_number;
		this.sequence_level = sequence_level;
		this.file_name = file_name;
		this.path = path;
		this.file_size = file_size;
		this.dataMap = dataMap;
	}

	public int getBoard_number() {
		return board_number;
	}

	public void setBoard_number(int board_number) {
		this.board_number = board_number;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStu_number() {
		return stu_number;
	}

	public void setStu_number(int stu_number) {
		this.stu_number = stu_number;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getWrite_date() {
		return write_date;
	}

	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}

	public int getRead_count() {
		return read_count;
	}

	public void setRead_count(int read_count) {
		this.read_count = read_count;
	}

	public int getGroup_number() {
		return group_number;
	}

	public void setGroup_number(int group_number) {
		this.group_number = group_number;
	}

	public int getSequence_number() {
		return sequence_number;
	}

	public void setSequence_number(int sequence_number) {
		this.sequence_number = sequence_number;
	}

	public int getSequence_level() {
		return sequence_level;
	}

	public void setSequence_level(int sequence_level) {
		this.sequence_level = sequence_level;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public long getFile_size() {
		return file_size;
	}

	public void setFile_size(long file_size) {
		this.file_size = file_size;
	}

	public HashMap<String, String> getDataMap() {
		return dataMap;
	}

	public void setDataMap(HashMap<String, String> dataMap) {
		if(dataMap.get("group_number") != null) {
			
			setGroup_number(Integer.parseInt(dataMap.get("group_number")));
			setSequence_number(Integer.parseInt(dataMap.get("sequence_number")));
			setSequence_level(Integer.parseInt(dataMap.get("sequence_level")));
		}
		setBoard_number(Integer.parseInt(dataMap.get("board_number")));
		setName(dataMap.get("name"));
		setSubject(dataMap.get("subject"));
		setStu_number(Integer.parseInt(dataMap.get("stu_number")));
		setContent(dataMap.get("content"));
		setPassword(dataMap.get("password"));
	}

	

	@Override
	public String toString() {
		return "fileQnADto [board_number=" + board_number + ", name=" + name + ", stu_number="
				+ stu_number + ", subject=" + subject + ", content=" + content + ", password=" + password
				+ ", write_date=" + write_date + ", read_count=" + read_count + ", group_number=" + group_number
				+ ", sequence_number=" + sequence_number + ", sequence_level=" + sequence_level + ", file_name="
				+ file_name + ", path=" + path + ", file_size=" + file_size + ", dataMap=" + dataMap + "]";
	}
	
	
}
