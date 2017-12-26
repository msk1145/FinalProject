<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Adminmain</title>

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
</head>
<body>
	<div class="col-md-12">
		<jsp:include page="top.jsp"></jsp:include>
	</div>


	<div class="col-md-2">
		<jsp:include page="side.jsp"></jsp:include>
	</div>

	<div class="col-md-10">
		<div class="container">
			<form action="memberUpdate" method="post">
				<div class="form-group">
					<label for="userid">아이디▼</label> <input type="text"
						class="form-control" name="userid" id="userid"
						value="${member.userid}" />
				</div>
				<div class="form-group">
					<label for="password">비밀번호▼</label> <input type="text"
						class="form-control" name="password" id="password"
						value="${member.password}" />
				</div>
				<div class="form-group">
					<label for="email">이메일▼</label> <input type="text"
						class="form-control" name="email" id="email"
						value="${member.email}" />
				</div>
				<div class="form-group">
					<label for="nickname">별명▼</label> <input type="text"
						class="form-control" name="nickname" id="nickname"
						value="${member.nickname}" />
				</div>

				<div class="form-group">
					<input type="submit" class="btn btn-success" value="정보수정" />
				</div>

			</form>
			<form action="memberGradeUpdate" method="post">
				<div class="form-group">
					<label for="grade">등급▼</label> <select name="grade"
						class="form-control" id="grade">
						<option value="guest">회원</option>
						<option value="admin">관리자</option>
					</select>
				</div>
				<div class="form-group">
					<input type="hidden" name="userid" value="${member.userid}" />
				</div>
				<div class="form-group">
					<input type="submit" class="btn btn-info" value="등급 수정" />
				</div>
			</form>
			<div class="form-group">
				<a href="memberdelete?userid=${member.userid}"
					class="btn btn-danger">삭제하기</a>
			</div>
		</div>
	</div>

	<div class="col-md-12">
		<jsp:include page="bottom.jsp"></jsp:include>
	</div>

</body>
</html>








