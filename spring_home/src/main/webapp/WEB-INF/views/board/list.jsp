<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
		<div class="container">
		  <h2>몬스터 주식회사 게시판</h2>
		  <p>몬스터들아 모여라</p>
		  <table class="table table-hover">
		    <thead>
		      <tr>
		        <th>번호</th>
		        <th>제목</th>
		        <th>작성자</th>
	   	        <th>등록일</th>
	   	        <th>조회수</th>
		      </tr>
		    </thead>
		    <tbody>
		    	<c:forEach items="${list}" var="list">
			      <tr>
			        <td>${list.num}</td>
			        <td>${list.title}</td>
			        <td>${list.writer}</td>
			        <td>${list.registered}</td>
			        <td>${list.views}</td>
			      </tr>
			    </c:forEach>
	   	    </tbody>
		  </table>
		</div>
</body>
</html>