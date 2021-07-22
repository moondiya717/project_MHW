<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<html>
<head>
	<title>게시판 목록</title>
	  <meta charset="utf-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1">
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <a class="navbar-brand" href="<%=request.getContextPath()%>/">Practice</a>
	  <ul class="navbar-nav">
	    <li class="nav-item">
	      <a class="nav-link" href="<%=request.getContextPath()%>/board/list">게시판</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="<%=request.getContextPath()%>/member/signin">로그인</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="<%=request.getContextPath()%>/member/signup">회원가입</a>
	    </li>
	  </ul>
	</nav>
	
	<div class="container">
	  <form action="<%=request.getContextPath()%>/board/detail?num=${detail.num}">
		<div class="form-group">
		  <label>제목</label>
		  <input type="text" class="form-control" value="${detail.title}" readonly>
		</div>
		<div class="form-group">
		  <label>조회수</label>
		  <input type="text" class="form-control" value="${detail.views}" readonly>
		</div>
		<div class="form-group">
		  <label for="comment">내용:</label>
		  <textarea class="form-control" rows="5" id="contents" readonly>${detail.contents}</textarea>
		</div>
	  </form>
	    <a href="<%=request.getContextPath()%>/board/list"><button type="button" class="btn btn-primary">목록</button></a>
  	    <a href="#"><button type="button" class="btn btn-primary">수정</button></a>
   	    <a href="#"><button type="button" class="btn btn-primary">삭제</button></a>	    
	</div>
</body>
</html>
