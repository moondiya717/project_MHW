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
		<label class="form-group">
		<!-- ?????에 value를 지정하지 않으면 true false가 나옴 -->
		  <input type="checkbox" name="useCookie" value="true"> 자동 로그인
		</label>
		<!-- 서버로 데이터전송을 안되게하려고 button type을 button으로 했음, ajax이용하려고 -->
		<button type=submit id="loginBtn" class="btn btn-outline-success col-12">로그인</button>
		<a href="<%=request.getContextPath()%>/find/id">아이디 찾기</a>
		<b>/</b>		
		<a href="<%=request.getContextPath()%>/find/pw">비밀번호 찾기</a>
	</form>
<!-- 기존의 스크립트에 있던 ajax를 지웠음, ajax보다 ???에서 하는게 더 편하기때문 -->
</body>
</html>
