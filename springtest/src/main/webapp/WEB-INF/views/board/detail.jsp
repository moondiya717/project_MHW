<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!--이거 없으면 cforEach안돼 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html><!-- DOCTYPE이라고 대문자로 적어도 됨 -->       
<html>
<head>
	<title>게시글 상세보기</title>
	  <meta charset="utf-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1">
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
		<div class="container mt-3">
		  <h2>${detail.title}</h2>
		  <p>조회수: ${detail.views}</p>
		  <div class="media border p-3">
    		<img src="<%=request.getContextPath()%>/resources/img/sully.png" alt="John Doe" class="mr-3 mt-3 rounded-circle" style="width:60px;">
		    <div class="media-body">
		      <h4>${detail.writer} <small><i>${detail.dateTime}</i></small></h4>
		      <p>${detail.contents}</p>      
		    </div>
		  </div>
		  	<br>
		    <a href="<%=request.getContextPath()%>/board/edit?num=${detail.num}"><button class="btn btn-outline-primary">수정</button></a>
			<a href="<%=request.getContextPath()%>/board/delete?num=${detail.num}"><button class="btn btn-outline-danger">삭제</button></a>
			<a href="<%=request.getContextPath()%>/board/list"><button class="btn btn-outline-dark">목록</button></a>
		</div>
</body>
</html>
