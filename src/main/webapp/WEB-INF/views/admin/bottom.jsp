<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<style>
.copyright {
	
}
.copyright-menu {
	list-style: none;
}
.copyright-menu li {
	display: inline;
}
.copyright-menu a {
	color: #D8D8D8;
	cursor: pointer;
	text-decoration: none;
}
.copyright-menu a:hover {
	color: #8C8C8C;

}

.copyright-menu a:active {
	color:#5D5D5D;
}



</style>
</head>
<body>
	<br/>
	<br/>
	<br/>
	<footer>
		<div style="border: 2px solid Gainsboro;"></div>
		<div class="footer text-center" style="background-color: #212121; height:100px;">
			<div class="copyright-content" style="color: #D8D8D8; padding: 10px;">
				<div class="copyright-option">
					<ul class="copyright-menu">
						<li><a href="/project">HOME </a> |</li>
						<li><a id="accessTerms">이용약관 </a> |</li>
						<li><a id="privacyStatements">개인정보취급방침</a></li>
					</ul>
				</div>
				<div class="copyright">Copyright 2017 - 2017 WILLKOREANS | All Rights Reserved</div>
			</div>
		</div>
	</footer>
	
	<script>
		$(document).ready(function() {
			$('#accessTerms').click(function() {
				$('.contentsArea').load('/project/footerContents/accessTerms');
			});
			$('#privacyStatements').click(function() {
				$('.contentsArea').load('/project/footerContents/privacyStatements');
			});
		});
	</script>
</body>
</html>