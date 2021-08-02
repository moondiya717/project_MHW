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
	   	  <div class="form-group file-box">
			 <label>첨부파일</label>
			 <c:forEach items="${fList}" var ="file">
				 <div class="form-control">
				 	<span>${file.ori_name}</span>
				 	<i class="fas fa-trash-alt"></i>
				 	<input type="hidden" name="fileNumList" value="${file.num}">
				 </div>
			 </c:forEach>
			 <c:forEach begin="1" end="${3 - fList.size()}">
			 	<input type="file" class="form-control" name="fileList">
			 </c:forEach>
		  </div>	   	
		  <input type="hidden" value="${board.num}" name="num">
		  <input type="hidden" value="${board.views}" name="views">
	  	  <a href="<%=request.getContextPath()%>/board/detail?num=${board.num}"><button type="button" class="btn btn-outline-danger">취소</button></a>  
		  <button type="submit" class="btn btn-outline-success">등록</button>
		</form>
		<script type="text/javascript">
			$(function(){
				$('.file-box .fa-trash-alt').click(function(){
					//alert(123);
					$(this).parent().remove();
					$('.file-box').append('<input type="file" class="form-control" name="fileList">');
				})
			})
		</script>
	</body>
</html>