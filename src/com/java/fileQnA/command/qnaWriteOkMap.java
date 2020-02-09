package com.java.fileQnA.command;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
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

public class qnaWriteOkMap implements CommandAction{

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		List<FileItem> list = upload.parseRequest(request);	// request객체를 담음
		Iterator<FileItem> iter = list.iterator(); 
		
		fileQnADto qnaDto = new fileQnADto();
		
		HashMap<String, String> dataMap = new HashMap<String, String>();
		
		while(iter.hasNext()) {
			FileItem fileItem = iter.next();
			
			if(fileItem.isFormField()) {
				String name = fileItem.getFieldName();
				String value = fileItem.getString("utf-8");
				dataMap.put(name, value);
			}else {
				if(fileItem.getFieldName().equals("file")) {
					// 파일명
					logger.info(logMsg + fileItem.getName());
					
					// 파일필드명을 모두 가지고 있으므로 파일 값에 file업로드를 안할 경우 null, 공백값이 들어감 
					if(fileItem.getName()==null || fileItem.getName().equals("")) {
						continue;
					}
					
					// 파일 명
					String file_name = Long.toString(System.currentTimeMillis())+"_"+fileItem.getName();
					// 파일명이 같아도 시간으로 해당 파일을 찾을 수 있음
				
					logger.info(logMsg +"저장시간_파일 명: "+ file_name);
					
					// 사이즈
					upload.setFileSizeMax(1024*1024*10); 	// 10mb까지만 받음
					long size = fileItem.getSize();
					
					String dir = "D:\\MVC\\workspace\\SelfHomepage(11-08)\\WebContent\\ftp";
				
					File file = new File(dir, file_name);	// dir폴더의 fileName에 해당하는 파일에 대한 File 객체를 생성한다.
					
					fileItem.write(file);	//write(file): 업로드한 파일을 file이 나타내는 파일로 저장한다/ 용량이 작은 파일 처리시 유용
				
					qnaDto.setFile_name(file_name);
					qnaDto.setFile_size(size);
					qnaDto.setPath(file.getAbsolutePath());	// 프로그램을 실행시킨 위치 정보도 함께 반환 (X:\JSH\MVC\Workspace\homePage\WebContent\ftp\1572857333311_11-04.png) 
				
				}
			}
			
		}
		
		qnaDto.setDataMap(dataMap);
		
		
		//qnaDto.setId(request.getParameter("id"));
		qnaDto.setWrite_date(new Date());
		qnaDto.setRead_count(0);
		
		int check = fileQnADao.getInstance().insert(qnaDto);
		
		logger.info(logMsg +"qnaDto: "+ qnaDto.toString());
		logger.info(logMsg +"check: " +check);
		
		request.setAttribute("check", check);
		request.setAttribute("pageNumber", dataMap.get("pageNumber"));
		
		return "/WEB-INF/view/qna/writeOk.jsp";
	}

}
