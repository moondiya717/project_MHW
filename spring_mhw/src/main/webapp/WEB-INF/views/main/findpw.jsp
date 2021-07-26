<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
</head>
<body>
	<div class="container">
		<div class="form-group">
			<input type="text" class="form-control" placeholder="아이디" name="id">
		</div>
		<button type="button" id="findPwBtn" class="btn btn-outline-success">비밀번호찾기</button>
	</div>
	<script type="text/javascript">
	$(function(){
		$('#findPwBtn').click(function(){
			var id = $('[name=id]').val();
			//console.log(id);
			$.ajax({
				type : 'get',
				url : '<%=request.getContextPath()%>/find/pw/'+id,
				success : function(res){
					console.log(res);
				}
			})
		})
	})
	</script>
</body>
</html>
