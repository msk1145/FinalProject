<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/project/">Home</a>
			</div>
		</div>
	</nav>
	<!-- 메뉴 영역 -->
	<div class="col-md-2">
		<jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>
	</div>
	
	<div class="col-md-10">

		<h2 class="text-center">비밀번호 찾기 결과</h2>
		<div class="container">
			<!-- 여기가 컨텐츠 영역 -->
			<div style="border-top: 4px solid #1B4C74; border-bottom: 2px solid #D9D8D6; margin: 20px; padding: 20px;">
			<ul style="font-size: 20px; list-style-type: none;">
				<li><strong></strong>임시비밀번호가 이메일로 전송되었습니다.</li>
			</ul>
			</div>
			<div class="text-center">
			<a class="btn btn-danger" href="/project/member/memberlogin?url=/project/">로그인하러가기</a>
			<a class="btn btn-info" href="/project">홈으로</a>
			</div>
		</div>
	</div>
	
</body>
</html>