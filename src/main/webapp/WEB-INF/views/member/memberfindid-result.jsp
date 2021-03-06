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
	
	<div class="col-md-10 contentsArea">
		<h2 class="text-center">아이디 찾기 결과</h2>
		<div class="container">
			<!-- 여기가 컨텐츠 영역 -->
			<div style="border-top: 4px solid #1B4C74; border-bottom: 2px solid #D9D8D6; margin: 20px; padding: 20px;">
			<ul style="font-size: 20px; list-style-type: none;">
				<li><strong></strong>아이디는 ${member.userid} 입니다.</li>
			</ul>
			</div>
			<div class="text-center">
			<a class="btn btn-danger" href="/project/member/memberlogin?url=/project/">로그인하러가기</a>
			<a class="btn btn-success" href="memberfindpw">비밀번호 찾기</a>
			</div>
		</div>
	</div>
	<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/> 
	<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>  
	<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>  
	<br/><br/><br/><br/><br/><br/><br/>
	
	 
	
	<div class="col-md-12" style="padding: 0px;">
		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	</div>
	
</body>
</html>