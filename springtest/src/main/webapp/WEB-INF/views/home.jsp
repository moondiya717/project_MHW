<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>  
<html>
<head>
	<title>Home</title>
	  <meta charset="utf-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1">
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
	  <a class="navbar-brand" href="<%=request.getContextPath()%>/springtest/">SPRINGTEST</a>
	  <ul class="navbar-nav">
	    <li class="nav-item">
	      <a class="nav-link" href="<%=request.getContextPath()%>/board/list">게시판</a>
	    </li>
	    
	    <c:if test="${user==null}">
		    <li class="nav-item">
		      <a class="nav-link" href="<%=request.getContextPath()%>/signin">로그인</a>
		    </li>
	   	    <li class="nav-item">
		      <a class="nav-link" href="<%=request.getContextPath()%>/signup">회원가입</a>
		    </li>
	    </c:if>
   	 	
   	 	<c:if test="${user!=null}">
	   	    <li class="nav-item">
		      <a class="nav-link" href="<%=request.getContextPath()%>/mypage">마이페이지</a>
		    </li>
	    </c:if>
	    
	  </ul>
	</nav>
	<div class="container-fluid" style="margin-top:80px">
	  <h3>Be our family member!</h3>
	</div>
	
 	${user}
</body>
</html>
