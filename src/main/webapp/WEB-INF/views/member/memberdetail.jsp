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
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/project/">Home</a>
			</div>
			<ul class="nav navbar-nav pull-right">
				<li class=""><a href="#">로그인</a></li>
				<li class=""><a href="#">회원가입</a></li>
			</ul>
		</div>
	</nav>
	<div class="jumbotron text-center">
		<h2>Main</h2>
	</div>
	<div>
		<div class="col-md-2">
			<ul class="list-group">
				<li class="list-group-item"><a href="#"
					class="list-group-item list-group-item-action btn-info">영화</a></li>
				<li class="list-group-item"><a href="#"
					class="list-group-item list-group-item-action btn-info">드라마</a></li>
				<li class="list-group-item"><a href="#"
					class="list-group-item list-group-item-action btn-info">애니메이션</a></li>
				<li class="list-group-item"><a href="#"
					class="list-group-item list-group-item-action btn-info">예능</a></li>
				<li class="list-group-item"><a href="#"
					class="list-group-item list-group-item-action btn-info">자유게시판</a></li>
			</ul>
		</div>
		<div class="col-md-10">
			<div class="container">
				<!-- 여기가 컨텐츠 영역 -->
				<h2 class="text-center">회원 정보</h2>
				<form class="form-horizontal">
					<label for="userid" class="control-label">아이디</label><br/> 
					<input type="text" name="userid" id="userid" class="form-control" placeholder="userid" readonly><br/><br/> 
					<label for="password" class="control-label">비밀번호</label><br/> 
					<input type="text" name="password" id="password" class="form-control" placeholder="Password"><br/><br/>
					<label for="email" class="control-label">이메일</label><br/>
					<input type="text" name="eamil" id="email" class="form-control" placeholder="Email"><br/><br/>
					<label for="nickname" class="control-label">닉네임</label><br/>
					<input type="text" name="nickname" id="nickname" class="form-control" placeholder="NickName"><br/> <br/>
					<button type="submit" class="btn btn-success">수정</button>
					<button class="btn btn-danger">계정 삭제</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>