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
	<!-- 순서 꼭 지켜야 됨 -->
	<script type="text/javascript" scr="<%=request.getContextPath()%>/resources/js/jquery.validate.min.js"></script>
	<script type="text/javascript" scr="<%=request.getContextPath()%>/resources/js/additional-methods.min.js"></script>
</head>
<body>

<form class="container" method="post" action="<%=request.getContextPath()%>/member/signup" id="signup">
	<h1>회원가입</h1>
	<div class="form-group">
	  <label>아이디:</label>
	  <input type="text" class="form-control" name="id">
	</div>
	  <button type="button" class="id-dup-btn col-12 btn btn-outline-success" id="dupCheck">아이디중복확인</button>
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
    $("form").validate({
        rules: {
            id: {
                required : true,
                regex : /^[0-9a-z_-]{5,20}$/
            },
            pw: {
                required : true,
                regex: /^[a-zA-Z0-9!@#]{8,16}$/
            },
            pw2: {
                required : true,
                minlength : 8,
                equalTo : pw //equalTo는 id값을 말하고 위에 id: password: 들은 name값
            },
            name: {
                required : true,
            },
            gender: {
            	required : true
            },
            email: {
                required : true,
                email : true
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
            },
            gender: {
                required : "필수정보입니다.",
            },
            email: {
                required : "필수정보입니다.",
                email : "메일규칙에 어긋납니다"
            }
        }
    });
    $('.id-dup-btn').click(function(){
    	//alert('OK');
    	var id = $('[name=id]').val();
    	console.log(id);
		var res = memberService.idCheck(contextPath,id);
		console.log(res);
		if(res){
			alert('사용 가능한 아이디입니다.');
		}else{
			alert('이미 가입된 아이디입니다.');
		}
    })
})
$.validator.addMethod(
    "regex",
    function(value, element, regexp) {
        var re = new RegExp(regexp);
        return this.optional(element) || re.test(value);
    },
    "Please check your input."
);
var contextPath = '<%=request.getContextPath()%>';
var memberService = (function(){
	function idCheck(contextPath, id){
    	var flag = false;
		$.ajax({
    		async : false,
			type : 'post',
    		url : contextPath+'/id/check',
    		data : {id : id},
    		success : function(res){
    			console.log(res);
    			if(res=='OK'){
    				flag = true;
    			}else{
    				flag = false;
    			}
    			console.log('flag : ' + flag);
    		}
    	})
    	return flag;
	}
	return {
		name : 'memberService',
		idCheck : idCheck
	}
})();
</script>
</body>
</html>
