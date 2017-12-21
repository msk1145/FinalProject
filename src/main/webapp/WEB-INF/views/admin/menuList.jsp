<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Adminmain</title>

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
				<a class="navbar-brand" href="main">Home</a>
			</div>
			<div class="navbar-header pull-right">
				<a class="navbar-brand" href="logout">나가기</a>
			</div>
		</div>

	</nav>
	<div class="jumbotron text-center">
		<h2>AdminMain</h2>
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
			<div class="container">
				<h2 class="text-center">메뉴 리스트</h2>
				<table class="table table-striped table-hover">
					<thead>
						<tr class="warning">
							<th>메뉴 번호</th>
							<th>메뉴 이름</th>
							<th>활성/비활성</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="m" items="${menu}">
						<tr>
							<td><a href="menuUpdate?mnum=${m.mnum}">${m.mnum}</a></td>
							<td><a href="menuUpdate?mnum=${m.mnum}">${m.menuname}</a></td>
							<td><a href="menuUpdate?mnum=${m.mnum}">${m.hideandshow}</a></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				
				<a class="btn btn-info" href="menuInsert">새로운 메뉴 넣기</a>

			</div>
		</div>


	</div>
</body>
</html>