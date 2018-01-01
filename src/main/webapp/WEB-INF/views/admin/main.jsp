<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Adminmain</title>

<!-- 1. Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />

<!-- 2. jQuery : Bootstrap JS 파일은 jQuery 라이브러리를 사용 -->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<!-- 3. Bootstrap JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- jQuery 3.2.1 라이브러리 사용 -->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<style>
#layer{
  position:absolute;
  top:100%;
  left:10%;
  width:1000px;
  height:300px;
  margin:-50px 0 0 -50px;
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
		<div class="container">
			<br />
			<br />
			<br />
			<br />
			<div id="layer">
				<h1 class="text-center">WillKoreans</h1>
			</div>
		</div>

	</div>

	<div class="col-md-12">
		<jsp:include page="bottom.jsp"></jsp:include>
	</div>



</body>
</html>