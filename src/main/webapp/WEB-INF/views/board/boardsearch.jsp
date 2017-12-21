<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var = "ROOT" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>main</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="<c:url value='/resources/js/logininterceptor.js'/>"></script>

<style>
.poster_image  img {
    -webkit-transform:scale(1);
    -moz-transform:scale(1);
    -ms-transform:scale(1); 
    -o-transform:scale(1);  
    transform:scale(1);
    -webkit-transition:.3s;
    -moz-transition:.3s;
    -ms-transition:.3s;
    -o-transition:.3s;
    transition:.3s;
    border-radius: 8px;
    
}
.poster_image:hover img {
    -webkit-transform:scale(1.3);
    -moz-transform:scale(1.3);
    -ms-transform:scale(1.3);   
    -o-transform:scale(1.3);
    transform:scale(1.3);
}
.potser-image.polaroid {
  width: 80%;
  background-color: white;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
  margin-bottom: 25px;
}

.poster-image.container {
  text-align: center;
  padding: 10px 20px;
}



</style>

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
		<h2>Main</h2>
	</div>
	<div>
		<div class="col-md-2">
			<ul class="list-group">
					<c:forEach var="m" items="${menu}">
						<li class="list-group-item">
						 <a href="/project/board/boardmain?category=${m.href}" class="list-group-item list-group-item-action btn-info">${m.menuname}</a>
						</li>
					</c:forEach>
			</ul>
		</div>
		
		<div class="col-md-10">
			<div class="container">
				<div class="col-md-12 text-center">
					<h3>게시판입니당</h3>
				</div>
				
				<div class="col-md-12 text-right">
					<form action="boardsearch" class="form-inline">
					<select class="form-control" name="searchType">
						<option value="1" selected>제목</option>
						<option value="2">제목 + 내용</option>
					</select>
					<input class="form-control" type="text" name="keyword" />
					<input type="hidden" name="category" value="${category}" />
					<input class="btn" type="submit" value="검색" />
					</form>
				</div>
				<br/><br/><br/><br/><br/><br/><br/>
				<div class="row">
					<c:if test="${not empty board}">
						<c:forEach var="b" items="${board}">		
							<div class="col-md-4 text-center poster_image">
								<a href="boarddetail?bno=${b.bno}">
								<img width="200" height="280" alt="이미지가 없음" src="<c:url value= '${b.imagePath}'/>"	/>
								</a>
								<h4 class="text-center">${b.title}</h4>
							</div>
						</c:forEach>
					</c:if>
					<c:if test="${empty board}">
						<h1>현재 게시판 영상이 없습니다..</h1>
					</c:if>
				</div>
				
				<div class="row text-center">
					<ul class="pagination">
						<c:if test="${pageMaker.prev}">
							<li><a href="${pageMaker.startPage - 1}">이전</a></li>
						</c:if>
						
						<c:forEach var="num" 
								begin="${pageMaker.startPage}"
								end="${pageMaker.endPage}">
							<li><a href="${num}">${num}</a></li>
						</c:forEach>	
				
						<c:if test="${pageMaker.next}">
							<li><a href="${pageMaker.endPage + 1}">다음</a></li>
						</c:if>
					</ul>
					
					<form id="pageForm" action="boardsearch" method="get" >
						<input type="hidden" id="page" name="page" value="${pageMaker.criteria.page}" />
						<input type="hidden" id="perPage" name="perPage" value="${pageMaker.criteria.numsPerPage}" />
						<input type="hidden" id="category" name="category" value="${board[0].category}" />
						<input type="hidden" id="searchType" name="searchType" value="${searchType}" />
						<input type="hidden" id="keyword" name="keyword" value="${keyword}" />
					</form>
				</div>
				<br/><br/><br/>
			</div>
		</div>
		
		


	</div>
	
	<script>
		$(document).ready(function() {
			$('.pagination li a').click(function() {
				event.preventDefault();
				
				var target = $(this).attr('href');
				
				$('#page').val(target);
				$('#pageForm').submit();
			});
		});
	</script>
</body>
</html>