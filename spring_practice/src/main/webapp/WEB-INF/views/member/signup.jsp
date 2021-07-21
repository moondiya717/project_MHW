<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<html>
<head>
	<title>회원가입</title>
	  <meta charset="utf-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1">
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
	  <h2>회원가입</h2>
	  <form action="<%=request.getContextPath()%>/member/signup" method="post">
	    <div class="form-group">
	      <label id="id">아이디:</label>
	      <input type="text" class="form-control" id="id" name="id">
	    </div>
	    <div class="form-group">
	      <label for="pwd">비밀번호:</label>
	      <input type="password" class="form-control" id="pw" name="pw">
	    </div>
   	    <div class="form-group">
	      <label for="pwd">비밀번호 확인:</label>
	      <input type="password" class="form-control" id="pw2" name="pw2">
	    </div>
   	    <div class="form-group">
	      <label name="gender">성별:</label>
	      <select type="select" class="form-control" id="gender" name="gender">
	      	<option name="M" value="M">남</option>
	      	<option name="F" value="F">여</option>
	      </select>
	    </div>
   	    <div class="form-group">
	      <label for="usr">이름:</label>
	      <input type="text" class="form-control" id="name" name="name">
	    </div>
   	    <div class="form-group">
	      <label for="usr">이메일:</label>
	      <input type="text" class="form-control" id="email" name="email">
	    </div>
	    <button type="submit" class="btn btn-primary">가입</button>
	  </form>
	</div>
</body>
</html>
