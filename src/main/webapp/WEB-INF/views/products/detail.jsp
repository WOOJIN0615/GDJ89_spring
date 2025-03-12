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
		<input type="hidden" name="productNum" id="productNum" value="${dto.productNum}">
		<label for="exampleFormControlInput1" class="form-label">상세정보</label>
		<h3>${dto.productDetail}</h3><hr>
		<label for="exampleFormControlInput1" class="form-label">기간</label>
		<input class="form-control" type="text" name="productDate" value="${dto.productDate}" aria-label="Disabled input example" disabled readonly><hr>
		<label for="exampleFormControlInput1" class="form-label">이자율</label>
		<input class="form-control" type="text" name="productRate" value="${dto.productRate}" aria-label="Disabled input example" disabled readonly><hr>
		<div class="mb-3" style="justify-content: between">
			<form id="frm" action="/test">
				<input type="hidden" name="productNum" value="${dto.productNum}">
				<button type="button" id="up" class="btn btn-primary">수정</button>
				<button type="button" id="del" class="btn btn-danger">삭제</button>
				<button type="button" id="addCart" data-product-num="${dto.productNum}" class="btn btn-success">장바구니로 이동</button>
			</form>
		</div>

		<div class="mb-3">
			<div class="input-group">
				<span class="input-group-text">댓글</span>
				<textarea class="form-control" id="commentsContents" aria-label="With textarea"></textarea>
				<button type="button" id="addComments" data-product-num="${dto.productNum}" class="btn btn-success">댓글 등록</button>
			  </div>
		</div>

		<div class="mb-3" id="commentsListResult">


		</div>
		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
				<h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<div class="mb-3">
						<label for="message-text" class="col-form-label">Message:</label>
						<textarea data-boardNum="" class="form-control" id="message-text"></textarea>
					  </div>
				</div>
				<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-bs-dismiss="modal" aria-label="Close" id="modal_close">Close</button>
				<button type="button" class="btn btn-primary" data-bs-dismiss="modal" aria-label="Close" id="modal_change">Save changes</button>
				</div>
			</div>
			</div>
		</div>
	</div>
</div>
<c:import url="/WEB-INF/views/template/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/template/boot_jsp.jsp"></c:import>
<script src="/resources/js/products/detail.js"></script>
</body>
</html>