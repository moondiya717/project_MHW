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
	//여기다가 모듈화를 더 추가하고싶으면 더 추가해(이름은 임의로적어둠)
	function list(contextPath, rp_bd_num, page, id){
		$.ajax({
			type: 'get',
			url : contextPath + '/reply/list/' + rp_bd_num + '/' + page,
			dataType: 'json',
			success : function(result){
				//console.log(result['pm']);
				var str = '<hr style="background:red;"/>';
				console.log(result['replyList']); //controller의 put()메소드 안의 ""와 이름을 맞추기
				for(reply of result['replyList']){
					console.log(reply);
					str+= 
						'<div>'+
							'<label>'+reply['rp_me_id']+'</label>'+
							'<div class="form-control">'+reply['rp_content']+'</div>'+
						'</div>';
					if(reply['rp_me_id'] == id){
						str += 
							'<div>'+
								'<button type="button" class="btn btn-outline-primary mod-btn">수정</button>'+ //나중에 삭제버튼도추가하고 더 수정해야함
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
	return {
		name: "서비스", 
		insert : insert,
		list:list		
	}
})();


