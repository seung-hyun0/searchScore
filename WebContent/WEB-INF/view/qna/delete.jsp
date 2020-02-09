<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta charset="UTF-8">

<title>게시글 삭제</title>
<link rel="stylesheet" href="${root}/css/admin/score.css"/>
<script type="text/javascript" src="${root}/javaScript/qna/write.js"></script>
</head>
<body>
<jsp:include page="../../../index.jsp"/><br/><br/>

		
<div class="contents" style="margin: 150px auto 0;">
         <div class="title">
            <span>삭제</span>
         </div>  
  <%--  ${board_number},${qnaDto},${pageNumber} --%>
         <input type="hidden" name ="board_number" value="${board_number}"/>
		 <input type="hidden" name ="qnaDto" value="${qnaDto}"/>
		 <input type="hidden" name ="pageNumber" value="${pageNumber}"/>
         <c:set var="board_number" value="${board_number}" scope="session"/>  
         <c:set var="page_number" value="${pageNumber}" scope="session"/>  
         <c:set var="qnaDto" value="${qnaDto}" scope="session"/>   
     <!-- 폼태그가 가지고가는 아이디를 가져야하니까 name값부여-->
      <form action="${root}/qna/deletepwd.self" method="get">
        <%--  <form action="${root}/qna/deletepwd.self" method="post" onsubmit="return deleteCheck(this)" name="createForm"> --%>
            <ul class="input_list">
               
               <li>
                  <p>비밀번호</p>
                  <p>
                     <input type="password" name="password">
                  </p>
               </li>
				<li>
                  <p class="col01">
                     <button class="btn btn-outline-danger" type="submit" value="확인">확인</button>
                     <button class="btn btn-outline-link" type="reset" value="취소">취소</button>
                     
                  </p>
              	 </li>
				</ul>
			</form>
		</div>
</body>
</html>