<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>    
<html>
<head>
	<title>로그인</title>
</head>
<body>
<!-- .jsp는 자바를 이용할 수 있기때문에 action의 링크는 자동으로 프로젝트에 따른 주소를 입력하게 해주도록 코드를 넣은 것 -->
	<form class="container" method="post" action="<%=request.getContextPath() %>/signin">
		<h1>로그인</h1>
		<div class="form-group">
		  <label>아이디:</label>
		  <input type="text" class="form-control" name="id">
		</div>
		<div class="form-group">
		  <label>비밀번호:</label>
		  <input type="password" class="form-control" name="pw">
		</div>
		<!-- 서버로 데이터전송을 안되게하려고 button type을 button으로 했음, ajax이용하려고 -->
		<button type=button id="loginBtn" class="btn btn-outline-success col-12">로그인</button>
		<a href="<%=request.getContextPath()%>/find/id">아이디 찾기</a>
		<b>/</b>		
		<a href="<%=request.getContextPath()%>/find/pw">비밀번호 찾기</a>
	</form>
	<script type=text/javascript>
		$(function(){
			$('#loginBtn').click(function(){
				var id = $('[name=id]').val();
				var pw = $('[name=pw]').val();
				var data = {'id' : id, 'pw' : pw};
				$.ajax({
					type:'post',
					url: '<%=request.getContextPath()%>/member/signin',
					data: JSON.stringify(data),
					//dataType:"json", //서버에서 json형태로 보내주는 경우(클래스의 객체를 보내주는 경우, Map을 이용하여 보내주는 경우)
					contentType:"application/json; charset=utf-8",
					success : function(result, status, xhr){
						console.log(result);
						if(result != 'success'){
							alert('아이디 또는 비밀번호가 틀렸습니다.');
						}else{
							alert('로그인 성공')
							location.href="<%=request.getContextPath()%>/"
						}
					},
					error : function(xhr, status, e){						
					}				
				})
			})
		})
	</script>
</body>
</html>
