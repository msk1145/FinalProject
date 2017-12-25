<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>main</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="<c:url value='/resources/js/memberFindPw.js'/>"></script>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/project/">Home</a>
			</div>
		</div>
	</nav>
	<!-- 메뉴 영역 -->
	<div class="col-md-2">
		<jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>
	</div>
	
	<div class="col-md-10">

		<h2 class="text-center">비밀번호 찾기</h2>
		<div class="container">
			<!-- 여기가 컨텐츠 영역 -->
			<form method="post" action="memberfindinfo" id="findPwForm">
				<div class="form-group" id="idSuccess">
					<label class="control-label" for="userid">가입하신 아이디</label><br/>
					<input type="text" class="form-control" id="userid" name="userid" placeholder="아이디를 입력하세요.." required><br/><br/>
				</div>
				
				<div class="form-group" id="emailSuccess">
					<label class="control-label" for="email" >이메일</label><br/>
				<input type="email" class="form-control" id="email"	name="email" placeholder="이메일 입력하세요.." required>
				</div>
				
				<div id="authNumberSuccess">
					<button type="button" class="btn btn-info" id="getAuthNumber">인증번호 받기</button><br/><br/>
				</div>
				
				<div class="form-group">
					<input type="number" class="form-control" id="authNumber" placeholder="인증번호를 입력하세요.." readonly>
				</div>
				
				<input type="hidden" id="sendedAuthNumber" />
				<button type="button" class="btn btn-success" id="searchPw">비밀번호 찾기</button>
			</form>
		</div>
	</div>

</body>
</html>