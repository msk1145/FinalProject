<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>main</title>


</head>
<body>

	<!-- 스크립트 &amp; CSS 영역 -->
	<jsp:include page="/WEB-INF/views/styleNscript.jsp"></jsp:include>
	
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
	<div class="col-md-2 menuArea">
		<jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>
	</div>
	<script src="<c:url value='/resources/js/logininterceptor.js'/>"></script>
	
	<div class="col-md-10 contentsArea">
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
	
	<div class="col-md-12 footerArea">
		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
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


