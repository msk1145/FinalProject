<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
<!-- 1. Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />

<!-- jQuery 3.2.1 라이브러리 사용 -->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<!-- 3. Bootstrap JavaScript -->
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body style="color: #F2FBEF;
	background-color: #1C1C1C;">

	
	<div class="form-group" id="contentstSuccess" ><br/>
	<input type="hidden" id="userid" name="userid" value="아이유"><br/>
	
	<div id="msg"  style="overflow:scroll; width: 300px; height: 300px; border: 1px solid black;">
	
	</div>
	<br/>
	<input type="text" style="color: #F2FBEF;background-color: #1C1C1C;" name="contents" id="contents" ></textarea>
	</div>
	<button class="btn-info" id="btn-chat">보내기</button>
	
<script>
$(function(){
	$('#btn-chat').click(function(){
		if($('#contents').val() == "" || $('#contents').val() == null){
			$('#contents').val("");
			$('#contents').prop('placeholder', '보낼 메세지를 입력하세요!!!');
			$('#contentsSuccess').prop('class','form-group has-error');
			$('#btn-insert')
		}else{
			$.ajax({
				 url : "/project/chat/insert"
				,type : "get"
				,data : { 
						  userid : $('#userid').val(),
						  contents : $('#contents').val()
				},
				success : function(res, status, xhr){
					$('#msg').html(res);
				}
			});
		}
	});
	
	
});
</script>


</body>
</html>