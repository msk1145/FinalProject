<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ROOT" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>main</title>

</head>
<body>
	<!-- 스크립트 &amp; CSS 영역 -->
	<jsp:include page="/WEB-INF/views/styleNscript.jsp"></jsp:include>
	
	<!-- 헤더 영역 -->
	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

	<!-- 메뉴 영역 -->
	<div class="col-md-2 menuArea">
		<jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>
	</div>
	
	<script src="<c:url value='/resources/js/logininterceptor.js'/>"></script>

	<!-- 메인 뷰 영역 -->
	<div class="col-md-10 contentsArea">
		<div class="container">
			<div class="col-md-12 text-center">
				<h3>게시판입니당</h3>
			</div>

			<div class="col-md-12 text-right">
				<form action="boardsearch" class="form-inline">
					<select class="form-control" name="searchType">
						<option value="1" selected>제목</option>
						<option value="2">제목 + 내용</option>
					</select> <input class="form-control" type="text" name="keyword" /> <input
						type="hidden" name="category" value="${category}" /> <input
						class="btn" type="submit" value="검색" />
				</form>
			</div>
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<div class="row">
				<c:if test="${not empty board}">
					<c:forEach var="b" items="${board}">
						<div class="col-md-4 text-center poster_image">
							<a href="boarddetail?bno=${b.bno}"> <img
								class="poster_thumbnail" width="200" height="280" alt="이미지가 없음"
								style="margin: 10px;" src="<c:url value= '${b.imagePath}'/>" />
							</a>
							<h4 class="text-center">${b.title}</h4>
							<div class="poster_content trans">
								<span class="outline">줄거리</span><br />
								<div>
									${fn:substring(b.content, 0, 120)}
									<c:if test="${fn:length(b.content) > 120}">
										…
									</c:if>
								</div>
								<br /> <a class="detail_poster" href="boarddetail?bno=${b.bno}">상세보기</a>
							</div>
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

					<c:forEach var="num" begin="${pageMaker.startPage}"
						end="${pageMaker.endPage}">
						<li class="${num}"><a href="${num}">${num}</a></li>
					</c:forEach>

					<c:if test="${pageMaker.next}">
						<li><a href="${pageMaker.endPage + 1}">다음</a></li>
					</c:if>
				</ul>

				<form id="pageForm" action="boardmain" method="get">
					<input type="hidden" id="page" name="page"
						value="${pageMaker.criteria.page}" /> <input type="hidden"
						id="perPage" name="perPage"
						value="${pageMaker.criteria.numsPerPage}" /> <input type="hidden"
						id="category" name="category" value="${board[0].category}" />
				</form>
			</div>
		</div>
	</div>

	<div class="col-md-12 footerArea">
		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	</div>

	<script>
		$(document).ready(function() {
			var currentPage = '${pageMaker.criteria.page}';
			$('.pagination').find('.' + currentPage).addClass('active');

			$('.pagination li a').click(function() {
				event.preventDefault();
				var target = $(this).attr('href');

				$('#page').val(target);
				$('#pageForm').submit();
			});

		});
	</script>