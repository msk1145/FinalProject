<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
table#tableStyle {
    border-collapse: collapse;
    text-align: left;
    line-height: 1.5;

}
table#tableStyle thead th {
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    color: #FA5858;
    text-align: center;
    border-bottom: 3px solid #E0E0F8;
}
table#tableStyle tbody th {
    width: 150px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    border-bottom: 1px solid #E0E0F8;
}
table#tableStyle td {
    width: 350px;
    padding: 10px;
    text-align: center;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
}
#topDiv{
	background-color: #1C1C1C;
	border-bottom: 3px solid #E0E0F8;
}
</style>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="main">Home</a>
		</div>
		<div class="navbar-header pull-right">
			<a class="navbar-brand" href="logout">나가기</a>
		</div>
	</div>
	</nav>
	
	<div class="jumbotron text-center" id="topDiv">
		<h2>관리자 페이지</h2>
	</div>
</body>
</html>