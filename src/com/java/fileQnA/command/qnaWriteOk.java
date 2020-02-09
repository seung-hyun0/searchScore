package com.java.fileQnA.command;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.java.command.CommandAction;

import com.java.fileQnA.dao.fileQnADao;
import com.java.fileQnA.dto.fileQnADto;

public class qnaWriteOk implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		ServletFileUpload upload = new ServletFileUpload();
		
		List<FileItem> list = upload.parseRequest(request);
		
		Iterator<FileItem> iter = list.iterator();
		fileQnADto qnaDto = new fileQnADto();
		
		while(iter.hasNext()) {
			FileItem fileItem = iter.next();
			
			if(fileItem.isFormField()) {
				if(fileItem.getFieldName().equals("board_number")) {
					qnaDto.setBoard_number(Integer.parseInt(fileItem.getString()));
					
				}
				if(fileItem.getFieldName().equals("group_number")) {
					qnaDto.setGroup_number(Integer.parseInt(fileItem.getString()));
				}
				
				if(fileItem.getFieldName().equals("sequence_number")) {
					qnaDto.setSequence_number(Integer.parseInt(fileItem.getString()));
				}
				
				if(fileItem.getFieldName().equals("sequence_level")) {
					qnaDto.setSequence_level(Integer.parseInt(fileItem.getString()));
				}
				
				if(fileItem.getFieldName().equals("name")) {
					qnaDto.setName(fileItem.getString("utf-8"));
				}
				if(fileItem.getFieldName().equals("subject")) {
					qnaDto.setSubject(fileItem.getString("utf-8"));
				}
				
				if(fileItem.getFieldName().equals("stu_number")) {
					qnaDto.setStu_number(Integer.parseInt(fileItem.getString("utf-8")));
				}
				
				if(fileItem.getFieldName().equals("content")) {
					qnaDto.setContent(fileItem.getString("utf-8"));
				}
				if(fileItem.getFieldName().equals("password")) {
					qnaDto.setPassword(fileItem.getString("utf-8"));
				}
			}else {
				if(fileItem.getFieldName().equals("file")) {
					logger.info(logMsg + "file 이름: " + fileItem.getName());
					
					if(fileItem.getName()==null || fileItem.getName().equals("")) {
						continue;
						// if 문을 빠져 나간다
					}
					
					String file_name = Long.toString(System.currentTimeMillis())+"_"+fileItem.getName();
					
					logger.info(logMsg +"저장시간_파일 명: "+ file_name);
					// 사이즈
					upload.setFileSizeMax(1024*1024*10); 	// 10mb까지만 받음, 전체 최대 업로드 파일 크기
					long size = fileItem.getSize();
					
					// 경로
					String dir = "D:\\MVC\\workspace\\SelfHomepage(11-08)\\WebContent\\ftp";
					
					File file = new File(dir, file_name);
					
					/* FileInputStream fis = null; */
					BufferedInputStream bis = null;	
					
					// 클라이언트에서 읽어서 서버에 저장
					/* FileOutputStream fos = null; */
					BufferedOutputStream bos = null;
					
					try {

						bis = new BufferedInputStream(fileItem.getInputStream());
						bos = new BufferedOutputStream(new FileOutputStream(file));
						
						while(true) {	// 읽어온거 data에 저장
							int data = bis.read();
							if(data==-1) break;
							bos.write(data);
						}
						
					}catch (Exception e) {
						e.printStackTrace();
					}finally {
						if(bos!=null) bos.close();
						if(bis!=null) bis.close();
					}
					qnaDto.setFile_name(file_name);
					qnaDto.setFile_size(size);
					qnaDto.setPath(file.getAbsolutePath());
				}
			}
		}
		
		qnaDto.setWrite_date(new Date());
		qnaDto.setRead_count(0);
		logger.info(logMsg + qnaDto.toString());
		
		int check = fileQnADao.getInstance().insert(qnaDto);
		logger.info(logMsg +"check: " +check);
		
		request.setAttribute("check", check);
		
		return "/WEB-INF/view/qna/writeOk.jsp";
	}

}
