<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>update</title>

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
				<li><a href="/project/member/memberdetail?userid=${member.userid}">회원 정보</a></li>
			</c:if>
			<c:if test="${empty member}">
				<li><a id="btn-login">로그인</a></li>
				<li><a id="btn-insert">회원가입</a></li>
			</c:if>
			</ul>
		</div>
	</nav>
	<div class="jumbotron text-center">
		<h2>update</h2>
		
	</div>
	
		<div class="col-md-2">
			<ul class="list-group">
					<c:forEach var="m" items="${menu}">
						<li class="list-group-item">
						 <a href="/project/board/boardmain?category=${m.href}" class="list-group-item list-group-item-action btn-info">${m.menuname}</a>
						</li>
					</c:forEach>
			</ul>
		</div>
		<div class="col-md-10">
			<!-- 여기가 컨텐츠 영역 -->
			<div style="border-top: 2px solid Gainsboro; padding: 10px;"></div>
		 	<form>
				  <div class="form-group">
				    <label for="title">제목</label>
				    <input type="text" class="form-control" id="title" value="${boardContents.title}">
				  </div>
				  <div class="form-group">
				    <label for="category">장르</label>
				    <input type="text" class="form-control" id="category" value="${boardContents.category}">
				  </div>
				   <div class="form-group">
				    <label for="userid">운영자</label>
				   <input type="text" class="form-control" id="userid" value="admin" readonly>
				  </div>
				  <div class="form-group">
				    <label for="content">내용</label>
				   <textarea rows="5" cols="200" class="form-control" id="content"
				   		style="resize:none;">${boardContents.content}</textarea>
				  </div>
				  
				  <div class="form-group text-right">
				  	<button type="submit" class="btn btn-success">수정완료</button>
				  	<a class="btn btn-danger">삭제</a>
				  </div>
			</form>
			<div style="border-bottom: 2px solid Gainsboro; padding: 10px;"></div>

		</div>
</body>
</html>