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
		<h1>${dto.boardTitle}</h1>
		<h3>${dto.boardDate}</h3>
		<div class="mb-3">
		  <label for="exampleFormControlTextarea1" class="form-label"></label>
		  <textarea style="height: 350px" class="form-control" name="productDetail" id="exampleFormControlTextarea1" rows="3" placeholder="${dto.boardContents}" disabled readonly></textarea>
		</div>
		<div class="mb-3" style="justify-content: between">
			<form id="frm" action="/test">
				<input type="hidden" name="boardNum" value="${dto.boardNum}">
				<button type="button" id="up" class="btn btn-primary">수정</button>
				<button type="button" id="del" class="btn btn-danger">삭제</button>
			</form>
		</div>
	</div>
</div>

<c:import url="/WEB-INF/views/template/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/template/boot_jsp.jsp"></c:import>
<script src="/resources/js/detail.js"></script>
</body>
</html>