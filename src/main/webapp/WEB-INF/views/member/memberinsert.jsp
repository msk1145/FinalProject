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
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="<c:url value='/resources/js/memberinsertcheck.js'/>"></script>
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

		<h2 class="text-center">회 원 가 입</h2>
		<div class="container">
			<!-- 여기가 컨텐츠 영역 -->
			<form method="post" action="memberinsert-post">
				<div class="form-group" id="idSuccess">
					<label class="control-label" id="userid" for="inputSuccess1">아이디</label><br/>
					<input type="text" class="form-control" id="idCheck" name="userid" placeholder="아이디 입력..." required><br/><br/>
				</div>
				
				<div class="form-group" id="pwSuccess">
					<label class="control-label" for="password">비밀번호</label><br/>
					<input type="password" class="form-control" id="password" name="password" placeholder="비밀번호 입력..." required><br/><br/>
					<label class="control-label" for="passwordCheck">비밀번호확인</label><br/>
					<input type="password" class="form-control" id="passwordCheck" placeholder="비밀번호 확인 입력..." required><br/><br/>
				</div>
				
				<div class="form-group" id="emailSuccess">
					<label class="control-label" for="email" >이메일</label><br/>
					<input type="text" class="form-control" id="email" name="email" placeholder="이메일 입력1..." required>
				</div>
				<br/><br/>
				
				<div class="form-group" id="nicknameSuccess">
				<label class="control-label" for="nickname">닉네임</label><br/>
				<input type="text" class="form-control" id="nickname" name="nickname" placeholder="닉네임 입력..." required><br/><br/>
				</div>
				
				<input type="hidden" name="grade" value="guest"/>
				<input type="hidden" name="url" value="${url}" />
				<input type="submit" id="btnsubmit" value="회원 가입" class="btn btn-success" disabled/>
			</form>
		</div>
	</div>

</body>
</html>