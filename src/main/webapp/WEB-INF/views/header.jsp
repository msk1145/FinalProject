<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
				<li><a href="/project/member/memberlogout">로그아웃</a>
				<li><a href="/project/member/memberdetail?userid=${member.userid}">회원 정보</a></li>
			</c:if>
			<c:if test="${empty member}">
				<li><a id="btn-findId" style="cursor: pointer;">아이디 찾기</a></li>
				<li><a id="btn-findPw" style="cursor: pointer;">비밀번호 찾기</a></li>
				<li><a id="btn-login" style="cursor: pointer;">로그인</a></li>
				<li><a id="btn-insert" style="cursor: pointer;">회원가입</a></li>
			</c:if>
			</ul>
		</div>
	</nav>
	
	<div class="jumbotron text-center">
		<h2>Main</h2>
	</div>

</body>
</html>