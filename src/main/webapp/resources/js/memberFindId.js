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
					alert('일치하는 아이디 있음');
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
							alert('메일보내기 성공!');
							$('#sendedAuthNumber').val(result);
						}
					});
				} else {
					alert('일치하는 아이디 없음');
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
			alert('인증번호 같음!');
			$('#findIdForm').submit();
		} else {
			alert('인증번호 다름!');
		}
	});
});
