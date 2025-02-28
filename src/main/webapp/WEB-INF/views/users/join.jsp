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
		<h1>회원가입</h1>
		<form action="./join" method="post" enctype="multipart/form-data">
		<div class="mb-3">
		  <label for="formGroupExampleInput" class="form-label">Username</label>
		  <input type="text" class="form-control" name="username" id="formGroupExampleInput" placeholder="사용할 아이디를 입력하세요."><br>
		  <label for="formGroupExampleInput2" class="form-label">Password</label>
		  <input type="password" class="form-control" name="password" id="formGroupExampleInput2"><br>
		  <label for="formGroupExampleInput" class="form-label">Name</label>
		  <input type="text" class="form-control" name="name" id="formGroupExampleInput" placeholder="사용자 이름을 입력하세요."><br>
		  <label for="formGroupExampleInput" class="form-label">Phone</label>
		  <input type="text" class="form-control" name="phone" id="formGroupExampleInput" placeholder="휴대폰 번호를 입력하세요."><br>
		  <label for="formGroupExampleInput" class="form-label">Email</label>
		  <input type="text" class="form-control" name="email" id="formGroupExampleInput" placeholder="이메일을 입력하세요."><br>
		  <label for="profile" class="form-label">Profile</label>
		  <input type="file" class="form-control" name="profile" id="formGroupExampleInput"><br>
		  <button type="submit" class="btn btn-primary">가입</button>
		  <a class="btn btn-danger" href="/">취소</a>
		  </div>
		</form>
	</div>
</div>

<c:import url="/WEB-INF/views/template/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/template/boot_jsp.jsp"></c:import>
</body>
</html>