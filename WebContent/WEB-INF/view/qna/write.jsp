<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var = "root" value = "${pageContext.request.contextPath}"/>
<html>
<head>
<meta charset="UTF-8">
<title>QnA 글쓰기</title>
<link rel="stylesheet" href="${root}/css/qna/style.css"/>
<script type="text/javascript" src="${root}/javaScript/qna/write.js">

</script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
  <style type="text/css">
  p {
  margin-bottom: 0px;}
  
  </style>
</head>
<body>
	
	<%-- <h3>
	board_number: ${board_number}, 
	group_number: ${group_number}, 
	sequence_number: ${sequence_number}, 
	sequence_level: ${sequence_level}
	
	</h3> --%>
	
 		<div class="contents" align = "center" style="margin-top:200px;">
			<div class="title">
				<p class="title_main" style="font-size: 40px; font-weight: bold">Q&A</p>
				<a class="list" href="${root}/qna/qnalist.self">글목록</a>
			</div>
			
			<!-- application/x-www-form-urlencoded : 텍스트 전송(기본값, 생략가능) -->
			<form class="form_style" action ="${root}/qna/writeOk.self" method = "post" onsubmit = "return boardForm(this)" 
			enctype="multipart/form-data">
			
			<input type="hidden" name ="board_number" value="${board_number}"/>
			<input type="hidden" name ="group_number" value="${group_number}"/>
			<input type="hidden" name ="sequence_number" value="${sequence_number}"/>
			<input type="hidden" name ="sequence_level" value="${sequence_level}"/>
		
				<%-- <ul class="write_box">
					<li>
						<p>작성자</p>
						<p>
							<input type="text" name="name">
						</p>
					</li>
					<li>
						<p>제목</p>
						<p>
							<input type="text" name="subject">
						</p>
					</li>
					<li>
						<p>학번</p>
						<p>
							<input type="text" name="stu_number">
						</p>
					</li>
					<li class="long">
						<p>내용</p>
						<p>
							<textarea rows="10" cols="10" name="content"></textarea>
						</p>
					</li>
					<li>
						<p>비밀번호</p>
						<p>
							<input type="password" name="password">
						</p>
					</li>
					
						<li>
						<p>파일명</p>
						<p>
							  
							<input type="file" name="file" size="40"/>
						</p>
					</li>
					
					<li>
						<p class="col1" style="margin-top: 5px;">
							<button class="btn btn-outline-warning" type="submit">글쓰기</button>
							<button class="btn btn-outline-danger" type="reset">다시 작성</button>
							<button class="btn btn-outline-dark" type="button" onclick="location.href='${root}/qna/qnalist.self'">목록보기</button>
							
							<input class="btn" type="submit" value="글쓰기" >
							<input class="btn" type="reset" value="다시작성" onclick="">
						
							<input class="btn" type="button" value="목록보기" onclick="location.href='${root}/qna/qnalist.self'">
						</p>
					</li>
				</ul> --%>
				<div class="container">
					<table class="table table-hover">
						<tbody>
						<tr>
							<td>작성자</td>
							<td>
								<input type="text" name="name">
							</td>
						</tr>
						<tr>
							<td>제목</td>
							<td>
								<input type="text" name="subject">
							</td>
						</tr>
						<tr>
							<td>학번</td>
							<td>
								<input type="text" name="stu_number" >
							</td>
						</tr>
						<tr class="long">
							<td>내용</td>
							<td>
								<textarea rows="10" cols="10" name="content"></textarea>
							</td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td>
								<input type="password" name="password">
							</td>
						</tr>
						
						<tr>
							<td>파일명</td>
							<td>
								<input type="file" name="file" size="40" />
							</td>
						</tr>
						
						
						</tbody>
					</table>
					<div align="center">
						<button class="btn btn-outline-warning" type="submit">글쓰기</button>
						<button class="btn btn-outline-danger" type="reset">다시 작성</button>
						<button class="btn btn-outline-dark" type="button" onclick="location.href='${root}/qna/qnalist.self'">목록보기</button>
					</div>			
				</div>
				
			</form>
		</div>
	</body>
</html>