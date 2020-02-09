<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<c:set var="root" value="${pageContext.request.contextPath}"/>
	<%-- <h3>${root}</h3> --%>
	<div style="margin: 0 auto; width: 1500px; height: 200px;" class="container p-3 my-3 border">		
		<h3 style="background-color: gray; margin-left: auto;text-align: center; height: 50px; line-height: 50px; color: white; ">
			SEARCH SCORE
		</h3>
		<c:if test="${id == null}">
			<ul style="list-style: none; width: 1500px; margin: 60px 430px;">	
				
				<li style="margin-bottom: 20px; width: 100px; align:center; float: left;margin-right: 50px;">
					<a href = "${root}/member/register.self">회원가입</a> &nbsp;&nbsp;
				</li>
				<li style="margin-bottom: 20px; width: 100px; align:center; float: left;">	
					<a href = "${root}/member/login.self">로그인</a> &nbsp;&nbsp;
				</li>
			</ul>
		</c:if>
	
		<c:if test="${id != null}">
			<h3 style="text-align: center;">* ${id}님 환영합니다. *</h3>
			<div style="width: 1500px; height: 100px; padding-left: 480px; margin-top: 30px;">	
				<a href = "${root}/member/logout.self" style="width: 100px; height: 50px; float: left;">로그아웃</a> &nbsp;&nbsp;	
				<a href = "${root}/member/update.self" style="width: 100px; height: 50px; float: left;">회원수정</a> &nbsp;&nbsp;
			</div>
		
		
		<div style="width: 1100px; height: 130px; background-color: #d0ebff;">
			
			<ul style="list-style: none; width: 400px; height: 100px;float: left; margin-top: 30px; margin-left: 82px;">
				<li style="text-align: center;">
					<c:if test = "${stu_number!='#7777'}">
					<h3>학생 페이지</h3>
					<a href = "${root}/score/myScore.self">성적조회</a>
			
					</c:if>
					
					<c:if test = "${stu_number=='#7777'}">
						<h3>관리자 페이지</h3>
						<a href = "${root}/score/insertScore.self">성적입력</a>&nbsp;&nbsp;
						<a href = "${root}/score/searchScore.self">학생 성적 조회</a>&nbsp;&nbsp;
					</c:if>
				</li>
			</ul>
			
			<ul style="list-style: none; width: 400px; height: 100px; float: left; margin-top:30px; margin-left: 60px; ">
				<li style="text-align: center;">
					<h3>문의사항</h3>	
						<a href ="${root}/qna/write.self"> 문의사항 작성</a>&nbsp;&nbsp;
						<a href ="${root}/qna/qnalist.self"> 목록 보기</a>&nbsp;&nbsp;
				</li>
			</ul>
			
			
			<%-- <ul style="list-style: none; width: 300px; height: 100px; float: left;  margin-top:20px;">
				<li style="text-align: center;">
					<c:if test = "${stu_number=='#7777'}">
						<h3>관리자 페이지</h3>
						<a href = "${root}/score/insertScore.self">성적입력</a>&nbsp;&nbsp;
						<a href = "${root}/score/searchScore.self">학생 성적 조회</a>&nbsp;&nbsp;
					</c:if>
				</li>
			</ul> --%>
			
			
		</div>
		
	</c:if>
	<br/><br/>
	
	</div>
	
	
	
<!-- 	<h3>파일 게시판</h3> -->

</body>
</html>