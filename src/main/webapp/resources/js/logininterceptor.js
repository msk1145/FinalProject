$(function(){
	
	$('#btn-login').click(function(){
		location = encodeURI('/project/member/memberlogin?url='+location.href);
	});
	
	$('#btn-insert').click(function(){
		location = encodeURI('/project/member/memberinsert?url='+location.href);
	});
	
	$('#btn-findId').click(function(){
		location = encodeURI('/project/member/memberfindid?url='+location.href);
	});
	
	$('#btn-findPw').click(function(){
		location = encodeURI('/project/member/memberfindpw?url='+location.href);
	});
 });