<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시판 상세글보기</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container" item="{detail}">
	  <h2>${detail.title}</h2>
	  <p>${detail.registeredDateTime}</p>
	  <form action="/board/detail?num=${detail.num}">
	    <div class="form-group">
	      <label for="">작성자:</label>
	      <input type="text" class="form-control" id="writer" value="${detail.writer}" readonly>
	    </div>
	    <div class="form-group">
	      <label for="">조회수:</label>
	      <input type="text" class="form-control" id="views" value="${detail.views}" readonly>
	    </div>
	 	 <div class="form-group">
			  <label for="">내용:</label>
			  <textarea class="form-control" rows="5" id="contents">${detail.contents}</textarea>
		  </div>
  	    <a href="<%=request.getContextPath()%>/board/delete?num=${detail.num}"><button type="button" class="btn btn-danger">삭제하기</button></a>
  	    <button type="submit" class="btn btn-primary">수정하기</button>
  	    <a href="<%=request.getContextPath()%>/board/list"><button type="button" class="btn btn-secondary">목록으로</button></a>	  
  	    	  
  	    	  
  	  </form>
	  
	</div>
</body>
</html>