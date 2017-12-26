<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>main</title>

<!-- 1. Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />

<!-- 2. jQuery : Bootstrap JS 파일은 jQuery 라이브러리를 사용 -->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<!-- 3. Bootstrap JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- jQuery 3.2.1 라이브러리 사용 -->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<!-- 현규. -->
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
	<!-- 헤더 영역 -->
	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

	<!-- 메뉴 영역 -->
	<div class="col-md-2">
		<jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>
	</div>
	
	<div class="col-md-10">
		<!-- 여기가 컨텐츠 영역 -->
		<h2 class="text-center">로그인</h2>
			<div class="container form-group" >
				<form action="memberlogin-post" method="post">
					<label for ="userid"> 아이디 </label>
					<input class="form-control" type="text" name="userid" id="userid" required />
	   			 	<br/>
	   			 	<label for = "password"> 비밀번호 </label>
	   			 	<input class="form-control" type="password" name="password" id="password" required />
	   			 	<input type="hidden" name="url" value="${url}" />
	   				<br/>
	   				<div class="col-md-1">
	   					<input class="form-control btn btn-success" type="submit" value="로그인" />
	   				</div>
	   				<a class="btn btn-info" href="memberinsert?url=${url}">회원 가입</a>
	   			</form> 			
			</div>
	</div>
</body>
</html>