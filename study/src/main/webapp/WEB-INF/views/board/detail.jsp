<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!--이거 없으면 cforEach안돼 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html><!-- DOCTYPE이라고 대문자로 적어도 됨 -->       
<html>
<head>
	<title>게시글 상세보기</title>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/reply.js"></script>
	<style>
		.rocommend-btn{
			font-size:30px;}
		.fa-thumbs-down{
			transform : rotateY(180deg);}
	</style>
</head>
	<body>
		<div class="container mt-3">
		  <h2>${board.title}</h2>
		  <p>조회수: ${board.views}</p>
		  <!-- when은 if로 바꿔쓸수있음 --><!--otherwhise는 else랑 같은기능 -->
		 
		  <div class="media border p-3">
	    		<img src="<%=request.getContextPath()%>/resources/img/sully.png" class="mr-3 mt-3 rounded-circle" style="width:60px;">
			    <div class="media-body">
			      <h4>${board.writer} <small><i>${board.dateTime}</i></small></h4>
			      <div style="height:auto"><p>${board.contents}</p></div>		          
			    </div>
		  </div>
		  <div class="form-group">
		  	<lable>첨부파일</lable>
		  	<c:forEach items ="${fList}" var ="file">
		  		<a href="<%=request.getContextPath()%>/board/download?fileName=${file.name}" class="form-control">${file.ori_name}</a>
		  	</c:forEach>
		  </div>
		  <hr>
  		  <div class="reply form-group">
			    <label>댓글</label>
			    <div class="contents">
			          <div class="reply-list form-group"> <!-- 여기로 댓글이 들어가거등여 -->
			          </div>
			          <div class="container">
						  <ul class="pagination justify-content-center" style="margin:20px 0"><!-- 여기에 페이지네이션있어 reply.js로 이동함-->
						  </ul>
					   </div>
	     	    </div>
    	      <div class="reply-box form-group">
		          <textarea class="reply-input form-control mb-2"></textarea>
		          <button type="button" class="reply-btn btn btn-outline-success">등록</button>
	          </div>
	      </div>
	      <c:if test="${board.groupOrd == 0 && board.type !='NOTICE' && (user != null && user.authority != 'USER')}">
			  <a href="<%=request.getContextPath()%>/board/reply/register?oriNo=${board.num}">
			  	<button class="btn btn-outline-primary">답변</button>
			  </a>	
		  </c:if>
		  <c:if test="${user != null && user.id == board.writer }"> <!-- 버튼호버하면 밑줄생기는것때문에 style태그넣어줌, 엔터쳐놔서그렇다고함 -->
		  	<a href ="<%=request.getContextPath()%>/board${type}/modify?num=${board.num}" style="text-decoration:none">
		  		<button class="btn btn-outline-secondary">수정</button>
		  	</a>
		  	<a href ="<%=request.getContextPath()%>/board${type}/delete?num=${board.num}" style="text-decoration:none">
		  		<button class="btn btn-outline-danger">삭제</button>
		  	</a>
		  	<a href ="<%=request.getContextPath()%>/board${type}/list" style="text-decoration:none">
		  		<button class="btn btn-outline-primary">목록</button>
		  	</a>
		  </c:if>
		 </div>
	</body>
</html>
