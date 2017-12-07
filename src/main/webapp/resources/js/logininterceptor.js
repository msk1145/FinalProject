$(function(){
	
	$('#btn-login').click(function(){
		location = encodeURI('/project/member/memberlogin?url='+location.href);
	});
	
	$('#btn-insert').click(function(){
		location = encodeURI('/project/member/memberinsert?url='+location.href);
	});
	
 });