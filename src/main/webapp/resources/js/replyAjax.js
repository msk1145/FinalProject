$(document).ready(function() {
var bno = $('#bno').val();
var userid = $('#loginId').val();
console.log(userid);
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
				var dateString = year + '.' + month + '.' 
								+ day + ' ' + hour + ':' 
								+ minute;
				$('#replyList').append('<div class="eachReply"></div>');
						
				$('.eachReply')
						.append('<span>' + this.userid + '</span>')
						.append('<span style="color: gray; font-size: 10px; margin: 10px;">'
									+ dateString + '</span>');
						// 세션에 아이디가 없을 시에는 답글 달지 못하게
						if (userid !== undefined) {
							$('.eachReply').append('<a href="#" id="rReply" style="color: gray; font-size: 10px; margin: 10px;">답글</a>');
						}
							// 세션의 아이디와  댓글아이디 비교
							if(userid === this.userid) {
								$('.eachReply')
										.append('<button class="btn btn-danger pull-right" id="reply-delete">삭제</button>')
										.append('<button class="btn btn-success pull-right" id="reply-update">수정</button>')
										.append('<br/>')
										.append('<input class="form-control" type="text" id="reply-text" value="' 
				 								+ this.content + '" style="padding: 10px;"> <hr class="divLine"/>');
							} else {
								$('.eachReply')
										.append('<input class="form-control" type="text" id="reply-text" value="' 
												+ this.content + '" style="padding: 10px;" readonly> <hr class="divLine"/>');
							}
								$('.eachReply')
										.append('<input type="hidden" id="reply-rno" value="' + this.rno + '" />');
							
				});
				
				
			});
		} // getAllReplies() 댓글 목록
		getAllReplies();
		
	$('#reply-register').click(function() {
		var content = $('#replyContent').val();
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
						$('#replyList').empty();
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
	}); // reply-register(댓글 입력)
	
	$('#replyList').on('click', '#reply-update', 
			function() {
				var rno = $(this).nextAll('#reply-rno').val();
				var content = $(this).nextAll('#reply-text').val();
				console.log(rno);
				console.log(content);
				var answer = confirm('댓글을 수정하시겠습니까?');
				
				if (answer) {
					$.ajax({
						type: 'PUT',
						url: '../replies/' + rno,
						headers: {
							'Content-Type': 'application/json',
							'X-HTTP-Override': 'PUT'
						},
						data: JSON.stringify({
							'content': content
						}),
						success: function(result) {
							if (result === 'success') {
								alert('댓글 수정 성공');
								$('#replyList').empty();
								getAllReplies();
							} else {
								alert('댓글 수정 실패');
							}
						}
					});
					
					
				} else {
					
				}
			}); // reply-update(댓글 수정)
	
	$('#replyList').on('click', '#reply-delete',
			function() {
				var rno = $(this).nextAll('#reply-rno').val();
				var answer = confirm('정말 삭제하시겠습니까?');
				
				if (answer) {
					$.ajax({
						type: 'DELETE',
						url: '../replies/' + rno,
						headers: {
							'Content-Type': 'application/json',
							'X-HTTP-Override': 'DELETE'
						},
						success: function(result) {
							if (result === 'success') {
								alert('댓글 삭제 성공');
								$('#replyList').empty();
								getAllReplies();
							} else {
								alert('댓글 삭제 실패');
							}
						}
					});
				} else {
					
				}
	}); // reply-delete(댓글 삭제)
	
	// 답글 버튼 클릭시
	$('#replyList').on('click', '#rReply',
			function() {
			
	});
	
	
});











