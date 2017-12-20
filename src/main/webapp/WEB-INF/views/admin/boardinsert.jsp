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
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="main">Home</a>
				</div>
				<div class="navbar-header pull-right">
					<a class="navbar-brand" href="logout">나가기</a>
				</div>
			</div>
		</div>
	</nav>
	<div class="jumbotron text-center">
		<h2>Main</h2>
	</div>
	<div>
		<div class="col-md-2">
			<ul class="list-group">
				<li class="list-group-item"><a href="memberList"
					class="list-group-item list-group-item-action btn-info">회원관리</a></li>
				<li class="list-group-item"><a href="/project/admin/boardinsert"
					class="list-group-item list-group-item-action btn-info">게시물등록</a></li>
				<li class="list-group-item"><a href="boardList"
					class="list-group-item list-group-item-action btn-info">게시물 수정/삭제</a></li>
				<li class="list-group-item"><a href="menuList"
					class="list-group-item list-group-item-action btn-info">메뉴 카테고리 추가</a></li>			
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
					<label for="title">게시판 선택</label>
				</div>
				<div class="col-md-11">
					<select class="form-control" name="category">
						<c:forEach var="m" items="${menu}">
							<option value="${m.href}">${m.menuname}</option>
						</c:forEach>
					</select>
				</div>
				<br />

				<div class="col-md-1">
					<label for="title">제 목</label>
				</div>
				<div class="col-md-11">
					<input class="form-control" type="text" name="title" id="title"
						required />
				</div>
				<br />


				<div class="col-md-1">
					<label for="content">본문</label><br />
				</div>
				<div class="col-md-11">
					<textarea style="resize: none;" rows="10" class="form-control"
						name="content" id="content" required></textarea>

				</div>
				<br />

				<div class="col-md-12">
					<span class="pull-right">이미지파일</span> <input class="pull-right"
						type="file" name="imageFile" placeholder="이미지파일 선택" />
				</div>

				<div class="col-md-12">
					<span class="pull-right">동영상파일</span> <input class="pull-right"
						type="file" name="videoFile" placeholder="동영상파일 선택"
						value="파일선택하라고시발놈아" />
				</div>
				<br /> <br /> <br />
				<hr />
				<div>
					<button type="submit" class="btn btn-default pull-right">등록</button>
				</div>
			</form>
		</div>
	</div>





</body>
</html>