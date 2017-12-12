<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>freedetail</title>

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
<style>
.row{
	margin: 10px;
	padding: 10px;
	font-weight: bold;
	font-size: 20px;
}
.contentsTop{
	border-bottom: 2px solid Gainsboro; 
	background-color: #FFFFE9;
}
</style>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/project/">Home</a>
			</div>
			<c:if test="${not empty member}">
				<li><a>${member.nickname}님 </a></li>
				<li><a href="member/memberdetail?userid=${member.userid}">회원 정보</a></li>
			</c:if>
			<c:if test="${empty member}">
				<li><a id="btn-login">로그인</a></li>
				<li><a id="btn-insert">회원가입</a></li>
			</c:if>
		</div>
	</nav>
	<div class="jumbotron text-center">
		<h2>freedetail</h2>
		
	</div>
	
		<div class="col-md-2">
			<ul class="list-group">
					<c:forEach var="m" items="${menu}">
						<li class="list-group-item">
						 <a href="${m.href}" class="list-group-item list-group-item-action btn-info">${m.menuname}</a>
						</li>
					</c:forEach>
			</ul>
		</div>
		<div class="form-group">
			<div class="col-md-10">
				<!-- 여기가 컨텐츠 영역 -->
				<div class="contents">
					<div class="contentsTop">
						<div class="row text-danger">
						 	<div class="col-md-12">
						 		자유게시판
						 	</div>
						</div>
					</div>
					<div class="row">
					 	<div class="col-md-6">
					 		작성자
					 	</div>
					 	<div class="col-md-6 text-right">
					 		현재 게시글 주소
					 	</div>
					</div>
					<div class="row" style="border-bottom: 2px solid Gainsboro;">
					 	<div class="col-md-6">
					 		조회수: 
					 	</div>
					 	<div class="col-md-6 text-right">
					 		날짜
					 	</div>
					</div>
					<div class="row" style="border-bottom: 2px solid Gainsboro;">
					 	<div class="col-md-12">
					 		내용들
					 	</div>
					</div>
					
					<div class="row text-right">
						<div class="col-md-12">
							<a class="btn btn-info">게시물 수정</a>
						</div>
					</div>
		
				</div>
				<!-- 댓글 영역 -->
				<div class="reply">
					<div class="replyTop">
						<div class="row text-danger">
						 	<div class="col-md-12">
						 		댓글목록, 갯수, 조회수
						 	</div>
						</div>
						
						<div class="row" style="border-bottom: 1px dotted Gainsboro;">
						 	<div class="col-md-12">
						 		댓글들
						 	</div>
						</div>
						
						<form class="form-group reply-insert">
							<div class="row">
								<div class="col-md-11">
									<div class="form-group">
							   			<label for="content">댓글내용</label>
							   			<textarea rows="5" cols="100" class="form-control" id="content" 
							   				style="resize:none;">내용들</textarea>
							  		</div>
						  		</div>
								<div class="col-md-1">
									<div class="form-group">
							   			<label for="reply-register"></label>
							   			<a href="#"
										class="list-group-item list-group-item-action btn-info"
										id="reply-register">댓글 등록</a>
							  		</div>
						  		</div>
					  		</div>		  		
			
				  		</form>
					</div>
				</div>
			</div>
			
		</div>
		
		
</body>
</html>