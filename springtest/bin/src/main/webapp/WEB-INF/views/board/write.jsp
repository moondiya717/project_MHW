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
	<form class="container mt-3" action="<%=request.getContextPath()%>/board/write" method="POST">
		  <div class="media border p-3">
    		<img src="<%=request.getContextPath()%>/resources/img/boo.png" alt="John Doe" class="mr-3 mt-3 rounded-circle" style="width:60px;">
		    <div class="media-body">
   		      작성자:<input type="text" class="form-control form-control-sm" name="writer">  
		      제목:<input type="text" class="form-control form-control-lg" name="title">
		      내용:<textarea class="form-control form-control" rows="12" name="contents"></textarea>      
		    </div>
		  </div>
		  	<br>
			<a href="<%=request.getContextPath()%>/board/list"><button type="button" class="btn btn-outline-danger">취소</button></a>		  	
			<button class="btn btn-outline-primary">등록</button>
	</form>
</body>
</html>
