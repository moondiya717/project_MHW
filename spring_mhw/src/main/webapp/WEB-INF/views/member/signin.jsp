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
		<button class="btn btn-outline-success col-12">로그인</button>
	</form>
</body>
</html>
