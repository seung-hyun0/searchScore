<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta charset="UTF-8">
<title>로그인창</title>
</head>
<body>
	<c:if test="${stu_number != null}">
		<c:set var="id" value="${id}" scope="session"/>		<!-- id를 세션으로 집어 넣는 것  -> EL처럼 아이디를 사용 가능해짐 -->
		<c:set var="stu_number" value="${stu_number}" scope="session"/>
		<script type="text/javascript">
			alert("로그인 되었습니다.");
			location.href="${root}/member/main.self";
		</script>	
	</c:if>
	
	<c:if test="${stu_number == null}">
		<script type="text/javascript">
			alert("로그인 실패하셨습니다.");
			location.href="${root}/member/login.self"	
		</script>	
	</c:if>
</body>
</html>