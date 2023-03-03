
//window.onload=function(){	
$(function(){				//jQuery3.0 식으로 줄여쓰기							
	var xhr = new XMLHttpRequest();		
	$("#cat1").click(function(){
		$.get("/api/catOne",function(data){
			var x = JSON.stringify(data);
			var jo = JSON.parse(x);
			$("#r").text("이름:" + jo.name + "나이:" + jo.age);		//jQuery
		})
	});

	$("#cat2").click(function(){
		xhr.open('GET','/api/catTwo');
		xhr.send();
		xhr.onload = function(){
			if(xhr.status === 200){		//응답 상태 확인
				var j = xhr.responseText;
				var jo = JSON.parse(j)
				$("#r").text("이름:" + jo.name + "나이:" + jo.age);		//jQuery
			}else {
				console.error(xhr.statusText);		//오류 메시지 출력
			}
		};
	});
	});					
					
