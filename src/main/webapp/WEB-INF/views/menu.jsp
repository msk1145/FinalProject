<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 1. Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
</head>
<body>
	<ul class="list-group">
		<c:forEach var="m" items="${menu}">
			<li class="list-group-item"><a
				href="/project/board/boardmain?category=${m.href}"
				class="list-group-item list-group-item-action btn-info">${m.menuname}</a>
			</li>
		</c:forEach>
	</ul>
</body>
</html>