<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var = "root" value = "${pageContext.request.contextPath}"/>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test = "${check > 0}">
		<script type="text/javascript">
			alert("글쓰기 성공");
			location.href="${root}/qna/qnalist.self";
		
		</script>
	</c:if>
	
		<c:if test = "${check == 0}">
		<script type="text/javascript">
			alert("글쓰기 실패");
			location.href="${root}/qna/write.self";
		
		</script>
	</c:if>
</body>
</html>