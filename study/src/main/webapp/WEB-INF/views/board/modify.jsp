<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>    
<html>
	<head>
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
		<title>게시글 수정</title>
	</head>
	<body>
		<form class="container" method="post" action="<%=request.getContextPath()%>/board/modify" enctype="multipart/form-data">
		  <h2>게시글 수정</h2>
		  <div class="form-group">
			 <label>제목</label>
			 <input type="text" class="form-control" name="title" value="${board.title}">
		  </div>
	  	  <div class="form-group" hidden>
			 <label>작성자</label>
			 <input type="text" class="form-control" name="writer" value="${board.writer}" readonly>
		  </div>
	  	  <div class="form-group">
			 <label>내용</label>
			 <textarea id="summernote" name="contents" rows="10" class="form-control">${board.contents}</textarea>
		  </div>
	   	  <div class="form-group">
				 <label>첨부파일</label>
		  </div>	   	
		  <input type="hidden" value="${board.num}" name="num">
		  <input type="hidden" value="${board.views}" name="views">
	  	  <a href="<%=request.getContextPath()%>/board/detail?num=${board.num}"><button type="button" class="btn btn-outline-danger">취소</button></a>  
		  <button type="submit" class="btn btn-outline-success">등록</button>
		</form>
	</body>
</html>