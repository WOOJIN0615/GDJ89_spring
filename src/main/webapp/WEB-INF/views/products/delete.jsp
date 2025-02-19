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
		<h1>상품을 삭제하시겠습니까?</h1><br><br><br>
		<h3>삭제하신 상품은 복구하실 수 없습니다.</h3><br><br><br>
		<form action="./delete" method="post">
			<input type="hidden" name="productNum" value="${dto.productNum}">
			
			<input type="hidden" name="productName" value="${dto.productName}">
			
			<input type="hidden" name="productDetail" value="${dto.productDetail}">
			
			<input type="hidden" name="productDate" value="${dto.productDate}">
			
			<input type="hidden" name="productRate" value="${dto.productRate}">
			<div class="mb-3" style="justify-content: between">
				<button type="submit" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
				  삭제
				</button>
				<!-- Modal -->
				<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
				  <div class="modal-dialog">
				    <div class="modal-content">
				      <div class="modal-body">
				        상품 삭제에 성공하였습니다!
				      </div>
				      <div class="modal-footer">
				        <a class="btn btn-secondary" href="./list">닫기</a>
				      </div>
				    </div>
				  </div>
				</div>
				<a class="btn btn-primary" href="./list">취소</a>	
			
			</div>
		</form>
	</div>
</div>

<c:import url="/WEB-INF/views/template/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/template/boot_jsp.jsp"></c:import>
</body>
</html>