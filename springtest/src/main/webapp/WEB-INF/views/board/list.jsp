<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!--이거 없으면 cforEach안돼 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html><!-- DOCTYPE이라고 대문자로 적어도 됨 -->       
<html>
<head>
	<title>게시글 목록</title>
	  <meta charset="utf-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1">
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container clearfix">
	  <h2 class="mb-3">게시글 목록</h2>
	  <p>몬스터주식회사 사원들의 게시판입니다.</p>
	  <form class="input-group float-right mb-3" action="<%=request.getContextPath()%>/board/list"> 
	  	<select class="form-control mr-2" name="type">
	  		<option value="0" <c:if test="${pm.criteria.type == 0}">selected</c:if>>전체</option>
	  		<option value="1" <c:if test="${pm.criteria.type == 1}">selected</c:if>>제목+내용</option>
	  		<option value="2" <c:if test="${pm.criteria.type == 2}">selected</c:if>>작성자</option>
	  	</select>
	  	<input type="text" class="form-control" name ="search">
	  	<button class="btn btn-outline-secondary ml-2">검색</button>
	  </form>
		 <c:if test="${list.size() !=0}">
		  <table class="table table-bordered table-hover">
		    <thead>
		      <tr>
		        <th>번호</th>
		        <th>제목</th>
		        <th>글쓴이</th>
		        <th>등록일</th>
		        <th>조회수</th>        
		      </tr>
		    </thead>
		    <tbody>
		    	<c:forEach items="${list}" var="board"> <!-- controller에서 보낸 addObject의 왼쪽 "화면이름"이랑 items안에 이름을 맞춰야함 -->
			      <tr>
			        <td>${board.num}</td>
			        <td><a href="<%=request.getContextPath()%>/board/detail?num=${board.num}">${board.title}</a></td> <!-- a태그가 밖에있으면 안된다? -->
			        <td>${board.writer}</td>
		   	        <td>${board.dateTime}</td>	     
		  	        <td>${board.views}</td>
			      </tr>
		     	</c:forEach>
		    </tbody>
		  </table>
		   <ul class="pagination justify-content-center">
		    <li class="page-item"><a class="page-link" >이전</a></li>		    				    		
	    	<li class="page-item"><a class="page-link">${index}</a></li>		    	
		    <li class="page-item"><a class="page-link">다음</a></li>		    	
		   </ul> 
		</c:if>
		<c:if test="${list.size() ==0}">
			<h2>게시글이 없습니다.</h2>
		</c:if>
	  <a href="<%=request.getContextPath()%>/board/write"><button class="btn btn-outline-secondary">글쓰기</button></a>
	  <a href="<%=request.getContextPath()%>/board/list"><button class="btn btn-outline-secondary">메인으로</button></a>
	</div>
</body>
</html>
