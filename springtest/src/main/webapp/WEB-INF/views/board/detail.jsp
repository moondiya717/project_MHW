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
		  <h2>${detail.title}</h2>
		  <p>조회수: ${detail.views}</p>
		  <!-- when은 if로 바꿔쓸수있음 --><!--otherwhise는 else랑 같은기능 -->
		  
		  <div>
			  <a href="#" class="recommend-btn up">
	  			<c:choose>
				  	<c:when test="${recommend !=null && recommend.state ==1}">
				  		<i class="fas fa-thumbs-up"></i>
				  	</c:when>
				  	<c:otherwise>
				  		<i class="far fa-thumbs-up"></i>
				  	</c:otherwise>
			  	</c:choose>
			  </a>
			  
			  <a href="#" class="recommend-btn down">
	  			<c:choose>
				  	<c:when test="${recommend !=null && recommend.state ==-1}">
				  		<i class="fas fa-thumbs-down"></i>
				  	</c:when>
				  	<c:otherwise>
				  		<i class="far fa-thumbs-down"></i>
				  	</c:otherwise>
			  	</c:choose>
			  </a>
		  </div>
		  <div class="media border p-3">
	    		<img src="<%=request.getContextPath()%>/resources/img/sully.png" class="mr-3 mt-3 rounded-circle" style="width:60px;">
			    <div class="media-body">
			      <h4>${detail.writer} <small><i>${detail.dateTime}</i></small></h4>
			      <div style="height:auto"><p>${detail.contents}</p></div>		          
			    </div>
			    <div class="border p-3">
				    <label>첨부파일</label>
				    <c:forEach items="${fileList}" var="file">
			        	<br><a href="<%=request.getContextPath()%>/board/download?fileName=${file.name}">${file.ori_name}</a>
			        </c:forEach>
		        </div>
			</div>
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
		    	      <div class="reply-box form-group"></div>
			          <textarea class="reply-input form-control mb-2"></textarea>
			          <button type="button" class="reply-btn btn btn-outline-success">등록</button>
		    </div>
		  	<div class="input-group">
				<a href="<%=request.getContextPath()%>/board/list"><button class="btn btn-outline-dark">목록</button></a>
   				<c:if test="${detail!=null && user.id == detail.writer}">
	   				<form action="<%=request.getContextPath()%>/board/delete" method="post" class="mr-2">
						<input type="hidden" value="${detail.num}" name="num"><!-- a태그가없어서 정확한 게시물번호를 모르니까 input에다가 넣어주는거임 why? URI로 삭제못하게하려고-->
					</form> 			    
					<!-- POST를 이용할거라서 a태그 안하고 form태그 안에있어야 함 => 근데지금 뺀 상태 -->
					<a href="<%=request.getContextPath()%>/board/delete?num=${detail.num}"><button class="btn btn-outline-danger">삭제</button></a>					
				    <a href="<%=request.getContextPath()%>/board/edit?num=${detail.num}" class="ml-2"><button class="btn btn-outline-primary">수정</button></a>
				</c:if>			
			</div>
		 </div>
</body>
	<script type = "text/javascript">
	//전역변수 처리
	//게시글번호
	var rp_bd_num = '${detail.num}';
	//프로젝트명
	var contextPath = '<%=request.getContextPath()%>';
	//$function에 화면출력부분이 아닌건 안들어가도 됨 =>전역변수
	
	
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
		$('.recommend-btn').click(function(e){
			e.preventDefault();
			var board = '${detail.num}';
			var state = $(this).hasClass('up')? 1: -1;
			$.ajax({
				type: 'get', 
				url : '<%=request.getContextPath()%>/board/recommend/'+board+'/'+state,
				success : function(result, status, xhr){
					$('.recommend-btn i').removeClass('fas').addClass('far');
					//console.log(result);
					if(result == 'UP'){
						alert('해당 게시글을 추천했습니다.');
						$('.recommend-btn.up i').addClass('fas');
					}else if(result == 'DOWN'){
						alert('해당 게시글을 비추천했습니다.')
						$('.recommend-btn.down i').addClass('fas');
					}else if(result == 'GUEST'){
						alert('추천/비추천을 하려면 로그인을 하세요.')
					}else if(result == 'CANCEL'){
						if(state == 1){
							alert('추천을 취소했습니다.')
						}else{
							alert('비추천을 취소했습니다.');
						}
					}
					
				},
				error : function(xhr, status, e){
					console.log('에러발생');
				}				
			})
		})
		$(function(){
			replyService.list(contextPath, rp_bd_num, 1);
		})
		
		
		$(function(){
			$('.reply-btn').click(function(){
				var rp_bd_num = '${detail.num}';
				var rp_content = $('.reply-input').val();
				var rp_me_id = '${user.id}';
				if(rp_me_id == ''){
					alert('로그인 하세요.');
					return;
				}
				var data = {
						'rp_bd_num' : rp_bd_num, //속성명 : 변수
						'rp_content' : rp_content,
						'rp_me_id' : rp_me_id
				};
				//js파일에선 안먹히니까 변수로 전환해서 처리
				replyService.insert(contextPath,data);
			})
			$(document).on('click','.pagination .page-item', function(){ //일반click이벤트는 계속 추가되는거라서 이벤트가 안먹음
				var page = $(this).attr('data');
				//console.log(page);
				replyService.list(contextPath, rp_bd_num, page);
			})
		})		
	</script>
</html>
