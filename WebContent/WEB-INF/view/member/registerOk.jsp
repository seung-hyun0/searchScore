<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 확인</title>
</head>
<body>
<jsp:include page="../../../index.jsp"/><br/><br/>
	<c:if test="${check > 0}">	<!-- check에는 회원가입이 제대로 되었을 때 1, 아니면 0  -->
		<script type = "text/javascript">
			alert("회원가입이 되었습니다.");
		</script>
	</c:if>
	
	<c:if test="${check == 0}">
		<script type = "text/javascript">
			alert("회원가입에 실패하셨습니다.");
		</script>
		</c:if>
</body>
</html>