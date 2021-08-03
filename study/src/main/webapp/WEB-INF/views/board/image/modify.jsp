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
		<form class="container" method="post" enctype="multipart/form-data">
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
		  <div class="form-group thumbnail-box">
		  	<label>대표 이미지</label>
		  	<div class="form-control">
			 	<span>${fList.get(0).ori_name}</span>
			 	<i class="fas fa-trash-alt"></i>
			 	<input type="hidden" name="thumbnailNo" value="${fList.get(0).num}">
			 </div>
		  </div>
	   	  <div class="form-group file-box">
			 <label>첨부파일</label>
			 <c:forEach items="${fList}" var ="file">
			 	<c:if test="${file.thumbnail == 'N'}">
					 <div class="form-control">
					 	<span>${file.ori_name}</span>
					 	<i class="fas fa-trash-alt"></i>
					 	<input type="hidden" name="fileNumList" value="${file.num}">
					 </div>
				 </c:if>
			 </c:forEach>
			 <c:forEach begin="1" end="${3 - fList.size() + 1}"> <!-- 최대 4개까지 가능하게 할 수 있도록(첨부파일3+썸네일) -->
			 	<input type="file" class="form-control" name="fileList">
			 </c:forEach>
		  </div>	   	
		  <input type="hidden" value="${board.num}" name="num">
		  <input type="hidden" value="${board.views}" name="views">
	  	  <a href="<%=request.getContextPath()%>/board${type}/detail?num=${board.num}"><button type="button" class="btn btn-outline-danger">취소</button></a>  
		  <button type="submit" class="btn btn-outline-success">등록</button>
		</form>
		<script type="text/javascript">
			$(function(){
				$('.file-box .fa-trash-alt').click(function(){
					//alert(123);
					$(this).parent().remove();
					$('.file-box').append('<input type="file" class="form-control" name="fileList">');
				})
				$('.thumbnail-box .fa-trash-alt').click(function(){					
					$(this).parent().remove();
					$('.thumbnail-box').append('<input type="file" class="form-control" name="mainImage">');
				})
				$('form').submit(function(){
					if(typeof $('[name=thumbnailNo]').val() == 'undefined' && $('[name=mainImage]').val() == ''){
						alert('대표 이미지를 선택하세요.')
						return false;
					}
					return true;
				})	
		    	$('#summernote').summernote({
			        placeholder: 'Hello Bootstrap 4',
			        tabsize: 2,
			        height: 100
		     	});
			})
		</script>
	</body>
</html>