$(document).ready(function() {
var bno = $('#bno').val();
var userid = $('#loginId').val();
var replyToggle = true;
console.log(userid);
console.log(bno);


$('#reply-login').click(function(){
	location = encodeURI('/project/member/memberlogin?url='+location.href);
});

function getAllReplies() {
	$.getJSON('../replies/all/' + bno,
		function(data) {
			$(data).each(function(index) {
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
				console.log('데이터 길이:' + data.length);
				console.log(index);
				$('#replyList div:nth-child(' + (index+1) + ')')
						.append('<span>' + this.userid + '</span>')
						.append('<span style="color: gray; font-size: 10px; margin: 10px;">'
									+ dateString + '</span>');
						// 세션에 아이디가 없을 시에는 답글 달지 못하게
						if (userid !== undefined) {
							$('#replyList div:nth-child(' + (index+1) + ')')
								.append('<a id="rReply" style="color: gray; font-size: 10px; margin: 10px; cursor: pointer;">답글</a>');
						}
							// 세션의 아이디와  댓글아이디 비교
							if(userid === this.userid) {
								$('#replyList div:nth-child(' + (index+1) + ')')
										.append('<button class="btn btn-danger pull-right reply-delete">삭제</button>')
										.append('<button class="btn btn-success pull-right reply-update">수정</button>')
										.append('<br/>')
										.append('<input class="form-control" type="text" id="reply-text" value="' 
				 								+ this.content + '" style="padding: 10px;"> <hr class="divLine"/>');
							} else {
								$('#replyList div:nth-child(' + (index+1) + ')')
										.append('<input class="form-control" type="text" id="reply-text" value="' 
												+ this.content + '" style="padding: 10px;" readonly> <hr class="divLine"/>');
							}
								$('#replyList div:nth-child(' + (index+1) + ')')
										.append('<input type="hidden" id="reply-rno" value="' + this.rno + '" />'
												+ '<div class="rReplyList"></div>');
								
				});
				
				
			});
	
		} // getAllReplies() 댓글 목록
		getAllReplies();
		
		// 답글 버튼 클릭시
		$('#replyList').on('click', '.eachReply #rReply',
				function() {
				// 대댓글의 rrno
				var rrno = $('#reply-rno').val();
				
				console.log('rno:' + rrno);
				$.getJSON('../replies/rereplies/' + rrno,
						function(data) {
							var innerHTML = '';
							$(data).each(function() {
								if (replyToggle) {
									innerHTML += '<div class="row">'
											+ '<div class="col-md-11">'
											+ '<div class="form-group">'
											+ '<label for="rReplyContent">댓글내용</label>'
									   			+ '<textarea rows="5" cols="100" class="form-control" name="rReplyContent"'
									   					+ 'id="rReplyContent"'
									   				+ 'style="resize:none;"></textarea>'
									   			+ '<input type="hidden" id="loginId" value="${member.userid}" />'
									  		+ '</div>'
								  		+ '</div>'
										+ '<div class="col-md-1">'
											+ '<div class="form-group">'
									   			+ '<label for="rReply-register"></label>'
									   			+ '<button '
												+ 'class="list-group-item list-group-item-action btn-info"'
												+ 'id="rReply-register">댓글 등록</button>'
									  		+ '</div>'
								  		+ '</div>'
								  		+ '</div> <hr class="divLine"/>';
									// TODO: this가 맞지 않음
									$(this).nextAll('.rReplyList').html(innerHTML);
									$(this).html('답글취소');
									console.log('toggle' + replyToggle);
									console.log('reReplies:'+ this.rno +','
											+ this.bno + ', ' + this.content);
									replyToggle = false;
								} else {
									$(this).html('답글');
									$(this).parent().find('.rReplyList .row').remove();
									$(this).nextAll('.divLine').remove();
									console.log('toggle(else)' + replyToggle);
									replyToggle = true;
								}
							});
				});
				
				
				
		});
		

















































	$('#replyList').on('click', '.eachReply .row .col-md-1 .form-group #rReply-register',
			function() {
		var rrno = $('#reply-rno').val();
		var content = $(this).parent().parent().parent().find('.col-md-11 .form-group #rReplyContent').val();
		console.log('rRcontent:' + content);
		console.log('rrno:' + rrno);
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
					'userid': userid,
					'rrno': rrno
				}),
				success: function(result) {
					if (result) {
						alert('대댓글 입력 성공');
						$('#replyList').empty();
						getAllReplies();
						$('#rReplyContent').val('');
					} else {
						alert('대댓글 입력 실패');
					}
				}
			});
		}
	}); // rReply-register(대댓글 입력)
			
		
		
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
				// 에러메시지
				 error:function(request,status,error){
		             alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		          }

					
			});
		} else {
			
		}
	}); // reply-register(댓글 입력)
	
	
	$('#replyList').on('click', '.eachReply .reply-update', 
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
	
	$('#replyList').on('click', '.eachReply .reply-delete',
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
	
	
	
});











