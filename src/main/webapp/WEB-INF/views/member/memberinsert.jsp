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
			<ul class="nav navbar-nav pull-right">
				<li><a href="memberlogin?url=${url}">로그인</a></li>
			</ul>
		</div>
	</nav>
	<div class="jumbotron text-center">
		<h2>Main</h2>
	</div>
	<div>
		<div class="col-md-2">
			<ul class="list-group">
				<li class="list-group-item"><a href="board/boardmain?category=movie"
					class="list-group-item list-group-item-action btn-info">영화</a></li>
				<li class="list-group-item"><a href="board/boardmain?category=drama"
					class="list-group-item list-group-item-action btn-info">드라마</a></li>
				<li class="list-group-item"><a href="board/boardmain?category=animation"
					class="list-group-item list-group-item-action btn-info">애니메이션</a></li>
				<li class="list-group-item"><a href="board/boardmain?category=variety"
					class="list-group-item list-group-item-action btn-info">예능</a></li>
				<li class="list-group-item"><a href=""
					class="list-group-item list-group-item-action btn-info">자유게시판</a></li>
			</ul>
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
					
					<label class="control-label" id="email" for="inputSuccess1">이메일</label><br/>
					<input type="text" class="form-control" id="email"	name="email" placeholder="이메일 입력..." required><br/><br/>
					
					<label class="control-label" id="nickname" for="inputSuccess1">닉네임</label><br/>
					<input type="text" class="form-control" id="nickname" name="nickname" placeholder="닉네임 입력..." required><br/><br/>
					<input type="hidden" name="grade" value="guest"/>
					<input type="hidden" name="url" value="${url}" />
					<input type="submit" id="btnsubmit" value="회원 가입" class="btn btn-success"/>
				</form>
			</div>
		</div>
	</div>
</body>
</html>