$(document).ready(function() {
	 		var broWidth = $(window).width();
			console.log('문서 처음켰을때 브라우저 넓이: ' + broWidth);
			var obj = $('.menuArea').offset();
			console.log("left: " + obj.left + "px, top: " + obj.top + "px");
			
			var footerHeight = $('.footerArea').height();
			var chatHeight = $('#contentstSuccess').height();
			
			$(window).scroll(function() {
				if ($(this).width() <= '980') {
					// console.log('c');
					event.preventDefault();
				} else {
					// console.log('d');
					var position = $(this).scrollTop() - (footerHeight + chatHeight); // 현재 스크롤 위치 반환
					
					position = (position < 0 ? 0 : position);
					
					$('.menuArea').stop().animate({top:position + 'px'}, 700);
				}
			});
			
			$(window).resize(function() {
				var resizedWidth = $(window).width();
				console.log('창조절 브라우저 넓이: ' + resizedWidth);
				$('.menuArea').offset({top: 261});
				$(this).scroll(function() {		
					if ($(window).width() <= '980') {
						console.log('a');
						event.preventDefault();
					} else {
						console.log('b');
						var position = $(window).scrollTop(); // 현재 스크롤 위치 반환
						$('.menuArea').stop().animate({top:position + 'px'}, 700);
					}
				}); 
			});

		});