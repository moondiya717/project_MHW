<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>    
<html>
<head>
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
		 <textarea type="text" class="form-control" rows="10" name="contents">${board.contents}</textarea>
	  </div>
  	  <c:if test="${file !=null}">
	   	  <div class="form-group">
			 <label>첨부파일</label><!-- 다운을할건아니라서 a태그가아니라 div로 -->
			 <div class="form-control attachedfile">${file.ori_name}<button type="button" class="btn-reset">x</button></div>
		  </div>
	  </c:if>
   	  <c:if test="${file ==null}">
	  	<div class="form-group">
	        <label>첨부파일</label>
	        <input type="file" class="form-control addfile" name="file"/>
    	</div>
	  </c:if>
	  <input type="hidden" value="${board.num}" name="num">
	  <input type="hidden" value="${board.views}" name="views">
  	  <a href=<%=request.getContextPath()%>/board/detail?num=${board.num}><button type="button" class="btn btn-outline-danger">취소</button></a>  
	  <button type="submit" class="btn btn-outline-success">등록</button>
	</form>
</body>
<script type="text/javascript">
	$(function(){
		//	$('.btn-reset').click(function(){
		//	var str = '<input type="file" class="form-control addfile" name="file"/>';
		//	$('.attachedfile').before(str).remove();
			
		$(document).on('click','.btn-reset',function(){
			var str = '<input type="file" class="form-control addfile" name="file"/>';
			$('.attachedfile').before(str).remove();
		})
	})
</script>
</html>