package com.java.fileQnA.command;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.CommandAction;

import com.java.fileQnA.dao.fileQnADao;
import com.java.fileQnA.dto.fileQnADto;

public class fileDownload implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		int board_number = Integer.parseInt(request.getParameter("board_number"));
		logger.info(logMsg +"선택한 글의 글번호: "+ board_number);
		
		fileQnADto qnaDto = fileQnADao.getInstance().update(board_number);
		logger.info(logMsg +"해당 글 번호안의 정보: "+ qnaDto.toString());
		
		// fileName에는 같은 파일이름을 가질 경우 구별하기 위해 시간을 앞에 붙여서 fileName값을 주었기 때문에 파일 이름만을 가져 올 경우 _앞 부분을 _와 함께 제거 
		int index = qnaDto.getFile_name().indexOf("_") +1;
		String dbName = qnaDto.getFile_name().substring(index);
		String file_name = new String (dbName.getBytes("utf-8"), "ISO-8859-1");
		
		//Content-Disposition: 파일 다운 작은 창 나오게
		response.setHeader("Content-Disposition", "attachment;filename=" + file_name);	
		response.setContentType("application/octet-stream");
		response.setContentLength((int)qnaDto.getFile_size());
		
		// 다운로드
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			bis = new BufferedInputStream(new FileInputStream(qnaDto.getPath()));
			bos = new BufferedOutputStream(response.getOutputStream());
			
			while(true) {
				int data = bis.read();
				if(data == -1) break;
				bos.write(data);
			}
			bos.flush();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(bos != null) bos.close();
			if(bis != null) bis.close();
		}
		return null;
	}

}
