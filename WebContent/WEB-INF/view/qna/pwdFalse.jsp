<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${name == null || password==null}">	<%-- DB에 저장이 잘 되었을 경우 체크 값이 1이므로 check ==1으로 작성해도 됨 --%>
		<script type="text/javascript">
			alert("비밀번호를 다시 입력하세요.");
			location.href = "${root}/qna/qnalist.self";
			
		</script>  
	</c:if>

</body>
</html>