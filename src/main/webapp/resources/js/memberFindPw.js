$(document).ready(function() {
	$('#getAuthNumber').click(function() {
		var userid = $('#userid').val();
		var email = $('#email').val();
		console.log('userid: ' + userid);
		console.log('email: ' + email);
		
		$.ajax({
			type: 'POST',
			url: '/project/member/findInfo',
			headers: {
				'Content-Type': 'application/json',
				'X-HTTP-Method-Overrid': 'POST'
			},
			data: JSON.stringify({
				'userid': userid,
				'email': email
			}),
			success: function(result) {
				if (result === 'success') {
					alert('인증번호를 발송하였습니다.');
					$('#authNumber').attr('readonly', false);
					$.ajax({
						type: 'POST',
						url: '/project/member/authNumberSend',
						headers: {
							'Content-Type': 'application/json',
							'X-Http-Method-Override': 'POST'
						},
						data: email,
						success: function(result) {
							$('#sendedAuthNumber').val(result);
						} 
					});
				} else {
					alert('정보가 일치하지 않음');
				}
			}
		});
		
	});
	
	$('#searchPw').click(function() {
		// 보낸 인증번호
		var authNumber = $('#sendedAuthNumber').val();
		// 유저가 입력한 인증번호
		var userWriteNumber = $('#authNumber').val();
		
		if (authNumber === userWriteNumber) {
			$('#findPwForm').submit();
		} else {
			alert('인증번호를 확인해주세요.');
		}
	});
	
});



