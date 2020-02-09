<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<c:set var = "root" value = "${pageContext.request.contextPath}"/>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 읽기</title>

	<script type="text/javascript">
	function replyFun(root, board_number, group_number, sequence_number, sequence_level, pageNumber){
		var url = root + "/qna/write.self?board_number="+ board_number;
		url += "&group_number="+ group_number + "&sequence_number="+sequence_number +"&sequence_level="+sequence_level + "&pageNumber="+pageNumber;
		/* alert(url); */
		location.href=url;
	}
	</script>
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<%-- <h3>
	board_number: ${qnaDto.board_number}, 
	group_number: ${qnaDto.group_number}, 
	sequence_number: ${qnaDto.sequence_number}, 
	sequence_level: ${qnaDto.sequence_level}
	
	</h3> --%>
	<input type="hidden" name ="board_number" value="${qnaDto.board_number}"/>
			<input type="hidden" name ="group_number" value="${qnaDto.group_number}"/>
			<input type="hidden" name ="sequence_number" value="${qnaDto.sequence_number}"/>
			<input type="hidden" name ="sequence_level" value="${qnaDto.sequence_level}"/>
			<input type="hidden" name ="pageNumber" value="${pageNumber}"/>
			
	<div align = "center" style="margin-top:200px;" class="container">
		<div class="title" style="margin-bottom: 20px">
				<p class="title_main" style="font-size: 50px; font-weight: bold;">Q&A</p>
				<a class="list" href="${root}/qna/qnalist.self"  style="margin-left: 950px; margin-bottom: 20px;">글목록</a>
		</div>
		<table class="table">
			<tbody>
			<tr>
				<td align="center" height="20" width="125" style="font-weight: bold;">글번호</td>
				<td align="center" height="20" width="125">${qnaDto.board_number}</td>
				<td align="center" height="20" width="125" style="font-weight: bold;">조회수</td>
				<td align="center" height="20" width="125">${qnaDto.read_count}</td>
			</tr>		
			
			<tr>
				<td align="center" height="20" width="125" style="font-weight: bold;">작성자</td>
				<td align="center" height="20" width="125">${qnaDto.name}</td>
				<td align="center" height="20" width="125" style="font-weight: bold;">작성일</td>
				<td align="center" height="20" width="125">
					<fmt:formatDate value ="${qnaDto.write_date}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			</tr>	
			
			<tr>
				<td align="center" height="350" width="125" style="font-weight: bold;">글내용</td>
				<td valign="top" height="350" colspan="3">${qnaDto.content}</td>
			</tr>
			
			<c:if test="${qnaDto.file_name != null}">
				<tr height="20">
					<td align = "center" height="20" width="125" style="font-weight: bold;">파일명</td>
					<td colspan = "3">
					
						<!-- 클릭 시 파일을 다운 -->
						<a href = "${root}/qna/download.self?board_number=${qnaDto.board_number}">${qnaDto.file_name}</a>
					</td>
				</tr>
			</c:if>
			
			<tr>
				<td height="30" colspan="4" align="center">
				
                  	<button type="button" class="btn btn-outline-info" onclick="location.href='${root}/qna/update.self?board_number=${qnaDto.board_number}&pageNumber=${pageNumber}'">글수정</button>
                  	<button type="button" class="btn btn-outline-danger" onclick="location.href='${root}/qna/delete.self?pageNumber=${pageNumber}&board_number=${qnaDto.board_number}'">글삭제</button>
                  	<button type="button" class="btn btn-outline-secondary" onclick="replyFun('${root}','${qnaDto.board_number}',
					'${qnaDto.group_number}','${qnaDto.sequence_number}',
					'${qnaDto.sequence_level}','${pageNumber}')">답글</button>
                  	<button type="button" class="btn btn-outline-light text-dark" onclick="location.href='${root}/qna/qnalist.self?pageNumber=${pageNumber}'">글목록</button>
                  	
                  	
					<%-- <input type="button" value="글수정" onclick="location.href='${root}/qna/update.self?board_number=${qnaDto.board_number}&pageNumber=${pageNumber}'"/>
					
					<input type="button" value="글삭제" onclick="location.href='${root}/qna/delete.self?pageNumber=${pageNumber}&board_number=${qnaDto.board_number}'"/>
					
					<input type="button" value="답글" 
					onclick="replyFun('${root}','${qnaDto.board_number}',
					'${qnaDto.group_number}','${qnaDto.sequence_number}',
					'${qnaDto.sequence_level}','${pageNumber}')"/>
					
					<input type="button" value="글목록" onclick="location.href='${root}/qna/qnalist.self?pageNumber=${pageNumber}'"/>
					 --%>
				</td>
			</tr>
			</tbody>
		</table>
	</div>
</body>
</html>