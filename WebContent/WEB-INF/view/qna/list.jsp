<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta charset="UTF-8">
<title>Q&A List</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="../../../index.jsp"/><br/><br/>
	<div style="padding-top: 150px;" class="container">
		<table width = "800" align="center" height="50" class="table table-hover">
			<thead>
			<tr style="margin-top: 100px;">
				<td align = "right" bgcolor="skyblue">
					<a href="${root}/qna/write.self" style="margin-right: 30px;">글쓰기</a>
				</td>
			</tr>
			</thead>
		</table>
	
	<c:if test="${count == 0 || qnaList.size() == 0}">
         <table>
            <tr>
               <td align="center"> Q&A에 저장된 글이 없습니다.</td>
            </tr>         
         </table>
      </c:if>
      
      <c:if test="${count > 0 }">
		<table border="0" width="800" cellpadding="2" cellspacing="0" align="center" class="table table-hover">
			<thead>
			<tr>
				<td align="center" width="30">번호</td>
				<td align="center" width="250">제목</td>
				<td align="center" width="70">작성자</td>
				<td align="center" width="80">작성일</td>
				<td align="center" width="50">조회수</td>
			
			</tr>
			</thead>
			
			<c:forEach var="qnaDto" items="${qnaList}">
				<tbody>
				<tr>
					<td style="text-align: center">${qnaDto.board_number}</td>
					<td>
						<c:if test="${qnaDto.sequence_level > 0}">
							<c:forEach begin="0" end="${qnaDto.sequence_level}" step="1"> &nbsp;&nbsp;
							</c:forEach>
								ㄴ[답글]
						</c:if>
					
					<a href="${root}/qna/read.self?board_number=${qnaDto.board_number}&pageNumber=${currentPage}">${qnaDto.subject}</a>
					</td>
					
					<td style="text-align: center;">${qnaDto.name}</td>
					<td style="width: 7px; padding-left: 70px;">
						<fmt:formatDate value="${qnaDto.write_date}" pattern="yyyy-MM-dd HH:mm:ss"/>
					</td>
					<td style="text-align: center;">${qnaDto.read_count}</td>
				</tr>
				</tbody>
			</c:forEach>
		</table>
	</c:if></div>
	<br/>
	<div align = "center">
		<ul  class="pagination" style="width: 170px; margin: 0 auto;">
		<c:if test="${count > 0 }">
			<c:set var="pageBlock" value="${3}"/>
			<c:set var="pageCount" value="${count/boardSize+(count%boardSize==0 ? 0:1)}"/>
			
			<fmt:parseNumber var = "result" value = "${(currentPage-1)/pageBlock}" integerOnly="true"/>
			<c:set var="startPage" value = "${result*pageBlock+1}"/>
			<c:set var="endPage" value = "${startPage+pageBlock-1}"/>
			
			<c:if test="${endPage > pageCount}">
				<c:set var="endPage" value="${pageCount}"/>
			</c:if>
			
			<c:if test="${startPage > pageBlock}">
			<li class="page-item">
				<a class="page-link" href="${root}/qna/qnalist.self?pageNumber=${startPage-pageBlock}"> < </a>
			</li>
			</c:if>
			
			<c:forEach var = "i" begin="${startPage}" end="${endPage}">
			<li class="page-item">
				<a class="page-link" href="${root}/qna/qnalist.self?pageNumber=${i}">${i}</a>
			</li>
			</c:forEach>  
			
			<c:if test="${endPage < pageCount}">
			<li class="page-item">
				<a class="page-link" href="${root}/qna/qnalist.self?pageNumber=${startPage+pageBlock}"> > </a>
			</li>
			</c:if>
		
		</c:if>
		</ul>
	</div>
</body>
</html>