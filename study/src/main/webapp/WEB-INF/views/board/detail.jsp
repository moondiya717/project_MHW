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
		  	<label>첨부파일</label>
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
				//댓글 등록 버튼 클릭
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
					replyService.add(contextPath, data, responseOk, listOk);
					$('.reply-input').val('');
				})
				//페이지네이션에서 페이지 클릭했을 때 해당 댓글 페이지로 이동
				$(document).on('click','.reply .pagination li', function(){
					page = $(this).attr('data-page');
					replyService.list(contextPath, {page:page, rp_bd_num:rp_bd_num}, listOk);
				})
				//댓글 수정 버튼 클릭
				$(document).on('click','.reply-mod-btn', function(){
					//console.log(123); //버튼작동확인함
					//클릭한 수정 버튼이 있는 댓글의 내용
					var rp_content = $(this).parent().siblings('.reply-content').text(); //this => 수정버튼
					
					//댓글을 수정중에 다른 댓글을 수정하려고 했을 때, 이전 수정하던 내용은 취소하고 새롭게 누른 댓글만 수정할 수 있도록 처리
					$('.reply .reply-content').each(function(){ //each = 해당 요소들 각각
						var rp_content = $(this).text(); //this => 수정하려고하는 댓글 칸(reply-content 요소 하나하나)
						var str = '<div class="form-control reply-content">'+rp_content+'</div>';
						$(this).before(str); 
						$(this).remove();
						//수정 버튼 보여주고 등록 버튼 감춤
						$('.reply .reply-ok-btn').remove();
						$('.reply .reply-mod-btn').show();
					})
					//$(this).parent() : 버튼 그룹(수정, 삭제 버튼을 가진 그룹)
					$(this).parent().siblings('.reply-content').remove();
					var str = '<textarea class="form-control reply-content">'+rp_content+'</textarea>';
					$(this).parent().before(str);
							
					//수정버튼을 등록버튼으로 바꾸기
					//수정버튼 감추기 
					$(this).hide();
					//등록버튼 추가
					str = '<button class="btn btn-outline-success reply-ok-btn">등록</button>';
					$(this).before(str);
				})
				//수정 버튼 눌렀을 때 나타나는 등록 버튼 클릭
				$(document).on('click','.reply-ok-btn', function(){					
					var rp_num = $(this).siblings('.rp_num').val(); //댓글번호					
					var rp_content = $(this).parent().siblings('.reply-content').val(); //수정된 댓글 내용
					//수정된 댓글이 있는 페이지(수정된 이후에, 수정하던 페이지를 유지하기 위함/1페이지로 이동을 막기위해서)
					var page = $('.reply .pagination .active a').html(); 
					//console.log(rp_num, rp_content, page); //콘솔에 내용이 나오는걸 확인함, 등록눌렀을땐 수정내용까지 나와야함
					var data = {page:page, rp_bd_num:rp_bd_num, rp_num:rp_num, rp_content:rp_content};
					replyService.mod(contextPath, data, responseOk, listOk);
				});
				//삭제 버튼을 클릭
				$(document).on('click','.reply-del-btn', function(){	
					var rp_num = $(this).siblings('.rp_num').val();
					var data ={rp_num : rp_num, rp_bd_num:rp_bd_num}
					replyService.del(contextPath, data, responseOk, listOk)					
				});
				
				//시작시 댓글 1페이지 내용 가져오기
				replyService.list(contextPath, {page:1, rp_bd_num:rp_bd_num}, listOk); //잠시 주석처리하고 샘플코드를 만들어서 모양을 잡은 뒤 다시 주석해제처리
			})
			
			function responseOk(res, str){
				if(res == 'OK'){
					alert('댓글이 '+ str + '되었습니다.');
				}else{
					alert('댓글 '+ str+'에 실패했습니다.');
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
					          			'<button class="btn btn-outline-danger reply-del-btn">삭제</button>'+
					          			'<input type="hidden" class="rp_num" value="'+list[i].rp_num+'">'
				          		}
			         str +=
			          		'</div>'+
		          	 	'</div>'
				}
				$('.reply-list').html(str);
				str = '';
				var pm = res.pm;
				//console.log(pm);
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
