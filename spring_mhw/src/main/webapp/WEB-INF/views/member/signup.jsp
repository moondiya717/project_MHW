<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>    
<html>
<head>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/additional-methods.min.js"></script>
<style>
	.error{ color:red;}
</style>
	<title>회원가입</title>
</head>
<body>

<form class="container" method="post" action="<%=request.getContextPath()%>/signup" id="signup">
	<h1>회원가입</h1>
	<div class="form-group">
	  <label>아이디:</label>
	  <input type="text" class="form-control" name="id">
	</div>
	  <button type="button" class="col-12 btn btn-outline-success" id="dupCheck">아이디중복확인</button>
	<div class="form-group">
	  <label>비밀번호:</label>
	  <input type="password" class="form-control" name="pw" id="pw">
	</div>
	<div class="form-group">
	  <label>비밀번호 확인:</label>
	  <input type="password" class="form-control" name="pw2">
	</div>
	<div class="form-group">
	  <label>성별:</label>
	  <select class="form-control" name="gender">
		  <option value="M">남성</option>
		  <option value="F">여성</option>
	  </select>
	</div>
	<div class="form-group">
	  <label>이메일:</label>
	  <input type="email" class="form-control" name="email">
	</div>
	<div class="form-group">
	  <label>이름:</label>
	  <input type="text" class="form-control" name="name">
	</div>
	<button class="btn btn-outline-success col-12">회원 가입</button>
</form>
<script type="text/javascript">
	$(function(){
		$('#dupCheck').click(function(){
			var id = $('[name=id]').val();
			$.ajax({
				type: 'get', //post방식으로 서버에 데이터를 전송 //get방식엔 ?정보들이 들어가는데, ajax는 원하는 정보를 url에 넣어줄 수 있음
				url : '<%=request.getContextPath()%>/member/idcheck/' + id, 
				success : function(result, status, xhr){ //result에는 서버에서 보내준 데이터가 들어가있음
					if(result == 'POSSIBLE'){
						alert('사용 가능한 아이디입니다.')
					}else{
						alert('사용 불가능한 아이디입니다.')
					}
				},
				error : function(xhr, status, e){
					
				}				
			})
		})
		
	    $("#signup").validate({
	        rules: {
	            id: { //name값이 id
	                required : true, //필수항목
	                //minlength : 4 //정규표현식에서 길이제한이있어서 필요없음
	                regex: /^[0-9a-z_-]{5,20}$/
	            },
	            pw: {
	                required : true,
	                regex: /^[0-9a-zA-Z@#$]{8,16}$/
	            },
	            pw2: {
	                required : true,
	                equalTo : pw //id값이어야함
	            },
	            name: {
	                required : true,
	                minlength : 2
	            },
	            email: {
	                required : true,	           
	                email : true //이메일형식에맞는지
	            },
	            gender: {
	                required : true
	            }
	        },
	        //규칙체크 실패시 출력될 메시지
	        messages : {
	            id: {
	                required : "필수정보입니다.",
	                regex : "5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 가능합니다."
	            },
	            pw: {
	                required : "필수정보입니다.",
	                regex : "8~16자 영문 대/소문자, 숫자, 특수문자(@#$)를 사용하세요"
	            },
	            pw2: {
	                required : "필수정보입니다.",
	                equalTo : "비밀번호가 일치하지 않습니다."
	            },
	            name: {
	                required : "필수정보입니다.",
	                minlength : "최소 2글자이상이어야 합니다"
	            },
	            email: {
	                required : "필수정보입니다.",
	                email : "메일규칙에 어긋납니다"
	            },
	            gender: {
	                required : "필수정보입니다."
	            }
	        }
	    });
	})
	$.validator.addMethod(
	    "regex",
	    function(value, element, regexp) {
	        var re = new RegExp(regexp);
	        return this.optional(element) || re.test(value);
	    },
	    "Please check your input."
	);
</script>
</body>
</html>
