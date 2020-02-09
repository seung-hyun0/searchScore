<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
	<c:set var = "root" value = "${pageContext.request.contextPath}"/>
	
	<c:if test="${check > 0}">	<%-- DB에 저장이 잘 되었을 경우 체크 값이 1이므로 check ==1으로 작성해도 됨 --%>
		<script type="text/javascript">
			alert("게시글이 수정되었습니다.");
			location.href = "${root}/qna/qnalist.self";
		</script>  
	</c:if>

	<c:if test="${check == 0}">
		<script type="text/javascript">
			alert("게시글이 수정되지 않았습니다.");
			location.href = "${root}/qna/qnalist.self";
		</script>
	</c:if>
</body>
</html>