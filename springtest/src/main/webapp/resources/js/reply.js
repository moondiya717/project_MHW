/** 
var a ={}; //객체
 *  var b = []; //배열

개발자도구 콘솔에서 검색할때
replyService
{name: "서비스"}
replyService.name
"서비스"
replyService['name']
"서비스"
-> 3개가 다 같음
 */
var replyService= (function(){ //즉시실행함수, 만들자마자 바로 실행
	function insert(contextPath,data){
		$.ajax({
			type:'post',
			url : contextPath+'/reply/ins',
			data : JSON.stringify(data),
			contentType : "application/json; charset=utf-8",
			success : function(result){
				if(result == "SUCCESS"){
					list(contextPath, data['rp_bd_num'], 1, data['rp_me_id']);
					$('.reply-input').val('');
					alert('댓글이 등록되었습니다.');
				}
			}
		})
	}
	function list(contextPath, rp_bd_num, page, id){
		$.ajax({
			type: 'get',
			url : contextPath + '/reply/list/' + rp_bd_num + '/' + page,
			dataType: 'json',
			success : function(result){
				//console.log(result['pm']);
				var str = '<hr style="background:red;"/>';
				console.log(result['replyList']); //controller의 put()메소드 안의 ""와 이름을 맞추기
				for(reply of result['replyList']){ //여기보면 replyList값이 필요한데 이걸 reply라는 객체에다가 값을 저장해서 반복문으로 꺼내왔으니 밑에 값 출력해서 테스트할때  reply['~~']라고 쓰는거임
					console.log(reply);
					str+= 
						'<div>'+
							'<label>'+reply['rp_me_id']+'</label>'+
							'<div class="form-control">'+reply['rp_content']+'</div>'+
						'</div>';
					if(reply['rp_me_id'] == id){
						str += 
							'<div>'+
								'<button type="button" class="btn btn-outline-primary mod-btn"  data="'+ reply['rp_num'] +'">수정</button>'+
								'<button type="button" class="btn btn-outline-danger del-btn"  data="'+ reply['rp_num'] +'">삭제</button>'+
							'</div>';
					}
				}
				str += '<hr style="background:red;"/>';
				//console.log(str);
				$('.reply-list').html(str);
				
				var pmStr='';
				var pm = result['pm'];
				if (pm.prev){ //pageMaker클래스보면 prev= startPage ==1? false:true;  => 1일떈 false안보이고 2이상부터는 이전페이지가 보임
					pmStr += '<li class="page-item" data="'+(pm.startPage-1)+'"><a class="page-link" href="#">이전</a></li>';
				}
				for(i = pm.startPage; i<=pm.endPage; i++){
				    if(pm.criteria.page == i){ //현재페이지와 i가 같다면, active클래스이름을 추가해서 버튼이눌린 효과를 표시함
						pmStr += '<li class="page-item active" data="'+ i +'"><a class="page-link" href="#">'+i+'</a></li>';
					}
					else{ //현재페이지와 i가 같지않은 눌리지않은 페이지들의 버튼들은 색이칠해지지않은 버튼 처럼 보이게함
				    	pmStr += '<li class="page-item" data="'+i+'"><a class="page-link" href="#">'+i+'</a></li>';
					}					
				}
			    if(pm.next){ //next= endPage * criteria.getPerPageNum() >= totalCount? false:true; 
							 //마지막페이지번호X한페이지당게시글수가 총게시글보다 크면 다음이라는 버튼이 안보여야 함
					pmStr += '<li class="page-item" data="'+(pm.endPage+1)+'"><a class="page-link" href="#">다음</a></li>';
				}
				$('.pagination').html(pmStr);
			}	
		})
	}
	function modify(contextPath, data, page){
		$.ajax({
			type : 'post',
			url : contextPath + '/reply/mod',
			data : JSON.stringify(data),
			contentType : "application/json; charset=utf-8",
			success : function(res){
				//console.log('성공');
				if(res == 'SUCCESS'){
					alert('댓글이 수정되었습니다.');
				//page를 넣어줘야 다른댓글페이지에서 댓글수정후 완료됐을때 페이지가 유지됨
					list(contextPath, data['rp_bd_num'], page, data['rp_me_id']);
				}else{
					//로그인안했을때, 수정버튼이 안보이겠지만 혹시모르니까 처리해줌
					alert('댓글을 수정할 수 없습니다.')
				}
			}
		});
	}
	function deleteReply(contextPath, data, page){
		$.ajax({
			type : 'post',
			url : contextPath + '/reply/del',
			data : JSON.stringify(data),
			contentType : "application/json; charset=utf-8",
			success : function(res){
				//console.log(res); //여기까지확인하고 컨트롤러로 이동404 에러를 해결하기5
				if(res == 'SUCCESS'){
					alert('댓글이 삭제되었습니다.');
					replyService.list(contextPath, data['rp_bd_num'], page, data['rp_me_id']);
				}else{
					alert('댓글을 삭제할 수 없습니다.');
				}
			}
		});
	}
	return { // 멤버변수/메소드명 : 구현부 이기때문에 왼쪽에있는 이름을 사용해서 처리해야 함
		name: "서비스", 
		insert : insert,
		list:list,
		modify : modify, //댓글수정기능 모듈화
		deleteReply : deleteReply 		
	}
})();


