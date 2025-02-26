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
		<h1>상품 등록 페이지</h1>
		<form id="add_form" action="./add" method="post">
		<div class="mb-3">
		  <label for="exampleFormControlInput1" class="form-label">상품명</label>
		  <input type="text" name="productName" class="form-control" id="exampleFormControlInput1 productname" placeholder="상품의 이름을 기입하세요.">
		</div>
		<div class="mb-3">
		  <label for="exampleFormControlTextarea1" class="form-label">상세 내용</label>
		  <textarea class="form-control" name="productDetail" id="exampleFormControlTextarea1" rows="3"></textarea>
		</div>
		<div class="mb-3">
			<p>
		      <label for="date">기간</label><br>
		      <input type="date" name="productDate" id="date productdate" style="width: 428px; ">
		    </p>
		</div>
		
		<label for="volume">이자율</label>
		<input type="range" name="productRate" id="volume productrate" min="0" max="3" step="0.1">
		<p style="color: red;">값: <output for="volume" id="volume-output"></output></p>
		
		<div class="mb-3" style="justify-content: between">
		<button type="submit" id="add_button" class="btn btn-primary">
		  등록
		</button>
		
		
		</form>
	</div>
</div>

<c:import url="/WEB-INF/views/template/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/template/boot_jsp.jsp"></c:import>
<script src="/resources/js/add.js"></script>
</body>
</html>