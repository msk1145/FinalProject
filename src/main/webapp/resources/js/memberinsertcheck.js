$(function(){	
	
	$('#idCheck').blur(function(){
		if($('#idCheck').val() == "" || $('#idCheck').val() == null){
			$('#idCheck').val("");
			$('#idCheck').prop('placeholder', '아이디를 입력하세요!!');
			$('#idSuccess').prop('class','form-group has-error');
		}else{
			$.ajax({
				 url : "idCheck"
				,type : "post"
				,data : { userid : $('#idCheck').val() }
				,success : function(res, status, xhr){
					if(res){ // 아이디 중복
						$('#idCheck').val("");
						$('#idCheck').prop('placeholder', '중복된 아이디 입니다. 다른 아이디를 입력해 주세요..');
						$('#idSuccess').prop('class','form-group has-error');
					}else{ // 아이디 중복되지 않음
						$('#idSuccess').prop('class','form-group has-success');
					}
				}
			});
		}
	});
	
	$('#passwordCheck').blur(function(){
		if($('#password').val() != $('#passwordCheck').val() || $('#passwordCheck').val()==""){
	        $('#pwSuccess').prop('class','form-group has-error');
	        $('#passwordCheck').val('');
	        $('#passwordCheck').prop('placeholder', '비밀번호 확인을 다시 입력 바랍니다..');
	    }else{
	    	$('#pwSuccess').prop('class','form-group has-success');
	    	$('#btnsubmit').prop('disabled', false);
	    }
	})
	
});
