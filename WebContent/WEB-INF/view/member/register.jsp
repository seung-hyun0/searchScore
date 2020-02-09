
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<c:set var="root" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="${root}/css/admin/score.css"/>
<script type="text/javascript" src="${root}/javaScript/member/register.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>


<%-- <jsp:include page="../../../index.jsp"/>--%>
<br/><br/>
   
<div class="contents">
         <div class="title">
            <span>회원가입</span>
         </div>  
         <form action="${root}/member/registerOk.self" method = "post"  name="createForm"> <!-- 폼태그가 가지고가는 아이디를 가져야하니까 name값부여-->
         
            <ul class="input_list">
               <li>
                  <p>아이디</p>
                  <p>
                     <input type="text" name="id">
                     <button type="button" class="btn btn-light" onclick="idCheck(createForm,'${root}')">아이디중복</button>
                     <%-- <input type="button" value="아이디중복" onclick="idCheck(createForm,'${root}')"> --%>
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
                  <p>비밀번호 확인</p>
                  <p>
                     <input type="password" name="pwdCheck">
                  </p>
               </li>
                <li>
                  <p>이름</p>
                  <p>
                     <input type="text" name="name">
                  </p>
               </li>
               <li>
                  <p>학번</p>
                  <p>
                     <input type="text" name="stu_number">
                  </p>
               </li>
               <li>
                  <p>우편번호</p>
                  <p>
                     <input type="text" name="zipcode">
                      <button type="button" class="btn btn-light" onclick="zipcodeRead('${root}')">우편번호 검색</button>
                     
                     <%-- <input type="button" value="우편번호검색" onclick="zipcodeRead('${root}')"/> --%>
                  </p>
               </li>
               
               <li>
                  <p>주소</p>
                  <p>
                     <input type="text" name="address">
                  </p>
               </li>
               
               <li>
               	<p>직업</p>
               		<p>
                     <select name="job">
                        <option selected>직업을 선택하세요</option>
                        <option value="admin">교직원</option>
                        <option value = "student">재학생</option>
                     </select>
                  </p>                  
               </li>
               
               <li>
                  <p class="col01">
                  	<button type="submit" class="btn btn-outline-info">확인</button>
                  	<button type="button" class="btn btn-outline-dark" onclick="location.href='${root}/index.jsp'">취소</button>
                    <%--  <input class="btn btn_small" type="submit" value="확인">
                     <input class="btn btn_small" type="reset" value="취소" onclick="location.href='${root}/index.jsp'"/>
                      --%>
                  </p>
               </li>
            </ul>
         </form>
      </div><!--//contents-->
   </body>
</html>