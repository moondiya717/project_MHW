<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>    
<html>
<head>
	<title>마이페이지</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<form class="container" method="post" action="<%=request.getContextPath()%>/member/mypage">
	<h1>마이페이지</h1>
	<div class="form-group">
	  <label>아이디:</label>
	  <!-- value에있는user.id에 쓰인 user는 HttpServletRequest안 에 속한 세션에있는 로그인한 현재 사용자 user
	  만약에 없으면 안나옴-->
	  <input type="text" class="form-control" name="id" value="${user.id}" readonly>
	</div>
	<div class="form-group">
	  <label>비밀번호:</label>
	  <input type="password" class="form-control" name="pw">
	</div>
	<div class="form-group">
	  <label>비밀번호 확인:</label>
	  <input type="password" class="form-control" name="pw2">
	</div>
	<div class="form-group">
	  <label>성별:</label> <!--글자누를게 아닌데 label없어도 되지않나-->
	  <select class="form-control" name="gender" value="${user.gender}">
		  <option value="M" <c:if test="${user.gender == 'M'}">selected</c:if>>남성</option>
		  <option value="F" <c:if test="${user.gender == 'F'}">selected</c:if>>여성</option>
	  </select>
	</div>
	<div class="form-group">
	  <label>이메일:</label>
	  <input type="email" class="form-control" name="email" value="${user.email}">
	</div>
	<div class="form-group">
	  <label>이름:</label>
	  <input type="text" class="form-control" name="name" value="${user.name}">
	</div>
	<button class="btn btn-outline-success col-12">수정</button>
</form>
<script type="text/javascript">
	$(function(){
		$('form').submit(function(){
			var id = $('[name=id]').val();
			var pw = $('[name=pw]').val();
			var pw2 = $('[name=pw2]').val();
			var name = $('[name=name]').val();
			var email = $('[name=email]').val();
			if(id.trim() == ''){ //trim() 공백빼서 붙여주기
				alert('아이디를 입력하세요');
				return false;
			}
			if(pw.trim() == ''){ 
				alert('비밀번호를 입력하세요.');
				return false;
			}
			if(pw != pw2){
				alert('비밀번호가 일치하지 않습니다.');
				return false;
			}
			if(name.trim() == '' ){
				alert('이름을 입력하세요.')
				return false;
			}
			if(email.trim() == '' ){
				alert('이메일을 입력하세요.')
				return false;
			}
		})
	})
</script>

</body>
</html>
