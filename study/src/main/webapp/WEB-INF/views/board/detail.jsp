<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!--이거 없으면 cforEach안돼 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html><!-- DOCTYPE이라고 대문자로 적어도 됨 -->       
<html>
<head>
	<title>게시글 상세보기</title>
	<!-- 만들고여기 src넣어서 연결해줌 -->
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
			          <div class="reply-list form-group"> 
			          	 <!-- 여기서 화면에 댓글 어떻게 보일지 처리한다음에 잘라내기해서 list쪽에 str통해서 넣어줌 -->
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
		 <script type="text/javascript">
			var rp_bd_num = '${board.num}';
			var rp_me_id= '${user.id}';
			var contextPath = '<%=request.getContextPath()%>';
			$(function(){
				$('.reply-btn').click(function(){
					//console.log(123); //버튼이 작동하는 것을 확인했음
					if(rp_me_id == ''){
						alert('로그인을 하세요.');
						return ;
					}
					var rp_content =$('.reply-input').val();
					var data = {
							rp_bd_num : rp_bd_num, rp_content:rp_content							
					}
					replyService.add(contextPath, data, addOk, listOk);
				})
				$(document).on('click','.reply .pagination li', function(){
					page = $(this).attr('data-page');
					replyService.list(contextPath, {page:page, rp_bd_num:rp_bd_num}, listOk);
				})
				replyService.list(contextPath, {page:1, rp_bd_num:rp_bd_num}, listOk); //잠시 주석처리하고 샘플코드를 만들어서 모양을 잡은 뒤 다시 주석해제처리
			})
			
			function addOk(res){
				if(res == 'OK'){
					alert('댓글이 등록되었습니다.');
				}else{
					alert('댓글 등록에 실패했습니다.');
				}
			}
			
			function listOk(res){
				var list = res.list;
				var str = '';
				for(i=0; i<list.length; i++){
					str +=
						'<div class="input-group">'+
			          	 	'<div class="input-group-prepend">'+
			          			'<div class="input-group-text">'+list[i].rp_me_id+'</div>'+
			          		'</div>'+
			          		'<div class="form-control reply-content">'+list[i].rp_content+'</div>'+
			          		'<div class="input-group-append">';
			          			if(list[i].rp_me_id == rp_me_id){			          				
				     str +=
					          			'<button class="btn btn-outline-primary reply-mod-btn">수정</button>'+
					          			'<button class="btn btn-outline-danger reply-del-btn">삭제</button>'
				          		}
			         str +=
			          		'</div>'+
		          	 	'</div>'
				}
				$('.reply-list').html(str);
				str = '';
				var pm = res.pm;
				console.log(pm);
				if(pm.prev){ //javascript:void(0); 하면 #기능(이동하면서 페이지가 맨위로 가버리는걸) 막아줌
					str += '<li class="page-item" data-page="'+(pm.startPage-1)+'"><a class="page-link" href="javascript:void(0);">이전</a></li>'; 
				}
				for(i=pm.startPage; i<=pm.endPage; i++){
					if(pm.criteria.page != i){
				    	str += '<li class="page-item" data-page="'+i+'"><a class="page-link" href="javascript:void(0);">'+i+'</a></li>';
					}else{
				    	str += '<li class="page-item active" data-page="'+i+'"><a class="page-link" href="javascript:void(0);">'+i+'</a></li>'
					}
				}
				if(pm.next){
					str += '<li class="page-item" data-page="'+(pm.endPage+1)+'"><a class="page-link" href="javascript:void(0);">다음</a></li>'; 
				}    
				$('.pagination').html(str);
				    
				
				
			}
		 </script>
	</body>
</html>
