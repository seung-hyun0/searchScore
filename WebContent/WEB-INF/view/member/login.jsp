<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta charset="UTF-8">

<title>학생 검색</title>
  
<link rel="stylesheet" href="${root}/css/admin/score.css"/>
</head>
<body>
<jsp:include page="../../../index.jsp"/><br/><br/>

		
<div class="contents">
         <div class="title">
            <span>로그인</span>
         </div>  
     <!-- 폼태그가 가지고가는 아이디를 가져야하니까 name값부여-->
         <form action="${root}/member/loginOk.self" method="get">	
            <ul class="input_list">
               <li>
                  <p>아이디</p>
                  <p>
                     <input type="text" name="id">
                     <!--폼테그가 가져온 아이디를 확인하기 위해서 root같이 입력.-->
                     <!--온클릭이벤트시 아이디체크라는 함수 호출-->
                  </p>
               </li>
               <li>
                  <p>비밀번호</p>
                  <p>
                     <input type="password" name="pwd">
                  </p>
               </li>
				<li>
                  <p class="col01">
                     <button class="btn btn-outline-info" type="submit" value="검색">확인</button>
                     <button class="btn btn-outline-dark" type="reset" value="취소">취소</button>
                     
                  </p>
              	 </li>
				</ul>
			</form>
		</div>
</body>
</html>