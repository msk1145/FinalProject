<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div class="col-md-12 menuWrapper">
			<div id="menuCategory">카테고리</div>
			<ul id="ulStyle">
				<c:forEach var="m" items="${menu}">
					<li class="liStyle" onclick="location.href='/project/board/boardmain?category=${m.href}'">${m.menuname}
					</li>
					<!-- 
					<li class="menuDiv">
					<hr/>
					</li>
					 -->
				</c:forEach>
			</ul>
	</div>
</body>
</html>