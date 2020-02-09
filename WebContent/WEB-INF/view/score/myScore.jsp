<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
 
</script>
<title>성적 검색 내용</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
     <jsp:include page="../../../index.jsp"/><br/><br/>
   <c:set var="root" value="${pageContext.request.contextPath}"/>
   
   <%--누르면 나오는게시글 나오는 jsp--%>
   <div align="center" style="padding-top: 200px;" class="container">
   
   <table border="0" class="table table-hover">
      <thead>
      <tr>
         <td align="center" height="20"  width="125">입력번호</td> 
         <td align="center" height="20"  width="125">학생이름</td> 
         <td align="center" height="20"  width="125">학번</td> 
         <td align="center" height="20"  width="125">시험년도</td> 
         <td align="center" height="20"  width="80">해당학기</td> 
         <td align="center" height="20"  width="80">영어</td> 
         <td align="center" height="20"  width="80">수학</td> 
         <td align="center" height="20"  width="80">사회</td> 
         <td align="center" height="20"  width="80">합계</td> 
         <td align="center" height="20"  width="80">평균</td> 
      
      </tr>
      </thead>
      
      <c:forEach var="scoreDto" items="${myList}">
      <thead>
      <tr>
         <td align="center" height="20"  width="125">${scoreDto.score_num}</td> 
         <td align="center" height="20"  width="125">${scoreDto.name}</td> 
         
         
         <td align="center" height="20"  width="125">${scoreDto.stu_number}</td> 
         <td align="center" height="20"  width="125">${scoreDto.year}</td> 
         <td align="center" height="20"  width="125">${scoreDto.semester}</td> 
         <td align="center" height="20"  width="125">${scoreDto.english}</td> 
         <td align="center" height="20"  width="125">${scoreDto.math}</td> 
         <td align="center" height="20"  width="125">${scoreDto.social}</td> 
         <td align="center" height="20"  width="125">${scoreDto.sum}</td> 
         <td align="center" height="20"  width="125">${scoreDto.avg}</td> 
      
      <%--    <fmt:formatDate value="${scoreDto.write_date}" pattern="yyyy-MM-dd"/> --%>
         
      </tr>
      
      
      </c:forEach>
      <tr>
         <td height="30" colspan="10" align="center" >
                   
            <button type="button" class="btn btn-outline-success" onclick="location.href='${root}/member/main.self'">닫기</button>      
         
         </td>
      
      
      </tr>
      </thead>
      </table>
   
   </div>
 
</body>
</html>