<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>    
<html>
<head>
</head>
<body>
	<form class="container" method="post" action="<%=request.getContextPath()%>/board/reply/register">
	  <h2>게시글 등록</h2>
	  <div class="form-group"> <!--문의답변할때, 따로 입력하지 않고 게시글제목을가져오려면 serviceImp코드추가하고 여기제목구간을 삭제-->
		 <label>제목</label>
		 <input type="text" class="form-control" name="title">
	  </div>
  	  <div class="form-group">
		 <label>내용</label>
		 <textarea id="summernote" name="contents" class="form-control" rows="10"></textarea>
	  </div>
	  <input type="hidden" name="oriNo" value="${oriNo}">
	  <a href="<%=request.getContextPath()%>/board/list"><button type="button" class="btn btn-outline-danger">취소</button></a>
	  <button type="submit" class="btn btn-outline-success">등록</button>
	</form>
</body>
</html>
