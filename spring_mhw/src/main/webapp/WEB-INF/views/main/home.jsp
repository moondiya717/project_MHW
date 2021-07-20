<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>    <!-- html5라는 말이래 -->
<html>
<head>
	<title>메인</title>

</head>
<body>
<button id="btn">클릭</button>
<script type="text/javascript">
	$(function(){
		$('#btn').click(function(){
			//data속성이 없는 경우 : url에 정보를 전달해도 되는 경우
			$.ajax({
				async : false,
				type: 'get', 
				url : '<%=request.getContextPath()%>/test/123', 
				success : function(result, status, xhr){ 
					console.log(result)
				},
				error : function(xhr, status, e){
					console.log('에러 발생');
				}			
			})
			console.log("힘내자!");
			//data속성이 있는 경우 : 전달할 정보가 길거나 중요한 경우
			//dataType : 서버에서 전달한 데이터 타입을 지정
			//contentType : 서버로 전달할 데이터 타입을 지정 
			//async : 비동기화 하는 경우 true, 동기화하는 경우 false
			//비동기 : (ajax)작업이 끝날 때까지 기다리지 않음->앞에 ajax가 시작하면 그 뒤도 바로 시작함, 동기: (ajax)작업이 끝날 때 까지 기다림
			//비동기 true이면 힘내자-ok,false이면 ok-힘내자 순서임 (힘내자는 ajax이후코드, ok는 result값)
			/*
			$.ajax({
					type:'post',
					url: '<%=request.getContextPath()%>/member/signin',
					data: JSON.stringify(data),				
					//dataType : "json", //서버에서  json형태로 보내주는 경우 사용(클래스의 객체를 보내주는)
					contentType:"application/json; charset=utf-8",
					success : function(result, status, xhr){

					},
					error : function(xhr, status, e){						
					}				
			})
			*/
		})
	})
</script>
</body>
</html>
