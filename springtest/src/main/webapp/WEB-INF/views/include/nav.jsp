<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>nav</title> 
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
	  <a class="navbar-brand" href="<%=request.getContextPath()%>/">SPRINGTEST</a>
	  <ul class="navbar-nav">
	    <li class="nav-item">
	      <a class="nav-link" href="<%=request.getContextPath()%>/board/list">게시판</a>
	    </li>  
	    <c:if test="${user==null}">
		    <li class="nav-item">
		      <a class="nav-link" href="<%=request.getContextPath()%>/member/signin">로그인</a>
		    </li>
	   	    <li class="nav-item">
		      <a class="nav-link" href="<%=request.getContextPath()%>/member/signup">회원가입</a>
		    </li>
	    </c:if>
   	 	<c:if test="${user!=null}">
	   	    <li class="nav-item">
		      <a class="nav-link" href="<%=request.getContextPath()%>/member/mypage">마이페이지</a>
	        </li>
        	<li class="nav-item">
        	  <a class="nav-link" href="<%=request.getContextPath()%>/logout">로그아웃</a>
		    </li>
	    </c:if>
	  </ul>
	</nav>
</body>
</html>