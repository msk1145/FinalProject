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
	
	<!-- 헤더 영역 -->
	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	
	<!-- 메뉴 영역 -->
	<div class="col-md-2 menuArea">
		<jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>
	</div>

	<script src="<c:url value='/resources/js/memberinsertcheck.js'/>"></script>
	
	<div class="col-md-10 contentsArea">

		<h2 class="text-center">회 원 가 입</h2>
		<div class="container">
			<!-- 여기가 컨텐츠 영역 -->
			<form method="post" action="memberinsert-post">
				<div class="form-group" id="idSuccess">
					<label class="control-label" id="userid" for="inputSuccess1">아이디</label><br/>
					<input type="text" class="form-control" id="idCheck" name="userid" placeholder="아이디 입력..." required><br/><br/>
				</div>
				
				<div class="form-group" id="pwSuccess">
					<label class="control-label" for="password">비밀번호</label><br/>
					<input type="password" class="form-control" id="password" name="password" placeholder="비밀번호 입력..." required><br/><br/>
					<label class="control-label" for="passwordCheck">비밀번호확인</label><br/>
					<input type="password" class="form-control" id="passwordCheck" placeholder="비밀번호 확인 입력..." required><br/><br/>
				</div>
				
				<div class="form-group" id="emailSuccess">
					<label class="control-label" for="email1" >이메일</label><br/>
					<input type="text" class="form-control" id="email1" placeholder="이메일 아이디입력.." required>
					@<br/>
					<div class="col-xs-6">
					<input type="text" class="form-control" id="email2" placeholder="도메인 입력.." required readonly>
					</div>
					<div class="col-xs-6">
					<select class="form-control" id="selectedEmail">
						<option value="0" selected>선택하세요</option>
						<option value="1">직접입력</option>
						<option value="naver.com">naver.com</option>
						<option value="daum.net">daum.net</option>
						<option value="google.com">google.com</option>
						<option value="nate.com">nate.com</option>
					</select>
					</div>					

					<input type="hidden" id="email" name="email" style="color: black;" />
				</div>
				<br/><br/>
				
				<div class="form-group" id="nicknameSuccess">
				<label class="control-label" for="nickname">닉네임</label><br/>
				<input type="text" class="form-control" id="nickname" name="nickname" placeholder="닉네임 입력..." required><br/><br/>
				</div>
				
				<input type="hidden" name="grade" value="guest"/>
				<input type="hidden" name="url" value="${url}" />
				<input type="submit" id="btnsubmit" value="회원 가입" class="btn btn-success" disabled/>
			</form>
		</div>
	</div>
	
	<div class="col-md-12 footerArea">
		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	</div>
	
	<script>
	$(document).ready(function() {
		// 이메일 선택 박스
		$('#selectedEmail').change(function() {
			var domain = $('#selectedEmail option:selected').val();
			console.log('도메인: ' + domain);
			
			if (domain === '1') {
				$(this).closest('.form-group').find('#email2').attr('readonly', false);
				$(this).closest('.form-group').find('#email2').val('');
			} else if(domain === '0') {
				$(this).closest('.form-group').find('#email2').attr('readonly', true);
				$(this).closest('.form-group').find('#email2').val('');
			} else {
				$(this).closest('.form-group').find('#email2').val(domain);
				$(this).closest('.form-group').find('#email2').attr('readonly', true);
			}
		});
		
		// 이메일 설정
		$('#nickname').focus(function() {
			// 앞 이메일
			var frontEmail = $('#email1').val();
			// 뒤 이메일
			var rearEmail =  $('#email2').val();
			var fullEmail = frontEmail + '@' + rearEmail;
			console.log('full: ' + fullEmail);
			$('#email').val(fullEmail);
		});
		
		
	});
	</script>

</body>
</html>