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

public class qnaUpdateOk implements CommandAction{

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		// 파일 보관
				DiskFileItemFactory factory = new DiskFileItemFactory();
				// 요청 처리 객체
				ServletFileUpload upload = new ServletFileUpload(factory);
				// 요청 파싱 목록, 팩토리에 저장되는데 List형태
				List<FileItem> list = upload.parseRequest(request);
				
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
							String file_name = fileItem.getName();
							if(file_name ==null || file_name.equals(""))	continue;
							
							String timeName = Long.toString(System.currentTimeMillis()) + "_" + file_name;
							upload.setSizeMax(1024*1024*10);
							
							//절대 경로	String path = "X:\\JSH\\MVC\\Workspace\\homePage\\WebContent\\ftp";
							// 상대경로	
							//String path = request.getServletContext().getRealPath("/pds");
							
							//File file = new File(path, timeName);
							//fileItem.write(file);
							
							File path = new File("C:/pds/");
							path.mkdir();
							
							if(path.exists() && path.isDirectory()) {
							
								File file = new File(path, timeName);
								fileItem.write(file);
								qnaDto.setFile_name(timeName);
								qnaDto.setPath(file.getAbsolutePath());
								qnaDto.setFile_size(fileItem.getSize());
							
								fileQnADto readqna = fileQnADao.getInstance().update(Integer.parseInt(dataMap.get("board_number")));
							
							if(readqna.getFile_name() != null) {
								File checkFile = new File(readqna.getPath());
								if(file.exists() && checkFile.isFile()) checkFile.delete();
								}
							}
						}
					}
				}
				qnaDto.setDataMap(dataMap);
				qnaDto.setWrite_date(new Date());
				int check = fileQnADao.getInstance().updateOk(qnaDto);
				logger.info(logMsg + qnaDto.toString());
				
				request.setAttribute("check", check);
				request.setAttribute("pageNumber", dataMap.get("pageNumber"));
				
				
		
		return "/WEB-INF/view/qna/updateOk.jsp";
	}

}
