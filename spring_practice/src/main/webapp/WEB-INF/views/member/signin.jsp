<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<html>
<head>
	<title>로그인</title>
	  <meta charset="utf-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1">
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
	  <h2>로그인</h2>
	  <form action="<%=request.getContextPath()%>/member/signin" method="post">
	    <div class="form-group">
	      <label id="id">아이디:</label>
	      <input type="text" class="form-control" id="id" name="id">
	    </div>
	    <div class="form-group">
	      <label for="pwd">비밀번호:</label>
	      <input type="password" class="form-control" id="pw" name="pw">
	    </div>
	    <button type="submit" class="btn btn-primary">로그인</button>
	  </form>
	</div>
</body>
</html>
