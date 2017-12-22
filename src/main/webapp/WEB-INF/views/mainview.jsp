<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" 
    uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
			
		<c:set var="index" value="${0}" />
		<c:forEach var="boardTbl" items="${board}">
			<div class="col-md-6">
				<h2 class="text-center">
					<c:forEach var="data" items="${menu}" begin="${index}" end="${index}" varStatus="status">						
						<c:set var="index" value="${index+1}" />
						${data.menuname}
					</c:forEach>
					
					
				</h2>
				<table class="table table-bordered table-hover table-condensed">
					<thead>
						<tr class="text-danger">
							<th class="text-center col-md-1">글번호</th>
							<th class="text-center col-md-5">제목</th>
							<th class="text-center col-md-3">글쓴이</th>
							<th class="text-center col-md-3">조회수</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="data" items="${boardTbl}">
							<tr class="text-center text-info"
								onClick="location.href='./board/boarddetail?bno=${data.bno}'"
								style="cursor: pointer;">
								<td>${data.bno}</td>
								<td>${data.title}</td>
								<td>admin</td>
								<td>${data.count}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:forEach>
</body>
</html>