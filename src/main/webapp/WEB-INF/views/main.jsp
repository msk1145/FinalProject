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
					<li><a href="member/memberlogout">로그아웃</a></li>
					<li><a href="member/memberdetail?userid=${member.userid}">회원정보</a></li>
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
			<div class="col-md-12">
				<ul class="list-group">
					<c:forEach var="m" items="${menu}">
						<li class="list-group-item"><a
							href="board/boardmain?category=${m.href}"
							class="list-group-item list-group-item-action btn-info">${m.menuname}</a>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>

		<div class="col-md-10">
			<c:forEach var="boardTbl" items="${board}">
			<div class="col-md-6">
				<h2 class="text-center">
				<c:forEach var="data" begin="1" end="1" items="${boardTbl}">
					${data.menuname}
				</c:forEach>
				</h2>
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
						<c:forEach var="data" items="${boardTbl}">
							<tr class="text-center text-info"
								onClick="location.href='http://www.opnaratv.com/'"
								style="cursor: pointer;">
								<td>${data.bno}</td>
								<td>${data.title}</td>
								<td>admin</td>
								<td>${data.count}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			</c:forEach>

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
						<tr class="text-center text-info">
							<td>fbno</td>
							<td>ftitle</td>
							<td>fuserid</td>
							<td>fcount</td>
						</tr>
						<tr class="text-center text-info">
							<td>fbno</td>
							<td>ftitle</td>
							<td>fuserid</td>
							<td>fcount</td>
						</tr>
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


</body>
</html>