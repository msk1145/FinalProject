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
				<a class="navbar-brand" href="#">Home</a>
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
			<div class="col-md-6">
				<h2 class="text-center">영화</h2>
				<table class="table table-bordered table-hover table-condensed">
					<thead>
						<tr class="text-danger">
							<th class="text-center col-md-1">메뉴1</th>
							<th class="text-center col-md-5">메뉴2</th>
							<th class="text-center col-md-3">메뉴3</th>
							<th class="text-center col-md-3">메뉴4</th>
						</tr>
					</thead>
					<tbody>
						<tr class="text-center text-info">
							<td>값1</td>
							<td>값2</td>
							<td>값3</td>
							<td>값4</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="col-md-6">
				<h2 class="text-center">드라마</h2>
				<table class="table table-bordered table-hover table-condensed">
					<thead>
						<tr class="text-danger">
							<th class="text-center col-md-1">메뉴1</th>
							<th class="text-center col-md-5">메뉴2</th>
							<th class="text-center col-md-3">메뉴3</th>
							<th class="text-center col-md-3">메뉴4</th>
						</tr>
					</thead>
					<tbody>
						<tr class="text-center text-info">
							<td>값1</td>
							<td>값2</td>
							<td>값3</td>
							<td>값4</td>
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
							<th class="text-center col-md-1">메뉴1</th>
							<th class="text-center col-md-5">메뉴2</th>
							<th class="text-center col-md-3">메뉴3</th>
							<th class="text-center col-md-3">메뉴4</th>
						</tr>
					</thead>
					<tbody>
						<tr class="text-center text-info">
							<td>값1</td>
							<td>값2</td>
							<td>값3</td>
							<td>값4</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="col-md-6">
				<h2 class="text-center">예능</h2>
				<table class="table table-bordered table-hover table-condensed">
					<thead>
						<tr class="text-danger">
							<th class="text-center col-md-1">메뉴1</th>
							<th class="text-center col-md-5">메뉴2</th>
							<th class="text-center col-md-3">메뉴3</th>
							<th class="text-center col-md-3">메뉴4</th>
						</tr>
					</thead>
					<tbody>
						<tr class="text-center text-info">
							<td>값1</td>
							<td>값2</td>
							<td>값3</td>
							<td>값4</td>
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
							<th class="text-center col-md-1">메뉴1</th>
							<th class="text-center col-md-5">메뉴2</th>
							<th class="text-center col-md-3">메뉴3</th>
							<th class="text-center col-md-3">메뉴4</th>
						</tr>
					</thead>
					<tbody>
						<tr class="text-center text-info">
							<td>값1</td>
							<td>값2</td>
							<td>값3</td>
							<td>값4</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>