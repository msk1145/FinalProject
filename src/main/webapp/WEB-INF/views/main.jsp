<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>main</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="<c:url value='/resources/js/logininterceptor.js'/>"></script>
<style type="text/css">
.footer {
	position: absolute;
	bottom: 0;
	width: 100%;
	height: 50px;
	background: #a3c2c2;
	text-align: center;
}
</style>
</head>


<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/project">Home</a>
			</div>
			<ul class="nav navbar-nav pull-right">
				<c:if test="${not empty member}">
					<li><a>${member.nickname}님 </a></li>
					<li><a href="member/memberdetail?userid=${member.userid}">회원
							정보</a></li>
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
				<li class="list-group-item"><a
					href="board/boardmain?category=movie"
					class="list-group-item list-group-item-action btn-info">영화</a></li>
				<li class="list-group-item"><a
					href="board/boardmain?category=drama"
					class="list-group-item list-group-item-action btn-info">드라마</a></li>
				<li class="list-group-item"><a
					href="board/boardmain?category=animation"
					class="list-group-item list-group-item-action btn-info">애니메이션</a></li>
				<li class="list-group-item"><a
					href="board/boardmain?category=variety"
					class="list-group-item list-group-item-action btn-info">예능</a></li>
				<li class="list-group-item"><a href=""
					class="list-group-item list-group-item-action btn-info">자유게시판</a></li>
			</ul>
		</div>
		<div class="col-md-10">
			<div class="col-md-6">
				<h2 class="text-center">영화</h2>
				<table class="table table-bordered table-hover table-condensed">
					<thead>
						<tr class="text-danger">
							<th class="text-center col-md-1">글번호</th>
							<th class="text-center col-md-5">제목</th>
							<th class="text-center col-md-3">글쓴이</th>
							<th class="text-center col-md-3">조회수</th>
						</tr>
					</thead>
					<tbody>
						<tr class="text-center text-info">
							<td>bno</td>
							<td>title</td>
							<td>userid</td>
							<td>count</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="col-md-6">
				<h2 class="text-center">드라마</h2>
				<table class="table table-bordered table-hover table-condensed">
					<thead>
						<tr class="text-danger">
							<th class="text-center col-md-1">글번호</th>
							<th class="text-center col-md-5">제목</th>
							<th class="text-center col-md-3">글쓴이</th>
							<th class="text-center col-md-3">조회수</th>
						</tr>
					</thead>
					<tbody>
						<tr class="text-center text-info">
							<td>bno</td>
							<td>title</td>
							<td>userid</td>
							<td>count</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="col-md-10">
			<div class="col-md-6">
				<h2 class="text-center">애니메이션</h2>
				<table class="table table-bordered table-hover table-condensed">
					<thead>
						<tr class="text-danger">
							<th class="text-center col-md-1">글번호</th>
							<th class="text-center col-md-5">제목</th>
							<th class="text-center col-md-3">글쓴이</th>
							<th class="text-center col-md-3">조회수</th>
						</tr>
					</thead>
					<tbody>
						<tr class="text-center text-info">
							<td>bno</td>
							<td>title</td>
							<td>userid</td>
							<td>count</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="col-md-6">
				<h2 class="text-center">예능</h2>
				<table class="table table-bordered table-hover table-condensed">
					<thead>
						<tr class="text-danger">
							<th class="text-center col-md-1">글번호</th>
							<th class="text-center col-md-5">제목</th>
							<th class="text-center col-md-3">글쓴이</th>
							<th class="text-center col-md-3">조회수</th>
						</tr>
					</thead>
					<tbody>
						<tr class="text-center text-info">
							<td>bno</td>
							<td>title</td>
							<td>userid</td>
							<td>count</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="col-md-10">
			<div class="col-md-6">
				<h2 class="text-center">자유게시판</h2>
				<table class="table table-bordered table-hover table-condensed">
					<thead>
						<tr class="text-danger">
							<th class="text-center col-md-1">글번호</th>
							<th class="text-center col-md-5">제목</th>
							<th class="text-center col-md-3">글쓴이</th>
							<th class="text-center col-md-3">조회수</th>
						</tr>
					</thead>
					<tbody>
						<tr class="text-center text-info">
							<td>fbno</td>
							<td>ftitle</td>
							<td>fuserid</td>
							<td>fcount</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="footer">
		<span> <h3>(주)Sex Power</h3> </span>
	</div>


</body>
</html>