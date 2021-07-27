<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!--이거 없으면 cforEach안돼 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html><!-- DOCTYPE이라고 대문자로 적어도 됨 -->       
<html>
<head>
	<title>게시글 목록</title>
</head>
<body>
	<div class="container clearfix">
	  <h1 class="mb-3">게시글 목록</h1>
	  <p>몬스터주식회사 사원들의 게시판입니다.</p>
	  <form class="input-group float-right mb-3" action="<%=request.getContextPath()%>/board/list"> 
	  	<select class="form-control mr-2" name="type">
	  		<option value="0" <c:if test="${pm.criteria.type == 0}">selected</c:if>>전체</option>
	  		<option value="1" <c:if test="${pm.criteria.type == 1}">selected</c:if>>제목+내용</option>
	  		<option value="2" <c:if test="${pm.criteria.type == 2}">selected</c:if>>작성자</option>
	  	</select>
	  	<input type="text" class="form-control" name ="search" value="<c:out value="${pm.criteria.search}"/>">
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
		   	        <td>${board.getDateTime()}</td>	     
		  	        <td>${board.views}</td>
			      </tr>
		     	</c:forEach>
		    </tbody>
		  </table>
		   <ul class="pagination justify-content-center">
		    <c:if test="${pm.prev}">
		    	<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.startPage-1}&type=${pm.criteria.type}&search=<c:out value="${pm.criteria.search}"/>">이전</a></li>		    				    		
	    	</c:if>
	    	<c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="index">
	    		<li class="page-item <c:if test="${pm.criteria.page ==index}">active</c:if>"><a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${index}&type=${pm.criteria.type}&search=<c:out value="${pm.criteria.search}"/>">${index}</a></li>		    	
		    </c:forEach>
		    <c:if test="${pm.next}">
		    	<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.endPage+1}&type=${pm.criteria.type}&search=<c:out value="${pm.criteria.search}"/>">다음</a></li>
		    </c:if>		    	
		   </ul> 
		</c:if>
		<c:if test="${list.size() ==0}">
			<h2>게시글이 없습니다.</h2>
		</c:if>
	  <c:if test="${user!=null}">
	  	<a href="<%=request.getContextPath()%>/board/write"><button class="btn btn-outline-secondary">글쓰기</button></a>
	  </c:if>
	  <a href="<%=request.getContextPath()%>/"><button class="btn btn-outline-secondary">메인으로</button></a>
	</div>
</body>
</html>
