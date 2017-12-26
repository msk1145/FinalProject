<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Adminmain</title>

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
</head>
<body>
	<div class="col-md-12">
		<jsp:include page="top.jsp"></jsp:include>
	</div>

	<div class="col-md-2">
		<jsp:include page="side.jsp"></jsp:include>
	</div>

	<div>
		<div class="col-md-10">
			<!-- 여기가 컨텐츠 영역 -->
			<form action="boardList" method="post" id="submit">
				<select class="form-control" id="select" name="category">
					<option value="">전체</option>
					<c:forEach var="c" items="${menu}">
						<c:if test="${selectedCategory eq c.href}">
							<option id="selectvalue" value="${c.href}" selected>${c.menuname}</option>
						</c:if>
						<c:if test="${selectedCategory ne c.href}">
							<option id="selectvalue" value="${c.href}">${c.menuname}</option>
						</c:if>
					</c:forEach>

				</select> <br /> <br />
			</form>
			<table class="table table-hover" id="tableStyle">
				<thead>
					<tr>
						<th>게시글 번호</th>
						<th>제목</th>
						<th>작성날짜</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="b" items="${board}">
						<tr class="text-center text-info"
							onClick="location.href='/project/admin/boardDetail?bno=${b.fbno}&category=free'"
							style="cursor: pointer;">
							<td>${b.fbno}</td>
							<td>${b.ftitle}</td>
							<td><fmt:formatDate value="${b.fregdate}"
									pattern="yyyy년 MM월 dd일 kk시 mm분 ss초" /></td>
							<td>${b.fcount}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
	<div class="row text-center">
		<ul id="pagination" class="pagination">
			<c:if test="${pageMaker.prev}">
				<!-- 이전 버튼은 (startPage - 1) -->
				<li><a class="page-link" href="${pageMaker.startPage-1}">◀이전</a></li>
			</c:if>
			<c:forEach var="num" begin="${pageMaker.startPage}"
				end="${pageMaker.endPage}">
				<li><a class="page-link" href="${num}">${num}</a></li>
			</c:forEach>

			<c:if test="${pageMaker.next}">
				<!-- 다음 버튼은 (endPage + 1) -->
				<li><a class="page-link" href="${pageMaker.endPage+1}">다음▶</a></li>
			</c:if>
		</ul>
	</div>

		<form id="pageForm" action="boardList" method="get">
			<input type="hidden" name="page" id="page"
				value="${pageMaker.criteria.page}" /> <input type="hidden"
				name="perPage" id="perPage"
				value="${pageMaker.criteria.numsPerPage}" /> <input type="hidden"
				name="category" id="cate" value="" />
		</form>

		<form id="pageForm2" action="boardList" method="post">
			<input type="hidden" name="page" id="page2"
				value="${pageMaker.criteria.page}" /> <input type="hidden"
				name="perPage" id="perPage2"
				value="${pageMaker.criteria.numsPerPage}" /> <input type="hidden"
				name="category" id="cate2" value="" />
		</form>

	<div class="col-md-12">
		<jsp:include page="bottom.jsp"></jsp:include>
	</div>

	<script>
		$(function() {
			$('#pagination li a').click(function(event) {
				// a태그 동작 정지
				event.preventDefault();

				// 이동할 페이지
				var target = $(this).attr('href');

				if ($('#select').val() == null || $('#select').val() == "") {
					// category 값 추가
					$('#cate').val($('#select').val());
					// 서브밋할 폼의 값을 바꿔줌.
					$('#page').val(target);
					// 서브밋
					$('#pageForm').submit();
				} else {
					// category 값 추가
					$('#cate2').val($('#select').val());
					// 서브밋할 폼의 값을 바꿔줌.
					$('#page2').val(target);
					// 서브밋
					$('#pageForm2').submit();
				}

			});
		});

		$('#select').change(function() {
			if ($('select').val() == "") {
				location.href = "/project/admin/boardList";
			} else {
				$('#submit').submit();
			}

		});
	</script>
</body>
</html>