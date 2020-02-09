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
<script type="text/javascript" src="${root}/javaScript/admin/admin.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

</head>
<body>

<jsp:include page="../../../index.jsp"/>
		
<div class="contents" style="margin-top: 300px;">
         <div class="title">
            <span>성적 검색</span>
         </div>  
     <!-- 폼태그가 가지고가는 아이디를 가져야하니까 name값부여-->
         <form action="${root}/score/ScoreList.self" method="get">	
            <ul class="input_list">
               <li>
                  <p>학생이름</p>
                  <p>
                     <input type="text" name="name">
                     <!--폼테그가 가져온 아이디를 확인하기 위해서 root같이 입력.-->
                     <!--온클릭이벤트시 아이디체크라는 함수 호출-->
                  </p>
               </li>
               <li>
                  <p>학번</p>
                  <p>
                     <input type="text" name="stu_number">
                  </p>
               </li>
				<li>
                  <p class="col01">
                  	<button class="btn btn-outline-info" type="submit">검색</button>
                  	<button class="btn btn-outline-dark" type="button" onclick="location.href='${root}/member/main.self'">취소</button>
                
                  
                    <%--  <input class="btn btn_small" type="submit" value="검색">
                     <input class="btn btn_small" type="button" value="취소" onclick="location.href='${root}/member/main.self'">
                      --%>
                  </p>
              	 </li>
				</ul>
			</form>
			
			<%-- <table>
			<c:if test="${NameList.size()==0}"> <!-- 검색한 우편번호가 하나도 없을 때 -->
				<tr>
					<td>검색된 결과가 없습니다.</td>
				</tr>
			</c:if>
		
			<c:if test="${NameList.size() > 0}">	<!-- 검색한 우편번호가 있을 때 -->
				<tr>
					<td>▼ 해당 학생의 성적 정보입니다 .</td>
				</tr>
				<c:forEach var="ScoreDto" items="${NameList}">
					<tr>
						<td>
							<a href="javascript:sendName(
								'${scoreDto.name}', '${scoreDto.stu_number}',
		                   		'${scoreDto.year}', '${scoreDto.semester}',
		                    	'${scoreDto.english}', '${scoreDto.social}',
		                    	'${scoreDto.write_date}')">
		                    	
								${ScoreDto.name} ${ScoreDto.stu_number}
		                   		${ScoreDto.year} ${ScoreDto.semester}
		                    	${ScoreDto.english} ${ScoreDto.math} ${ScoreDto.social}
		                    	${ScoreDto.write_date}	
		                    			
							<!-- </a> -->
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</table> <br/><br/>
		 --%>
		
			
			
			
			
	
		</div>
</body>
</html>