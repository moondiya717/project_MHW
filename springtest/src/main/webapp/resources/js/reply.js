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
					list(contextPath, data['rp_bd_num']);
					$('.reply-input').val('');
					alert('댓글이 등록되었습니다.');
				}
			}
		})
	}
	//여기다가 모듈화를 더 추가하고싶으면 더 추가해(이름은 임의로적어둠)
	function list(contextPath, rp_bd_num){
		$.ajax({
			type: 'get',
			url : contextPath + '/reply/list/' + rp_bd_num,
			dataType: 'json',
			success : function(result){
				console.log(result);
				var str = '<hr style="background:red;"/>';
				console.log(result['replyList']); //controller의 put()메소드 안의 ""와 이름을 맞추기
				for(reply of result['replyList']){
					console.log(reply);
					str+= 
						'<div>'+
							'<label>'+reply['rp_me_id']+'</label>'+
							'<div class="form-control">'+reply['rp_content']+'</div>'+
						'</div>';
				}
				str += '<hr style="background:red;"/>';
				//console.log(str);
				$('.reply-list').html(str);
			}	
		})
	}
	return {
		name: "서비스", 
		insert : insert,
		list:list		
	}
})();


