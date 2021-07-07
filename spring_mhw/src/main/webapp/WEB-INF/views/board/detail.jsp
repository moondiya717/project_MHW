<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>    
<html>
<head>
	<title>로그인</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
	  <h2>게시판</h2>
	  <div class="form-group">
		 <label>제목</label>
		 <input type="text" class="form-control" value="${board.title}" readonly>
	  </div>
	  	  <div class="form-group">
		 <label>작성자</label>
		 <input type="text" class="form-control" value="${board.writer}" readonly>
	  </div>
   	  <div class="form-group">
		 <label>조회수</label>
		 <input type="text" class="form-control" value="${board.views}" readonly>
	  </div>
	  <div class="form-group">
		 <label>작성일</label>
		 <input type="text" class="form-control" value="${board.registeredDate}" readonly> <!-- BoardVO에서 가져온거 -->
		 <!-- 멤버변수가 아니지만 멤버변수처럼 쓸 수 있음. ${board.getRegisteredDate()} -->
	  </div>
  	  <div class="form-group">
		 <label>내용</label>
		 <textarea type="text" class="form-control" readonly>${board.contents}</textarea> <!-- textarea쌍태그라서 가운데에 값넣기 -->
	  </div>
	</div>
</body>
</html>
