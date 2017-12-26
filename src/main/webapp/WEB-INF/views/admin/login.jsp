<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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

</head>
<body style="color: #F2FBEF; background-color : #1C1C1C;">
<c:if test="${result eq 1}">
	<script>
		alert('로그인이 필요합니다..');
	</script>
</c:if>
	
	<h2 class="text-center">로그인</h2>
		<div class="container form-group" >
			<form action="login" method="post">
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
   			</form> 			
		</div>
</body>
</html>