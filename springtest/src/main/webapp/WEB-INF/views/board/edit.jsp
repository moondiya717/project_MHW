<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!--이거 없으면 cforEach안돼 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html><!-- DOCTYPE이라고 대문자로 적어도 됨 -->       
<html>
<head>
	<title>게시글 상세보기</title>
</head>
<body>
	<form enctype="multipart/form-data" class="container mt-3" action="<%=request.getContextPath()%>/board/edit" method="POST" >
		  <div class="media border p-3">
    		<img src="<%=request.getContextPath()%>/resources/img/boo.png" class="mr-3 mt-3 rounded-circle" style="width:60px;">
		    <div class="media-body">
   		      <label>작성자:</label><input type="text" class="form-control form-control-sm mb-2" name="writer" value="${edit.writer}" readonly>  
		      <label>제목:</label><input type="text" class="form-control form-control-lg mb-2" name="title" value="${edit.title}">
		      <label>내용:</label><textarea class="form-control form-control mb-2" rows="12" name="contents">${edit.contents}</textarea>
		      	<input type="hidden" name="num" value="${edit.num}">
	  			<!-- <input type="hidden" name="views" value="${edit.views}"> 
	  			수정하는 동안에 조회수 올랐을때, 수정완료하면서 덮어쓰면 조회수가 깎이니까 service에서 처리해야함-->
	  			<!-- <input type="hidden" name="valid" value="${edit.valid}"> --> <!-- ServiceImp에서 valid처리를 안하면 valid가 필수임 -->
   		      <div class="media-body file-box">
			      <label>첨부파일:</label>
			      <c:forEach items="${fileList}" var="file">
				      <div class="form-control mb-2">
				      	<span>${file.ori_name}</span>
				      	<input type="hidden" value="${file.num}" name="filenums">
				      	<button type="button" class="btn btn-outline-danger del-btn">X</button>
				      </div>
  			      </c:forEach>
  			      <c:forEach begin="1" end="${3 - fileList.size()}">
  			      	<input type="file" class ="form-control mb-2" name="files">
  			      </c:forEach>		
		      </div>
		    </div>
		  </div>
		  	<br> <!-- 취소돌아갈때 기존의 글 내용이 불러와지지가 않네-->
			<a href="<%=request.getContextPath()%>/board/detail?num=${edit.num}"><button type="button" class="btn btn-outline-danger">취소</button></a>		  	
			<button class="btn btn-outline-primary">등록</button>
	</form>
	<script type="text/javascript">
		$(function(){
			$('.del-btn').click(function(){
				$(this).parent().remove();
				$('.file-box').append('<input type="file" class ="form-control mb-2" name="files">');
			})
		})
	</script>
	
</body>
</html>
