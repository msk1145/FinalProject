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
</head>
<body>
<c:if test="${bool == 1}">
<script>
$(function(){
	alert('수정 완료');
});
</script>
</c:if>
	<!-- 헤더 영역 -->
	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

	<!-- 메뉴 영역 -->
	<div class="col-md-2">
		<jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>
	</div>
	
	
	<div class="col-md-10">
		<div class="container">
			<!-- 여기가 컨텐츠 영역 -->
			<h2 class="text-center">회원 정보</h2>
			<form class="form-horizontal" action="memberdetail" method="post">
				<label for="userid" class="control-label">아이디</label><br/> 
				<input type="text" value="${member.userid}" name="userid" id="userid" class="form-control" placeholder="userid" readonly><br/><br/> 
				<label for="password" class="control-label">비밀번호</label><br/> 
				<input type="text" value="${member.password}" name="password" id="password" class="form-control" placeholder="Password"><br/><br/>
				<label for="email" class="control-label">이메일</label><br/>
				<input type="text" value="${member.email}" name="email" id="email" class="form-control" placeholder="Email"><br/><br/>
				<label for="nickname" class="control-label">닉네임</label><br/>
				<input type="text" value="${member.nickname}" name="nickname" id="nickname" class="form-control" placeholder="NickName"><br/> <br/>
				<button type="submit" class="btn btn-success">수정</button>
				<br/><br/>
			</form>
			<button class="btn btn-danger" id="btn-delete">계정 삭제</button>
		</div>
	</div>

<script>
// TODO: 내일 하자 여기서
$(function(){
	$('#btn-delete').click(function(){
		var check = confirm("정말 삭제 하시겠습니까");
		if(check){
			location = '/project/member/memberdelete?userid='+ $('#userid').val();
		}
	});
});
</script>
</body>
</html>


