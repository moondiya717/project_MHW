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
					$('.reply-input').val('');
					alert('댓글이 등록되었습니다.')
				}
			}
		})
	}
	//여기다가 모듈화를 더 추가하고싶으면 더 추가해(이름은 임의로적어둠)
	function list(){
		
	}
	return {
		name: "서비스", 
		insert : insert		
	}
})();


