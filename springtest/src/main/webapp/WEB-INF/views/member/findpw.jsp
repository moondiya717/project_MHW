<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
</head>
<body>
	<div class="container">
		<h1>비밀번호 찾기</h1>
		<div class="form-group">
			<input type="text" class="form-control mt-3" placeholder="아이디를 입력하세요." name="id">
		</div>
		<button type="button" class="find-pw-btn btn btn-outline-success col-12">비밀번호찾기</button>
		<div class="wait-box"></div>
	</div>
	<script type="text/javascript">
		$(function(){
			$('.find-pw-btn').click(function(){
				var id = $('[name=id]').val();				
				$.ajax({
					type : 'get',
					url : '<%=request.getContextPath()%>/find/pw/'+id,
					success : function(res){
						//console.log(res);
						$('.wait-box').text('전송중입니다. 알림창이 나타날 때까지 기다려주세요.'); 
						if(res == 'SUCCESS'){
							alert('새 비밀번호가 메일로 전송됐습니다.')
						}else{
							alert('가입되지 않은 아이디입니다.')
						}						
					}
				})
			})
		})
	</script>
</body>
</html>
