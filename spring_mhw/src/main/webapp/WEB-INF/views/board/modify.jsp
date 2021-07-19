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
			 <textarea id="summernote" name="contents">${board.contents}</textarea>
		  </div>
	  	  <c:if test="${fileList !=null}">
		   	  <div class="form-group">
				 <label>첨부파일</label><!-- 다운을할건아니라서 a태그가아니라 div로 -->
				 <div class="uploadBox">
				 <c:forEach var="file" items="${fileList}">
				 	<div class="form-control attachedfile attach">${file.ori_name}<button type="button" class="btn-reset">x</button>
				 	<input type="hidden" name="fileNum" value="${file.num}">
				 	</div>
				 </c:forEach>
				 <c:if test="${fileList == null || fileList.size() < 3 }">
				 	<input type="file" class="form-control addFile" name="file"/>
				 </c:if>
				 </div>
			  </div>
		  </c:if>
	   	
		  <input type="hidden" value="${board.num}" name="num">
		  <input type="hidden" value="${board.views}" name="views">
	  	  <a href="<%=request.getContextPath()%>/board/detail?num=${board.num}"><button type="button" class="btn btn-outline-danger">취소</button></a>  
		  <button type="submit" class="btn btn-outline-success">등록</button>
		</form>
	</body>
	<script type="text/javascript">
		$(function(){
			$(document).on('click','.btn-reset',function(){
				var str = '<input type="file" class="form-control addFile" name="file"/>';
				if($('.attachedfile').length == 3) //이미부모걸 삭제했다고 생각하고 
					$('.uploadBox').append(str)
				$(this).parent().remove();
			})
			
			$(document).on('click','.addFile',function(){
				var str = '<input type="file" class="form-control" name="file"/>';
					$('.uploadBox').children().last().after(str);
			})
		     
			$('#summernote').summernote({
			        placeholder: '내용을 작성하세요.',
			        tabsize: 2,
			        height: 400
			});
		})
	</script>
</html>