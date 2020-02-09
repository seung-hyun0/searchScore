<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<c:set var="root" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta charset="UTF-8">
<title>성적입력</title>
<link rel="stylesheet" href="${root}/css/admin/score.css"/>
<script type="text/javascript" src="${root}/javaScript/admin/admin.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>


<%-- <jsp:include page="../../../index.jsp"/>--%>
<br/><br/>
   
<div class="contents">
         <div class="title">
            <span>성적수정</span>
         </div>  
         <form action="${root}/score/scoreupdateOk.self" method="post" onsubmit="return scoreForm(this)" 
                        name="createdForm"> <!-- 폼태그가 가지고가는 아이디를 가져야하니까 name값부여-->
         <input type="hidden" value="${scoreDto.score_num}" name="score_num"/>
         <input type="hidden" value="${scoreDto.name}" name="name"/>
         <input type="hidden" value="${scoreDto.stu_number}" name="stu_number"/>
            <ul class="input_list">
               <li>
                  <p>학생이름</p>
                  <p>
                     <input type="text" name="name" value="${scoreDto.name}" disabled="disabled">
                     <!--폼테그가 가져온 아이디를 확인하기 위해서 root같이 입력.-->
                     <!--온클릭이벤트시 아이디체크라는 함수 호출-->
                  </p>
               </li>
               <li>
                  <p>학번</p>
                  <p>
                     <input type="text" name="stu_number" value="${scoreDto.stu_number}" disabled="disabled">
                  </p>
               </li>
               <li>
                  <p>년도</p>
                  <p>
             
                     <select name="year">
                        <option selected>년도를 선택하세요</option>
                        <option>2019년</option>
                        <option>2018년</option>
                        <option>2017년</option>
                        <option>2016년</option>
                        <option>2015년</option>
                        <option>2014년</option>
                        <option>2013년</option>
                        <option>2012년</option>
                        <option>2011년</option>
                     </select>
                     <script type="text/javascript">
                   		  createdForm.year.value="${scoreDto.year}"
                     </script>
                  </p>                  
               </li>
               <li>
                  <p>학기</p>
                  <p>
                     <span>
                        <input type="radio" name="semester" value="1학기">1학기
                        <!-- <label for="firstSemester">1학기</label> -->
                        
                        <input type="radio" name="semester" value="2학기">2학기
                        <!-- <label for="secondSemester">2학기</label> -->
                     </span>
                     <script type="text/javascript">
                     	for(var i=0; i<createdForm.length;i++){
                     		if(createdForm.semester[i].value=="${scoreDto.semester}"){
                     			createdForm.semester[i].checked=true;
                     		}
                     	}
                     </script>
                     
                     
                     
                  </p>
               </li>
               <li>
                  <p>영어</p>
                  <p>
                     <input type="text"  name="english" value="${scoreDto.english}">
                  </p>
               </li>
               <li>
                  <p>수학</p>
                  <p>
                     <input type="text"  name="math" value="${scoreDto.math}">
                  </p>
               </li>
               <li>
                  <p>사회</p>
                  <p>
                     <input type="text"  name="social" value="${scoreDto.social}">
                  </p>
               </li>
               
               <li>
                  <p class="col01">
                     <button class="btn btn-outline-primary" type="submit" value="저장">저장</button>
                     <button class="btn btn-outline-link" type="reset" value="취소">취소</button>
                     
                  </p>
               </li>
            </ul>
         </form>
         
      
      
      </div><!--//contents-->
   </body>
</html>