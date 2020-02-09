<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html><!-- 인덱스 페이지를 통해서만 들어갈 수 있음 -->
<c:set var = "root" value = "${pageContext.request.contextPath}"/>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="${root}/css/member/register.js"/>
<link rel="stylesheet" href="${root}/css/member/register.css"/>
<script type="text/javascript" src="${root}/javaScript/member/register.js"></script>
</head>
<body>
<h3>${root}</h3>
<div style="margin: 0 auto;">
	<form action="${root}/member/updateOk.self" method = "post"   onsubmit="return registerForm(this)" name="createForm">
	<input type="hidden" value="${memberDto.num}" name="num"/>
	<div style="text-align: center;">
	<span>회원수정</span> </div>
	<div class="content" style="float:center;">
		
		<div>
			<span style="float: left;">아이디</span>
			<div style="float:left;">		
				<input type="text" name="id" size="10" value="${memberDto.id}" disabled="disabled"/>
				
			</div>	
		</div>
		
	
		
		<div>
			<span style="float: left;">비밀번호</span>
			<div>
				<input type="password" name="pwd" size="10" value="${memberDto.pwd}"/>
			
			</div>
		</div>
			
		<div>
			<span style="float: left;">비밀번호확인</span>
			<div>
				<input type="password" name="pwdCheck" size="10" value="${memberDto.pwd}"/>
			</div>
		</div>
		
		<div>	
			<span style="float: left;">이름</span>
	
		<div>
		<input type="text" name="name" size="10" value="${memberDto.name}" disabled="disabled"/>
		</div>
		</div>
		
		<div>
		<span style="float: left;">학번</span>
		<div>
		<input type="text" name="stu_number" size="10" value="${memberDto.stu_number}" disabled="disabled" />
		</div>
		</div>
		
		<div>
			<span style="float: left;">우편번호</span>
			<div>
			<input type="text" name="zipcode" size="10" value="${memberDto.zipcode}"/>
			<input type="button" value="우편번호검색" onclick="zipcodeRead('${root}')"/>
			</div>
		</div>
		
		<div>
			<span style="float: left;">주소</span>
			<div>
			<input type="text" name="address" size="10" value="${memberDto.address}"/>		
			</div>
		</div>
		
		<div>
		<span style="float: left;">직업</span>
		<div>
			<select name = "job">
				<option value = "admin">교직원</option>
				<option value = "student">학부생</option>
			</select>	
		</div>
		
		</div>
		
		<div class="bottom">
				<input type="submit" value="확인"/>
				<input type="reset" value="취소"/>
		</div>
	</div>
	</form>
</div>

</body>
</html>
 --%>

















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
<script type="text/javascript" src="${root}/javaScript/member/register.js"></script>


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
</head>
<body>


<jsp:include page="../../../index.jsp"/>
<br/><br/>
   
<div class="contents" style="margin-top: 200px;">
         <div class="title">
            <span>회원 수정</span>
         </div>  
         <!-- 폼태그가 가지고가는 아이디를 가져야하니까 name값부여-->
         <form action="${root}/member/updateOk.self" method = "post"   onsubmit="return registerForm(this)" name="createdForm">
		 <input type="hidden" value="${memberDto.num}" name="num"/>
            <ul class="input_list">
               <li>
                  <p>아이디</p>
                  <p>
                    <input type="text" name="id" size="10" value="${memberDto.id}" disabled="disabled"/>
                     <!--폼테그가 가져온 아이디를 확인하기 위해서 root같이 입력.-->
                     <!--온클릭이벤트시 아이디체크라는 함수 호출-->
                  </p>
               </li>
               <li>
                  <p>비밀번호</p>
                  <p>
                     <input type="password" name="pwd" size="10" value="${memberDto.pwd}"/>
                  </p>
               </li>
               <li>
                  <p>비밀번호 확인</p>
                  <p>
                     <input type="password" name="pwdCheck" size="10" value="${memberDto.pwd}"/>
                  </p>
               </li>
                <li>
                  <p>이름</p>
                  <p>
                     <input type="text" name="name" size="10" value="${memberDto.name}" disabled="disabled"/>
                  </p>
               </li>
               <li>
                  <p>학번</p>
                  <p>
                     <input type="text" name="stu_number" size="10" value="${memberDto.stu_number}" disabled="disabled" />
                  </p>
               </li>
               <li>
                  <p>우편번호</p>
                  <p>
                     <input type="text" name="zipcode" size="10" value="${memberDto.zipcode}"/>
					<%-- <input type="button" value="우편번호검색" onclick="zipcodeRead('${root}')"/> --%>
					 <button type="button" class="btn btn-light" onclick="zipcodeRead('${root}')">우편번호 검색</button>
                     
                  </p>
               </li>
               
               <li>
                  <p>주소</p>
                  <p>
                     <input type="text" name="address" size="10" value="${memberDto.address}"/>
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
                     <script type="text/javascript">
                   		  createdForm.job.value="${memberDto.job}"
                     </script>
                  </p>                  
               </li>
               
               <li>
                  <p class="col01">
                  
                 	<button type="submit" class="btn btn-outline-info">확인</button>
                  	<button type="button" class="btn btn-outline-dark" onclick="location.href='${root}/index.jsp'">취소</button>
                    
                     <%-- <input class="btn btn_small" type="submit" value="확인">
                     <input class="btn btn_small" type="reset" value="취소" onclick="location.href='${root}/index.jsp'"/> --%>
                     
                  </p>
               </li>
            </ul>
         </form>
      </div><!--//contents-->
   </body>
</html>