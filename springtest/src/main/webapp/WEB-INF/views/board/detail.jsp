<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!--이거 없으면 cforEach안돼 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html><!-- DOCTYPE이라고 대문자로 적어도 됨 -->       
<html>
<head>
	<title>게시글 상세보기</title>
</head>
<body>
		<div class="container mt-3">
		  <h2>${detail.title}</h2>
		  <p>조회수: ${detail.views}</p>
		  <div class="media border p-3">
    		<img src="<%=request.getContextPath()%>/resources/img/sully.png" alt="John Doe" class="mr-3 mt-3 rounded-circle" style="width:60px;">
		    <div class="media-body">
		      <h4>${detail.writer} <small><i>${detail.dateTime}</i></small></h4>
		      <p>${detail.contents}</p>      
		    </div>
		  </div>
		  	<br>
		  	<div class="input-group">
   				<c:if test="${detail!=null && user.id == detail.writer}">
	   				<form action="<%=request.getContextPath()%>/board/delete" method="post" class="mr-2">
						<input type="hidden" value="${detail.num}" name="num"><!-- a태그가없어서 정확한 게시물번호를 모르니까 input에다가 넣어주는거임 why? URI로 삭제못하게하려고-->
						<button class="btn btn-outline-danger">삭제</button><!-- POST를 이용할거라서 a태그 안하고 form태그 안에있어야 함 -->
					</form> 			    
				    <a href="<%=request.getContextPath()%>/board/edit?num=${detail.num}" class="mr-2"><button class="btn btn-outline-primary">수정</button></a>
				</c:if>			
				<a href="<%=request.getContextPath()%>/board/list" class="mr-2"><button class="btn btn-outline-dark">목록</button></a>
				
			</div>
		</div>
</body>
	<script type = "text/javascript">
		$(function(){
			var msg= '${msg}'
			printMsg(msg);
			history.replaceState({},null,null); //기록값 초기화, 매개변수 생략하면 replaceState 아니고 state아래처럼 됨.
		})
		function printMsg(msg){
			if(msg =='' || history.state){ //history.state : 뒤로가기눌렀을때, 새로고침이아니라 이전기록 불러오는거라 메세지창이 또뜨니까 씀
				return ;
			}
			alert(msg);
		}
	</script> <!-- 쌤은 바디태그 안에 있는 것 같았는데 왜? -->
</html>
