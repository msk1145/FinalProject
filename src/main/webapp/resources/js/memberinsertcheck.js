$(function(){
	$('#passwordCheck').change(function(){
		if($('#password').val() != $('#passwordCheck').val() || $('#passwordCheck').val()==""){
	        $('#pwSuccess').prop('class','form-group has-error');
	        $('#passwordCheck').val('');
	        $('#passwordCheck').prop('placeholder', '비밀번호 확인을 다시 입력 바랍니다..');
	    }else{
	    	$('#pwSuccess').prop('class','form-group has-success');
	    }
	})
	
	
	$('#idCheck').change(function(){
		$.ajax({
			 url : "idCheck"
			,type : "post"
			,data : { userid : $('#idCheck').val() }
			,success : function(res, status, xhr){
				if(res){ // 아이디 중복
					$('#idCheck').val("");
					$('#idCheck').prop('placeholder', '중복된 아이디 입니다. 다른 아이디를 입력해 주세요..');
					$('#btnsubmit').prop('disabled', true);
					$('#idSuccess').prop('class','form-group has-error');
				}else{ // 아이디 중복되지 않음
					$('#btnsubmit').prop('disabled', false);
					$('#idSuccess').prop('class','form-group has-success');
				}
			}
		})
	});	
});
