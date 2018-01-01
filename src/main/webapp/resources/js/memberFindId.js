$(document).ready(function() {
	// 인증번호 받기
	$('#getAuthNumber').click(function() {
		var nickname = $('#nickname').val();
		var email = $('#email').val();
		console.log('별명:' + nickname);
		console.log('이메일:' + email);
	$.ajax({
			type: 'POST',
			url: '/project/member/findInfo',
			headers: {
				'Content-Type': 'application/json',
				'X-HTTP-Method-Override': 'POST'
			},
			data: JSON.stringify({
				'nickname': nickname,
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
							'X-HTTP-Method-Override': 'POST'
						},
						data: email,
						success: function(result) {
							$('#sendedAuthNumber').val(result);
						}
					});
				} else {
					alert('정보가 일치하지 않습니다.');
				}
			}
		});
	});
	
	$('#searchId').click(function() {
		// 보낸 인증번호
		var authNumber = $('#sendedAuthNumber').val();
		// 유저가 입력한 인증번호
		var userWriteNumber = $('#authNumber').val();
		
		if (authNumber === userWriteNumber) {
			$('#findIdForm').submit();
		} else {
			alert('인증번호를 확인해주세요.');
		}
	});
});
