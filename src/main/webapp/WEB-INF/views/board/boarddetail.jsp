<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- js파일 캐시 허용 거부 --%>
<%
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	if (request.getProtocol().equals("HTTP/1.1"))
		response.setHeader("Cache-Control", "no-cache");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>detail</title>

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
	<script type="text/javascript" src="<c:url value='/resources/js/replyAjax.js'/>"></script>
	

	<div class="form-group">
		<div class="col-md-10 contentsArea">
			<!-- 여기가 컨텐츠 영역 -->
			<div class="contents">
				<div class="contentsTop">
					<div class="row text-danger">
						<div class="col-md-10">${boardContents.title} |
							${boardContents.category}</div>
						<input id="bno" type="hidden" value="${boardContents.bno}" />
						<div class="col-md-2 text-right">
							<a href="./boardmain?category=movie" class="btn btn-primary">목록</a>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">조회수: ${boardContents.count}</div>
					<div class="col-md-6 text-right">
						<fmt:formatDate var="regdate" value="${boardContents.regdate}"
							pattern="yyyy/MM/dd" />
						${regdate}
					</div>
				</div>
				<br />
				<br />

				<div class="row" style="border-bottom: 2px solid Gainsboro;">
					<div class="col-md-12">
						<video class="video-container"
							src="<c:url value='${boardContents.videoPath}'/>" controls>이
							브라우저에서는 실행 불가합니다.
						</video>
						<br />
						<br />
						<p>${boardContents.content}</p>
					</div>
				</div>


			</div>
			<!-- 댓글 영역 -->
			<div class="reply">
				<div class="replyTop">
					<div class="row text-danger">
						<div class="col-md-6">댓글 [${replyCount}]</div>
						<c:if test="${empty member}">
							<div class="col-md-6 text-right">
								<button class="btn btn-danger" id="reply-login">로그인</button>
							</div>
						</c:if>
					</div>

					<div class="row"
						style="border-bottom: 1px dotted Gainsboro; font-size: 15px; background: #f2f2f2; border-radius: 10px;">
						<div class="col-md-12">
							<div id="replyList"></div>
						</div>
						<c:if test="${not empty member}">
							<div class="row">
								<div class="col-md-11">
									<div class="form-group">
										<label for="replyContent">댓글내용</label>
										<textarea rows="5" cols="100" class="form-control"
											name="replyContent" id="replyContent" style="resize: none;"></textarea>
										<input type="hidden" id="loginId" value="${member.userid}" />
										<input type="hidden" id="loginUserGrade"
											value="${member.grade}" />
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
	
	<div class="col-md-12 footerArea" style="padding: 0px;">
		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	</div>


</body>
</html>