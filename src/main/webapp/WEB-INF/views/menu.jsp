<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
body {
	color: #F2FBEF;
	background-color: #1C1C1C;
}

#ulStyle {
	height: 40px;
	width: 1300px;
	cursor: pointer;
	display: inline-block;
}

#ulStyle li {
	list-style: none;
	color: white;
	line-height: 50px;
	text-align: center;
}

#ulStyle .liStyle {
	text-decoration: none;
	color: white;
	width: 150px;
	font-size: 15px;
	font-weight: bold;
}

#ulStyle .liStyle:hover {
	color: #FA5858;
	background-color: #4d4d4d;
}
</style>
</head>
<body>
	<div class="col-md-12">
		<ul id="ulStyle">
			<c:forEach var="m" items="${menu}">
				<li class="liStyle"
					onclick="location.href='/project/board/boardmain?category=${m.href}'">${m.menuname}</li>
			</c:forEach>
		</ul>
		<div class="col-md-12">
			<jsp:include page="/WEB-INF/views/chat.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>