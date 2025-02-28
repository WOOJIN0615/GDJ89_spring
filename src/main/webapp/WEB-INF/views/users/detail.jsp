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
			<div>
		    <label for="inputEmail4" class="form-label">Profile</label>
		    <img alt="" src="/resources/images/profiles/${not empty user.userFileDTO.fileName ? user.userFileDTO.fileName:'modern.png'}">
		  </div>
		  <div class="col-md-6">
		    <label for="inputEmail4" class="form-label">Username</label>
		    <input type="text" class="form-control" id="inputEmail4" name="username" value="${user.username}" disabled readonly>
		  </div>
		  <div class="col-md-6">
		    <label for="inputPassword4" class="form-label">Password</label>
		    <input type="password" class="form-control" id="inputPassword4" name="password" value="${user.password}" disabled readonly>
		  </div>
		  <div class="col-md-6">
		    <label for="inputAddress" class="form-label">Name</label>
		    <input type="text" class="form-control" id="inputAddress" name="name" placeholder="1234 Main St" value="${user.name}" disabled readonly>
		  </div>
		  <div class="col-md-6">
		    <label for="inputAddress2" class="form-label">Phone</label>
		    <input type="text" class="form-control" id="inputAddress2" name="phone" value="${user.phone}" disabled readonly>
		  </div>
		  <div class="col-md-6">
		    <label for="inputAddress2" class="form-label">Email</label>
		    <input type="text" class="form-control" id="inputAddress2" name="email" value="${user.email}" disabled readonly>
		  </div>
		  <div class="mb-3" style="justify-content: between">
			<a class="btn btn-primary" href="update?username=${user.username}">정보 수정</a>
		</div>
		 </div>
	</div>
</div>

<c:import url="/WEB-INF/views/template/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/template/boot_jsp.jsp"></c:import>	
</body>
</html>