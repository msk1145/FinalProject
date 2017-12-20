<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		<h2>관리자 페이지</h2>
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
			<form action="boardList" method="post" id="submit">
				<select class="form-control" id="select" name="category">
					<c:forEach var="c" items="${menu}">
						<c:if test="${selectedCategory eq c.href}">
							<option  id="selectvalue" value="${c.href}" selected>${c.menuname}</option>
						</c:if>
						<c:if test="${selectedCategory ne c.href}">
							<option  id="selectvalue" value="${c.href}">${c.menuname}</option>
						</c:if>
					</c:forEach>
					
				</select>
			</form>
			<table class="table table-striped table-hover">
				<thead>
					<tr class="warning">
						<th>게시글 번호</th>
						<th>제목</th>
						<th>작성날짜</th>
						<th>조회수</th>
						<th>카테고리</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="b" items="${board}">
						<tr class="text-center text-info"
								onClick="location.href='/project/admin/boardDetail?bno=${b.bno}&category=${b.category}'"
								style="cursor: pointer;">
							<td>${b.bno}</td>
							<td>${b.title}</td>
							<td><fmt:formatDate value="${b.regdate}" pattern="yyyy년 MM월 dd일 kk시 mm분 ss초"/> </td>
							<td>${b.count}</td>
							<td>${b.category}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
<script>
$(function(){
	$('#select').change(function(){
		$('#submit').submit();
	});
});
</script>
</body>
</html>