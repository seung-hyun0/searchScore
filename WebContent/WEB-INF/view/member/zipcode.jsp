<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta charset="UTF-8">

<title>우편번호 검색</title>
<script type="text/javascript" src="${root}/javaScript/member/register.js"></script>
</head>
<body>
	<div align="center">
		<form action="${root}/member/zipcode.self" method="get">	<!-- 우편번호검색 창에서 검색을 클릭하면 zipcode.do(ZipcodeAction)으로 이동-->
			<table>
				<tr>
					<td>
						<input type="text" name="dong"/>
						<input type="submit" value="검색"/>	
					</td>
				</tr>
			</table>
		</form>
		<table>
			<c:if test="${zipcodeList.size()==0}"> <!-- 검색한 우편번호가 하나도 없을 때 -->
				<tr>
					<td>검색된 결과가 없습니다.</td>
				</tr>
			</c:if>
		
			<c:if test="${zipcodeList.size() > 0}">	<!-- 검색한 우편번호가 있을 때 -->
				<tr>
					<td>▼ 아래의 우편번호를 클릭하세요.</td>
				</tr>
				<c:forEach var="zipcodeDto" items="${zipcodeList}">
					<tr>
						<td>
							<a href="javascript:sendAddress(
								'${zipcodeDto.zipcode}', '${zipcodeDto.sido}',
		                   		'${zipcodeDto.gugun}', '${zipcodeDto.dong}',
		                    	'${zipcodeDto.ri}', '${zipcodeDto.bunji}')">
		                    	
								<!-- EL에서는 get을 사용하지 않는다 -->
								<!-- zipcode,sido,gugun,dong,ri,bunji의 값을 가져온다 -->
								${zipcodeDto.zipcode} ${zipcodeDto.sido}
		                   		${zipcodeDto.gugun} ${zipcodeDto.dong}
		                    	${zipcodeDto.ri} ${zipcodeDto.bunji}				
							</a>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</table> <br/><br/>
		
		<a href ="javascript:self.close()">닫기</a>
	</div>
</body>
</html>