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
<c:if test="${result > 0 or not empty result}">
<script>
alert('회원 삭제 완료!');
</script>
</c:if>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/project/admin/main">Home</a>
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
				<li class="list-group-item"><a href="#"
					class="list-group-item list-group-item-action btn-info">게시물등록</a></li>
			</ul>
		</div>
		<div class="col-md-10">
			
			<div class="container">
				<h2 class="text-center">회원 리스트</h2>
				<table class="table table-striped table-hover">
					<thead>
						<tr class="warning">
							<th>아이디</th>
							<th>비밀번호</th>
							<th>이메일</th>
							<th>닉네임</th>
							<th>등급</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="m" items="${member}">
						<tr>
							<td><a href="memberdetail?userid=${m.userid}">${m.userid}</a></td>
							<td>${m.password}</td>
							<td>${m.email}</td>
							<td>${m.nickname}</td>
							<td>${m.grade}</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>


	</div>
</body>
</html>