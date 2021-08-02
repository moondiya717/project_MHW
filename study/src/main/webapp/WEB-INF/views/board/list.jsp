<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<title>일반게시판</title>
</head>
<body>	
	<div class="container">
	  <h2>일반게시판</h2>
	  <a href="<%=request.getContextPath()%>/board/register">
	  	<button class="btn btn-outline-success">글쓰기</button>
	  </a>
	  <table class="table thead-light table-hover">
	    <thead class="thead-dark">
	      <tr>
	        <th>번호</th>
	        <th>제목</th>
	        <th>작성자</th>
	        <th>작성일</th>
	        <th>조회수</th>
	      </tr>
	    </thead>
	    <tbody>
			<c:forEach items="${list}" var="board">
				<tr>
				  <td>${board.num}</td>
				  <td>
				  	<a href="<%=request.getContextPath()%>/board/detail?num=${board.num}">
				  		<c:if test="${board.groupOrd !=0}">┗답변:</c:if>
				  		${board.title}</a>
				  </td>
				  <td>${board.writer}</td>
				  <td>${board.dateTime}</td>	        
				  <td>${board.views}</td>	        
				</tr>
			</c:forEach>
	    </tbody>
	  </table>
	  <ul class="pagination justify-content-center">
	  	<c:if test="${pm.prev}">
	    	<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.startPage-1}">이전</a></li>
	    </c:if>
		<c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="index">
			<c:choose>
				<c:when test="${pm.criteria.page == index}">
			    	<li class="page-item active"><a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${index}">${index}</a></li>
				</c:when>
				<c:otherwise>
			    	<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${index}">${index}</a></li>				
				</c:otherwise>
			</c:choose>
		</c:forEach>
	    <c:if test="${pm.next}">
	    	<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.endPage+1}">다음</a></li>
	    </c:if>
	    
	  </ul>
	</div>
</body>
</html>