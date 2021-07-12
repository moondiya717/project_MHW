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
	<form class="container mt-3" action="<%=request.getContextPath()%>/board/edit" method="POST">
		  <div class="media border p-3">
    		<img src="<%=request.getContextPath()%>/resources/img/boo.png" alt="John Doe" class="mr-3 mt-3 rounded-circle" style="width:60px;">
		    <div class="media-body">
   		      작성자:<input type="text" class="form-control form-control-sm" name="writer" value="${edit.writer}" readonly>  
		      제목:<input type="text" class="form-control form-control-lg" name="title" value="${edit.title}">
		      내용:<textarea class="form-control form-control" rows="12" name="contents">${edit.contents}</textarea>
		      	<input type="hidden" name="num" value="${edit.num}">
	  			<!-- <input type="hidden" name="views" value="${edit.views}"> 
	  			수정하는 동안에 조회수 올랐을때, 수정완료하면서 덮어쓰면 조회수가 깎이니까 service에서 처리해야함-->
	  			<!-- <input type="hidden" name="valid" value="${edit.valid}"> --> <!-- ServiceImp에서 valid처리를 안하면 valid가 필수임 -->
		    </div>
		  </div>
		  	<br> <!-- 취소돌아갈때 기존의 글 내용이 불러와지지가 않네-->
			<a href="<%=request.getContextPath()%>/board/detail?num=${edit.num}"><button type="button" class="btn btn-outline-danger">취소</button></a>		  	
			<button class="btn btn-outline-primary">등록</button>
	</form>
</body>
</html>
