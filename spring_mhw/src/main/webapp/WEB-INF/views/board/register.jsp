<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>    
<html>
<head>
	<title>게시글 등록</title>
</head>
<body><!-- enctype가 있어야돼 그래야 파일이가고, 없으면 파일이름만감 -->
	<form class="container" method="post" action="<%=request.getContextPath()%>/board/register" enctype="multipart/form-data">
	  <h2>게시글 등록</h2>
	  <div class="form-group">
		 <label>제목</label>
		 <input type="text" class="form-control" name="title">
	  </div>
<!--   	  <div class="form-group">
		 <label>작성자</label>
		 <input type="text" class="form-control" name="writer" value="${user.id}" readonly>
	  </div> -->
  	  <div class="form-group">
		 <label>내용</label>
		 <textarea type="text" class="form-control" rows="10" name="contents"></textarea>
	  </div>
	   <div class="form-group files">
		        <label>파일</label>
	        	<input type="file" class="form-control fileUpload" name="file" data=""/>
    	</div>
	  <a href="<%=request.getContextPath()%>/board/list"><button type="button" class="btn btn-outline-danger">취소</button></a>
	  <button type="submit" class="btn btn-outline-success">등록</button>
	</form>
</body>
<script type="text/javascript">
	$(function(){
		$(document).on('change','input[name=file]',function(){
			var val = $(this).val();
			var str = '<input type="file" class="form-control" name="file" data=""/>';
			var length = $('input[name=file]').length;
			var data = $(this).attr('data');
			//
			if(val == ''){
				$(this).remove();
				if(length == 3 && $('input[name=file]').last().val() !=''){
					$('.files').append(str);
				}
			}
			//input태그를 추가해야하는 경우
			else{
				if(length <3 && data == ''){
					$('.files').append(str);
					$(this).attr('data');
				}
				$(this).attr('data',val);
			}
		})
	})
	
</script>
</html>
