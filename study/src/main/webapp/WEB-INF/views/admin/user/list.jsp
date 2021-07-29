<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>    
<html>
	<head>
	</head>
	<body>
		<div class="container">
		  <h1>회원 관리</h1>
		  <table class="table table-hover">
		    <thead>
		      <tr>
		        <th>아이디</th>
		        <th>등급</th>
		        <th>설정</th>
		      </tr>
		    </thead>
		    <tbody>
		    	<c:forEach items="${list}" var="member">
			      <tr>
			        <td>${member.id}</td>
			        <td>${member.authorityStr}</td> <!-- VO에서 출력이름바꾸고 여기다가 이름바꿔주면 DB이름이랑 다르게 설정가능 -->
			        <td>
			        	<select class="form-control grade">
			        	<!-- 최고관리자는 무조건1명이어야하고, super admin은 여기서 할 수없음 -->
			        		<option value="USER" <c:if test="${member.authority == 'USER'}">selected</c:if>>회원</option>
			        		<c:if test="${user.authority=='SUPER ADMIN'}">
			        			<option value="ADMIN" <c:if test="${member.authority == 'ADMIN'}">selected</c:if>>관리자</option>
			        		</c:if>
			        	</select>
			        </td>
			      </tr>
		      	</c:forEach>
		    </tbody>
		  </table>
		  <ul class="pagination justify-content-center">
		  	<c:if test="${pm.prev}">
		    	<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/admin/user/list?page=${pm.startPage-1}">이전</a></li>
		    </c:if>
		    
		    <c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="index">
		    	<li class="page-item <c:if test="${pm.criteria.page==index}">active</c:if>"><a class="page-link" href="<%=request.getContextPath()%>/admin/user/list?page=${index}"></a></li>
		    </c:forEach>
		    <c:if test="${pm.next}">
		    	<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/admin/user/list?page=${pm.endPage+1}">다음</a></li>
		    </c:if>
		  </ul>
		</div>
		<script>
		var contextPath = '<%=request.getContextPath()%>';
			$(function(){
				$('.grade').change(function(){
					var authority = $(this).val();
					//console.log(authority);
					var id= $(this).parent().siblings().first().text();
					//console.log(id);
					var data = {
							id:id,
							authority : authority
					}
					//console.log(data);
					var obj = $(this).parent().siblings().eq(1);
					$.ajax({
						type: 'post',
						url : contextPath + '/admin/user/mod',
						data : JSON.stringify(data),
						contentType : "application/json; charset=UTF-8",
						success : function(res){
							//console.log(res);
							if(res == 'OK'){
								var str = authority=='USER'? '회원' : '관리자';
								obj.text(str);
								alert(id+ "님의 등급이"+str+"로 변경되었습니다.");
							}else{
								alert(id+"님의 등급 변경을 실패했습니다");
							}
						}
					})
				})
			})
		</script>
	</body>
</html>