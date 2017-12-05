<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
<!-- jQuery 3.2.1 라이브러리 사용 -->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
</head>
<body>
<h1>회원 가입</h1>

<form action="insert" method="post">
<br/><input type="text" name="userid" id="idCheck" placeholder="아이디 입력..." required />
<br/><input type="password" name="password" placeholder="비밀번호 입력..." required />
<br/><input type="email" name="email" placeholder="이미지 입력..." required />
<br/><input type="text" name="nickname" placeholder="닉네임 입력..." required />
<br/><input type="submit" value="회원 가입" />
</form>


<!-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ -->
<!-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ -->
<!-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ -->
<!-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ -->
<!-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ -->
<!-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ -->

<script>
$(function(){
	$('#idCheck').change(function(){
		$.ajax({
			 url : "idCheck"
			,type : "post"
			,data : { userid : $('#idCheck').val() }
			,success : function(res, status, xhr){
				if(res){ // 아이디 중복
					alert('아이디 생성 불가');
					$('#btnIdcheck').prop('disabled', true);
				}else{ // 아이디 중복되지 않음
					alert('아이디 생성 가능');
					$('#btnIdcheck').prop('disabled', false);
				}
			}
		})
	});
});
</script>

</body>
</html>