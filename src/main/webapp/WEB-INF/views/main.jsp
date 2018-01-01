<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
	<!-- 스크립트 &amp; CSS 영역 -->
	<jsp:include page="/WEB-INF/views/styleNscript.jsp"></jsp:include>
	
	<!-- 헤더 영역 -->
	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

	<!-- 메뉴 영역 -->
	<div class="col-md-2 menuArea">
		<jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>
	</div>

	<!-- 메인뷰 영역 -->
	<div class="col-md-10 contentsArea">
		<jsp:include page="/WEB-INF/views/mainview.jsp"></jsp:include>
	</div>
		
	<!-- 푸터 영역 -->
	<div class="col-md-12 footerArea">
	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	</div>
	
	

</body>



</html>