<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
	color: #F2FBEF;
	background-color : #1C1C1C;
}
#ulStyle { 
height: 40px; 
width: 1200px; 
cursor: pointer;
display:inline-block;
} 

#ulStyle li { 
list-style: none; 
color: white;  
line-height: 50px; 
text-align: center;
}

#ulStyle .liStyle { 
text-decoration:none; 
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
	<ul id="ulStyle">
		<li class="liStyle" onclick="location.href='/project/admin/memberList'">회원관리</li>
		<li class="liStyle" onclick="location.href='/project/admin/boardinsert'">게시물 등록</li>
		<li class="liStyle" onclick="location.href='/project/admin/boardList'">게시물 수정/삭제</li>
		<li class="liStyle" onclick="location.href='/project/admin/menuList'">메뉴 카테고리 추가</li>
	</ul>
</body>
</html>