<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<!-- 1. Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />

<!-- jQuery 3.2.1 라이브러리 사용 -->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<!-- 3. Bootstrap JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="<c:url value='/resources/js/logininterceptor.js'/>"></script>

</head>



<body>
<div class="col-md-12">
<jsp:include page="header.jsp"></jsp:include>
</div>


<div class="col-md-2">
<jsp:include page="menu.jsp"></jsp:include>
</div>

<div class="col-md-10 contentsArea">
<jsp:include page="mainview.jsp"></jsp:include>
</div>

<div class="col-md-12">
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</div>





</body>

</html>