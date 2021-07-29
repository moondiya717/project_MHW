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
			        	<select class="form-control">
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
		</div>
	</body>
</html>