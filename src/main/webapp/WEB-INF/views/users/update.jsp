<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/template/boot_css.jsp"></c:import>
</head>
<body>
<c:import url="/WEB-INF/views/template/layout_header.jsp"></c:import>

<div class="container-fluid my-5">
	<div class="row col-md-8 offset-md-2">
		<!-- contents 내용 작성 -->
		<h1>MyPage</h1>
		<div class="row g-3">
		<form action="./update" method="post">
		 
		    
		    <input type="hidden" class="form-control" id="inputEmail4" name="username" value="${user.username}">
		  
		  <div class="col-md-6">
		    <label for="inputPassword4" class="form-label">Password</label>
		    <input type="password" class="form-control" id="inputPassword4" name="password" value="${user.password}">
		  </div>
		  <div class="col-md-6">
		    <label for="inputAddress" class="form-label">Name</label>
		    <input type="text" class="form-control" id="inputAddress" name="name" value="${user.name}">
		  </div>
		  <div class="col-md-6">
		    <label for="inputAddress2" class="form-label">Phone</label>
		    <input type="text" class="form-control" id="inputAddress2" name="phone" value="${user.phone}">
		  </div>
		  <div class="col-md-6">
		    <label for="inputAddress2" class="form-label">Email</label>
		    <input type="text" class="form-control" id="inputAddress2" name="email" value="${user.email}">
		  </div>
		  <div class="mb-3" style="justify-content: between">
			<button type="submit" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
		  수정
		</button>
		  </div>
		</form>
		 </div>
	</div>
</div>

<c:import url="/WEB-INF/views/template/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/template/boot_jsp.jsp"></c:import>	
</body>
</html>