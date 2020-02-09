<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var = "root" value = "${pageContext.request.contextPath}"/>

<html>
<head>
<meta charset="UTF-8">
<title>게시글삭제</title>

<script type="text/javascript" src="${root}/javaScript/fileBoard/write.js">
</script>
</head>
<body>
	<c:if test="${del > 0}">
		<script type="text/javascript">
			alert("삭제되었습니다.");
			location.href ="${root}/qna/qnalist.self?page_number=${page_number}";
		</script>
	</c:if>
	
	<c:if test="${del == 0}">
		<script type="text/javascript">
			alert("삭제되지 않았습니다.");
			location.href ="${root}/qna/qnalist.self?page_number=${page_number}";
		</script>
	</c:if>
</body>
</html>