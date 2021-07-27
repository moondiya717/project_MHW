<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<html>
<head>
	<title>마이페이지</title>
	  <meta charset="utf-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1">
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
	  <h2>마이페이지</h2>
	  <!--enctype="multipart/form-data" -->
	  <form action="<%=request.getContextPath()%>/member/mypage" method="post">
	    <div class="form-group">
	      <label id="id">아이디:</label>
	      <input type="text" class="form-control" value="${user.id}" name="id" readonly>
	    </div>
	    <div class="form-group">
	      <label for="pwd">새 비밀번호:</label>
	      <input type="password" class="form-control" name="pw">
	    </div>
   	    <div class="form-group">
	      <label for="pwd">새 비밀번호 확인:</label>
	      <input type="password" class="form-control" name="pw2">
	    </div>
   	    <div class="form-group">
	      <label>성별:</label>
	      <select type="select" class="form-control" name="gender">
	      	<option value="M" <c:if test="${user.gender == 'M'}">selected</c:if> >남</option>
	      	<option value="F" <c:if test="${user.gender == 'F'}">selected</c:if> >여</option>
	      </select>
	    </div>
   	    <div class="form-group">
	      <label for="usr">이름:</label>
	      <input type="text" class="form-control" value="${user.name}" name="name" readonly>
	    </div>
   	    <div class="form-group">
	      <label for="usr">이메일:</label>
	      <input type="text" class="form-control" value="${user.email}" name="email">
	    </div>
	    <a href="<%=request.getContextPath()%>/"><button type="button" class="btn btn-success">메인으로</button></a>
	    <button type="submit" class="btn btn-primary">수정하기</button>
	  </form>
	</div>
	<script type="text/javascript">
	$(function(){	
		$('form').submit(function(){
			var pw = $('[name=pw]').val();
			var pw2= $('[name=pw2]').val();
			if(pw == pw2){
				return true;
			}else{
				alert('비밀번호와 비밀번호 확인이 다릅니다.')
				return false;
			}
		})
	})
	</script>
</body>
</html>
