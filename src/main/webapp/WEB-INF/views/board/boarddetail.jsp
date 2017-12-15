<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- js파일 캐시 허용 거부 --%>
<%   
response.setHeader("Cache-Control","no-store");   
response.setHeader("Pragma","no-cache");   
response.setDateHeader("Expires",0);   
if (request.getProtocol().equals("HTTP/1.1")) 
        response.setHeader("Cache-Control", "no-cache"); 
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>detail</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/detail.css'/>">
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
<script src="<c:url value='/resources/js/logininterceptor.js'/>"></script>

</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/project/">Home</a>
			</div>
			<ul class="nav navbar-nav pull-right">
				<c:if test="${not empty member}">
				<li><a>${member.nickname}님 </a></li>
				<li><a href="/project/member/memberdetail?userid=${member.userid}">회원 정보</a></li>
			</c:if>
			<c:if test="${empty member}">
				<li><a id="btn-login">로그인</a></li>
				<li><a id="btn-insert">회원가입</a></li>
			</c:if>
			</ul>
		</div>
	</nav>
	<div class="jumbotron text-center">
		<h2>detail</h2>
		
	</div>
	
		<div class="col-md-2">
				<ul class="list-group">
					<c:forEach var="m" items="${menu}">
						<li class="list-group-item">
						 <a href="/project/board/boardmain?category=${m.href}" class="list-group-item list-group-item-action btn-info">${m.menuname}</a>
						</li>
					</c:forEach>
				</ul>
		</div>
		<div class="form-group">
			<div class="col-md-10">
				<!-- 여기가 컨텐츠 영역 -->
				<div class="contents">
					<div class="contentsTop">
						<div class="row text-danger">
						 	<div class="col-md-10">
						 		${boardContents.title} | ${boardContents.category}
						 	</div>
						 	<input id="bno" type="hidden" value="${boardContents.bno}"/>						 	<div class="col-md-2 text-right">
						 		<a href="./boardmain?category=movie" class="btn btn-primary">목록</a>
						 	</div>
						</div>
					</div>
					<div class="row">
					 	<div class="col-md-6">
					 		조회수: ${boardContents.count}
					 	</div>
					 	<div class="col-md-6 text-right">
					 		<fmt:formatDate var="regdate" value="${boardContents.regdate}"
					 		pattern="yyyy/MM/dd"/>
					 		${regdate}
					 	</div>
					</div>
					<br/><br/>
				
					<div class="row" style="border-bottom: 2px solid Gainsboro;">
					 	<div class="col-md-12">
					 	<video class="video-container" src="<c:url value='${boardContents.videoPath}'/>" controls>이 브라우저에서는 실행 불가합니다.</video>
					 	<br/><br/> 
					 		<p>${boardContents.content}</p>
					 	</div>
					</div>
					
					<div class="row text-right">
						<div class="col-md-12">
							<a href="./boardupdate" class="btn btn-info">게시물 수정</a>
						</div>
					</div>
		
				</div>
				<!-- 댓글 영역 -->
				<div class="reply">
					<div class="replyTop">
						<div class="row text-danger">
						 	<div class="col-md-6">
						 		댓글목록
						 	</div>
						 	<c:if test="${empty member}">
							 	<div class="col-md-6 text-right">
							 		<button class="btn btn-danger" id="reply-login">로그인</button>
							 	</div>
						 	</c:if>
						</div>
						
						<div class="row" style="border-bottom: 1px dotted Gainsboro; font-size: 15px; background: #f2f2f2;">
						 	<div class="col-md-12">
						 		
						 		<%-- <c:forEach var="replyContent" items="${replyConList}"> --%>
						 		<div id="replyList">
							 		<%-- <span>
							 			${replyContent.userid}
							 		</span>
							 		
							 		<span style="color: gray; font-size: 10px; margin: 10px;">
							 			<fmt:formatDate var="regdate" value="${replyContent.regdate}" pattern="yyyy.MM.dd. HH:mm"/>
							 				${regdate}
							 		</span>
							 		<br/>
							 		<span id="replyList">
							 			${replyContent.content}
							 		</span>
							 		<br/> --%>
							 	</div>
								<%-- </c:forEach> --%>					 		
						 	</div>
						 	<c:if test="${not empty member}">
							 	<div class="row">
									<div class="col-md-11">
										<div class="form-group">
								   			<label for="replyContent">댓글내용</label>
								   			<textarea rows="5" cols="100" class="form-control" name="replyContent"
								   					 id="replyContent" 
								   				style="resize:none;"></textarea>
								   			<input type="hidden" id="loginId" value="${member.userid}" />
								  		</div>
							  		</div>
									<div class="col-md-1">
										<div class="form-group">
								   			<label for="reply-register"></label>
								   			<button
											class="list-group-item list-group-item-action btn-info"
											id="reply-register">댓글 등록</button>
								  		</div>
							  		</div>
						  		</div>
					  		</c:if>
						</div>
							 		
					</div>
				</div>
			</div>
			
		</div>
	
		<script type="text/javascript" src="<c:url value='/resources/js/replyAjax.js'/>"></script>
		
		
</body>
</html>