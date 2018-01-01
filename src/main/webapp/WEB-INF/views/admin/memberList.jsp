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
	<div class="col-md-12">
		<jsp:include page="top.jsp"></jsp:include>
	</div>

	<div class="col-md-2">
		<jsp:include page="side.jsp"></jsp:include>
	</div>
	
	<div class="col-md-10 contentsArea">

		<div class="container">
			<h2 class="text-center">회원 리스트</h2>
			<table class="table table-hover" id="tableStyle">
				<thead>
					<tr>
						<th>아이디</th>
						<th>비밀번호</th>
						<th>이메일</th>
						<th>닉네임</th>
						<th>등급</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="m" items="${member}">
						<tr class="text-center text-info"
							onClick="location.href='/project/admin/memberdetail?userid=${m.userid}'"
							style="cursor: pointer;">
							<td>${m.userid}</td>
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

	<div class="col-md-12">
		<jsp:include page="bottom.jsp"></jsp:include>
	</div>
</body>
</html>