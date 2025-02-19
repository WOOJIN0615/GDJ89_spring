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
		<h1>${dto.productName}</h1><br><br><br><br>
		<input type="hidden" name="productNum" value="${dto.productNum}">
		<label for="exampleFormControlInput1" class="form-label">상세정보</label>
		<input class="form-control" type="text" name="productDetail" value="${dto.productDetail}" aria-label="Disabled input example" disabled readonly><hr>
		<label for="exampleFormControlInput1" class="form-label">기간</label>
		<input class="form-control" type="text" name="productDate" value="${dto.productDate}" aria-label="Disabled input example" disabled readonly><hr>
		<label for="exampleFormControlInput1" class="form-label">이자율</label>
		<input class="form-control" type="text" name="productRate" value="${dto.productRate}" aria-label="Disabled input example" disabled readonly><hr>
		<div class="mb-3" style="justify-content: between">
			<a class="btn btn-primary" href="./update?productNum=${dto.productNum}">수정</a>
			<a class="btn btn-danger" href="./delete?productNum=${dto.productNum}">삭제</a>	
		</div>
	</div>
</div>

<c:import url="/WEB-INF/views/template/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/template/boot_jsp.jsp"></c:import>
</body>
</html>