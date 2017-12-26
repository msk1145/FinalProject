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
	<div class="col-md-12">
		<jsp:include page="top.jsp"></jsp:include>
	</div>

	<div class="col-md-2">
		<jsp:include page="side.jsp"></jsp:include>
	</div>
	
	<div class="col-md-10">
		<!-- 여기가 컨텐츠 영역 -->
		<form class="form-vertical" action="boardFreeUpdate" method="post"
			enctype="multipart/form-data">
			<div class="box">
				<h3 class="text-center">게시글 수정 및 삭제</h3>
			</div>
			<input type="hidden" name="fbno" value="${board.fbno}" /> 
			<label for="title">제 목▼</label> 
			<input class="form-control" type="text"	name="ftitle" id="title" value="${board.ftitle}" required /> 
			<label for="content">본문▼</label><br />
			<textarea style="resize: none;" rows="20" class="form-control"
				name="fcontent" id="content" required>${board.fcontent}</textarea>
			<br /> <br />
			<a class="btn btn-danger pull-right" href="boardFreeDelete?fbno=${board.fbno}">삭제</a>
			<button type="submit" class="btn btn-info pull-right">수정</button>

		</form>

	</div>
	
	<div class="col-md-12">
		<jsp:include page="bottom.jsp"></jsp:include>
	</div>
</body>
</html>