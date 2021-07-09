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
	<div class="container">
	  <h2>게시글 목록</h2>
	  <p>몬스터주식회사 사원들의 게시판입니다.</p>            
	  <table class="table table-dark table-hover">
	    <thead>
	      <tr>
	        <th>게시글번호</th>
	        <th>제목</th>
	        <th>글쓴이</th>
	        <th>작성일자</th>
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
	  <a href="<%=request.getContextPath()%>/board/write"><button class="btn btn-outline-secondary">글쓰기</button></a>
	</div>
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
	</script>
</body>
</html>
