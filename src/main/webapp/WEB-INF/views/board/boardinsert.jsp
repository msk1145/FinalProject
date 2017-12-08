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
<script src="<c:url value='/resources/js/logininterceptor.js'/>"></script>
<style>
.box {
	margin: 0 auto;
	width: 300px;
	height: 100px;
}
</style>


</head>





<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/project/">Home</a>
			</div>
			<ul class="nav navbar-nav pull-right">
				<c:if test="${not empty member}">
				<li><a>${member.nickname}님 </a></li>
				<li><a href="member/memberdetail?userid=${member.userid}">회원 정보</a></li>
			</c:if>
			<c:if test="${empty member}">
				<li><a id="btn-login">로그인</a></li>
				<li><a id="btn-insert">회원가입</a></li>
			</c:if>
			</ul>
		</div>
	</nav>
	<div class="jumbotron text-center">
		<h2>Main</h2>
	</div>
	<div>
		<div class="col-md-2">
			<ul class="list-group">
				<li class="list-group-item"><a href="boardmain?category=movie"
					class="list-group-item list-group-item-action btn-info">영화</a></li>
				<li class="list-group-item"><a href="boardmain?category=drama"
					class="list-group-item list-group-item-action btn-info">드라마</a></li>
				<li class="list-group-item"><a href="boardmain?category=animation"
					class="list-group-item list-group-item-action btn-info">애니메이션</a></li>
				<li class="list-group-item"><a href="boardmain?category=variety"
					class="list-group-item list-group-item-action btn-info">예능</a></li>
				<li class="list-group-item"><a href=""
					class="list-group-item list-group-item-action btn-info">자유게시판</a></li>
			</ul>
		</div>
		<div class="col-md-10">
			<!-- 여기가 컨텐츠 영역 -->
			<form class="form-vertical" action="boardinsert" method="post"
				enctype="multipart/form-data">
				<div class="box">
					<h3>게시글 작성</h3>
				</div>
				<div class="col-md-1">
					<label for="title">제 목</label>
				</div>
				<div class="col-md-11">
					<input class="form-control" type="text" name="title" id="title"
						required /> <br />
				</div>


				<div class="col-md-1">
					<label for="content">본문</label></br>
				</div>
				<div class="col-md-11">
					<textarea style="resize: none;" rows="10" class="form-control"
						name="content" id="content"></textarea>
					<br />
				</div>
				<div class="col-md-12">
				<input class="pull-right" type="file" name="uploadimage" placeholder="이미지파일 선택" />
				</div>
				<div class="col-md-12">
				<input class="pull-right" type="file" name="uploadmovie" placeholder="동영상파일 선택" value="파일선택하라고시발놈아"/>
				</div>
				
				<div><button type="submit" class="btn btn-default pull-right">Submit</button></div>
				
			</form>


			
	

		</div>




	</div>
</body>
</html>