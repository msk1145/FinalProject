$(function(){
	
	$('#btn-login').click(function(){
		var params = new URL(location.href).searchParams;
		var url = params.get('url');
		console.log('url: ' + url);
		if (url) {
			location = encodeURI('/project/member/memberlogin?url='+url);
		} else {
			location = encodeURI('/project/member/memberlogin?url='+location.href);
		}
	});
	
	$('#btn-insert').click(function(){
		var params = new URL(location.href).searchParams;
		var url = params.get('url');
		console.log('url: ' + url)
		if (url) {
			location = encodeURI('/project/member/memberinsert?url='+url);
		} else {
			location = encodeURI('/project/member/memberinsert?url='+location.href);
		}
	});
	
 });