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
		<h1>글 수정 페이지</h1>
		<form action="./update" method="post">
		<div class="mb-3">
		  <input type="hidden" name="productNum" value="${dto.noticeNum}">
		  <label for="exampleFormControlInput1" class="form-label">제목</label>
		  <input type="text" name="productName" class="form-control" id="exampleFormControlInput1" value="${dto.boardTitle}">
		</div>
		<div class="mb-3">
		  <label for="exampleFormControlTextarea1" class="form-label">내용</label>
		  <textarea class="form-control" name="productDetail" id="exampleFormControlTextarea1" rows="3" value="${dto.boardContents}"></textarea>
		</div>
		<div class="mb-3" style="justify-content: between">
		<button type="submit" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
		  수정
		</button>
		
		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-body">
		        상품 수정에 성공하였습니다!
		      </div>
		      <div class="modal-footer">
		        <a class="btn btn-secondary" href="./list">닫기</a>
		      </div>
		    </div>
		  </div>
		</div>
		<a class="btn btn-danger" href="./list">수정 취소</a>		
		</div>
		</form>
	</div>
	
</div>

<c:import url="/WEB-INF/views/template/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/template/boot_jsp.jsp"></c:import>
</body>
</html>