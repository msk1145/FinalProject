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
<script src="<c:url value='/resources/js/logininterceptor.js'/>"></script>
<style>
.box {
	margin: 0 auto;
	width: 300px;
	height: 100px;
}
</style>


</head>
<body>
	<div class="col-md-12">
		<jsp:include page="top.jsp"></jsp:include>
	</div>


	<div class="col-md-2">
		<jsp:include page="side.jsp"></jsp:include>
	</div>

	<div class="col-md-10 contentsArea">
		<!-- 여기가 컨텐츠 영역 -->
		<form class="form-vertical" action="boardinsert" method="post"
			enctype="multipart/form-data">
			
			<h2 class="text-center">게시글 작성</h2>

			<div class="col-md-1">
				<label for="title">게시판 선택 ▶</label>
			</div>
			
			<div class="col-md-11">
				<select class="form-control" name="category">
					<c:forEach var="m" items="${menu}">
						<option value="${m.href}">${m.menuname}</option>
					</c:forEach>
				</select>
			</div>
			<br /><br/>
			<br/><br/>

			<div class="col-md-1">
				<label for="title">제 목 ▶</label>
			</div>
			<div class="col-md-11">
				<input class="form-control" type="text" name="title" id="title"
					required />
			</div>
			<br /><br/>
			<br/><br/>


			<div class="col-md-1">
				<label for="content">본 문 ▶</label><br />
			</div>
			<div class="col-md-11">
				<textarea style="resize: none;" rows="10" class="form-control"
					name="content" id="content" required></textarea>
				<br/><br/><br/>
			</div>
			
			
			<div class="col-md-12">
				<span class="pull-right"></span> <input class="pull-right"
					type="file" name="imageFile" placeholder="이미지파일 선택" />
					<h4 class="pull-right">이미지파일 ▶</h4>
					<br/><br/>					
			</div>
			<br/><br/>
			<div class="col-md-12">
				<span class="pull-right"></span> <input class="pull-right"
					type="file" name="videoFile" placeholder="동영상파일 선택"
					value="파일선택하라고시발놈아" />
					<h4 class="pull-right">동영상파일 ▶</h4>
					<br/><br/>
			</div>
			<br /> <br /> <br /><br/>
			<hr />
			<div>
				<button type="submit" class="btn btn-default pull-right">등록</button>
			</div>
		</form>
	</div>

	<div class="col-md-12">
		<jsp:include page="bottom.jsp"></jsp:include>
	</div>
	
</body>
</html>