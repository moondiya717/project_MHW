<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>    
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
<body>
	<form class="container" method="post" enctype="multipart/form-data">
	  <h2>게시글 등록</h2>
	  <div class="form-group">
		 <label>제목</label>
		 <input type="text" class="form-control" name="title">
	  </div>
  	  <div class="form-group">
		 <label>내용</label>
		 <textarea id="summernote" name="contents" class="form-control" rows="10"></textarea>
	  </div>
	  <div class="form-group">
	  	<input type="file" name="fileList" class="form-control">
	  	<input type="file" name="fileList" class="form-control">
	  	<input type="file" name="fileList" class="form-control">
	  </div>
	  <a href="<%=request.getContextPath()%>/board${type}/list"><button type="button" class="btn btn-outline-danger">취소</button></a>
	  <button type="submit" class="btn btn-outline-success">등록</button>
	</form>
    <script>
      $('#summernote').summernote({
        placeholder: 'Hello Bootstrap 4',
        tabsize: 2,
        height: 100
      });
    </script>
</body>
</html>
