<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
	  <meta charset="utf-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1">
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	  <style>
	  .fakeimg {
	    height: 200px;
	    background: #aaa;
	  }
	  </style>
</head>
<body>
<div class="jumbotron text-center" style="margin-bottom:0">
  <h1>Monster Inc.</h1>
  <p>Nothing is more important than our friendship!</p> 
</div>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <a class="navbar-brand" href="#">메뉴</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath()%>/board/list">게시판</a>
      </li>
    <!-- Dropdown -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
        로그인
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="#">로그인</a>
        <a class="dropdown-item" href="#">회원가입</a>
      </div>
    </li>  
    </ul>
  </div>  
</nav>

<div class="container" style="margin-top:30px">
  <div class="row">
    <div class="col-sm-4">
      <h2>About Us</h2>
      <h5>Photo of Us:</h5>
      <div class="fakeimg"><img src="<%=request.getContextPath()%>/resources/img/characters.jpg" width="100%" height="100%"></div>
      <p>이미지에 왜  ..</p>
    </div>
    <div class="col-sm-8">
      <h2>Work Work Work</h2>
      <h5>Title description, July 8, 2021</h5>
      <div class="fakeimg"><img src="<%=request.getContextPath()%>/resources/img/work.jpg" width="100%" >
	      <p>출근해라</p>
	      <p>우리 일열심히하면 니네 잠 못잠ㅎㅋ.</p></div>
      <br>
    </div>
  </div>
</div>

<div class="jumbotron text-center" style="margin-bottom:0">
  <p>Footer</p>
</div>

</body>
</html>
