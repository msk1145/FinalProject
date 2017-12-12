var bno = $('#bno').val();
console.log(bno);

$('#reply-login').click(function(){
	location = encodeURI('/project/member/memberlogin?url='+location.href);
});

function getAllReplies() {
	$.getJSON('../replies/all/' + bno,
		function(data) {
			$(data).each(function() {
				var d = new Date(this.regdate);
				var year = d.getFullYear();
				var month = d.getMonth() + 1;
				var day = d.getDate();
				var hour = d.getHours();
				var minute = d.getMinutes();
				var seconds = d.getSeconds();
				var dateString = year + '.' + month + '.' 
								+ day + ' ' + hour + ':' 
								+ minute + ':' + seconds;
				
				$('#reply').append('<span>' + this.userid + '</span>')
							.append('<span style="color: gray; font-size: 10px; margin: 10px;">'
				 			+ dateString + '</span>')
				 			.append('<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>')
				 			.append('<br/>')
				 			.append('<div id="replyList" style="padding: 10px;">' + this.content + '</div>');
				});
				
				
			});
		}
		getAllReplies();
		
	$('#reply-register').click(function() {
		var content = $('#replyContent').val();
		var userid = $('#loginId').val();
		console.log(content);
		console.log(userid);
		var answer = confirm('댓글을 등록하시겠습니까?');
		if (answer) { 
			$.ajax({
				type: 'POST',
				url: '../replies',
				headers: {
					'Content-Type': 'application/json',
					'X-HTTP-Method-Override': 'POST'
				},
				data: JSON.stringify({
					'bno': bno,
					'content': content,
					'userid': userid
				}),
				success: function(result) {
					if (result === 'success') {
						alert('댓글 입력 성공');
						$('#reply').empty();
						getAllReplies();
						$('#replyContent').val('');
					} else {
						alert('댓글 입력 실패');
					}
				},
				 error:function(request,status,error){
		             alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		          }

					
			});
		} else {
			
		}
	});	
		
