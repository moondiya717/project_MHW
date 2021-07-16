<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!--이거 없으면 cforEach안돼 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html><!-- DOCTYPE이라고 대문자로 적어도 됨 -->       
<html>
<head>
	<title>게시글 상세보기</title>
</head>
<body>
	<form class="container mt-3" action="<%=request.getContextPath()%>/board/write" method="POST" enctype="multipart/form-data" >
		  <div class="media border p-3 mb-5">
    		<img src="<%=request.getContextPath()%>/resources/img/boo.png" class="mr-3 mt-3 rounded-circle" style="width:60px;">
		    <div class="media-body">
		      제목:<input type="text" class="form-control form-control-lg" name="title" value="${board.title}" >
		      내용:<textarea class="form-control form-control" rows="12" name="contents" >${board.contents}</textarea> 
		      첨부파일:
		      <input type="file" class="form-control form-control-lg" name="files">
		      <input type="file" class="form-control form-control-lg" name="files">
		      <input type="file" class="form-control form-control-lg" name="files">
		    </div><!-- required로 빈board 입력안되게 하는건 좋은데 미관상 너무 나뻐 --> 

		  </div>
			<a href="<%=request.getContextPath()%>/board/list"><button type="button" class="btn btn-outline-danger">취소</button></a>		  	
			<button class="btn btn-outline-primary">등록</button>
	</form>
</body>
</html>
