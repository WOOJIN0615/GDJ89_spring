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
		<div class="mb-3">
		  <label for="exampleFormControlInput1" class="form-label">상품명</label>
		  <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="상품의 이름을 기입하세요.">
		</div>
		<div class="mb-3">
		  <label for="exampleFormControlTextarea1" class="form-label">상세 내용</label>
		  <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
		</div>
		<div class="mb-3">
			<p>
		      <label for="date">기간</label><br>
		      <input type="date" id="date" style="width: 428px; ">
		    </p>
		</div>
		
		<label for="volume">이자율</label>
		<input type="range" id="volume" min="0" max="3" step="0.1">
		<p style="color: red;">값: <output for="volume" id="volume-output"></output></p>
		<script>
		    const value = document.querySelector("#volume-output");
		    const input = document.querySelector("#volume");
		    value.textContent = input.value;
		    input.addEventListener("input", (event) => {
		      value.textContent = event.target.value;
		    });
		</script>
		<div class="mb-3" style="justify-content: between">
		<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
		  등록
		</button>
		
		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-body">
		        상품 등록에 성공하였습니다!
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal"><a href="./list">닫기</a></button>
		      </div>
		    </div>
		  </div>
		</div>
		<a class="btn btn-danger" href="./list">등록 취소</a>		
		</div>
	</div>
</div>

<c:import url="/WEB-INF/views/template/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/template/boot_jsp.jsp"></c:import>
</body>
</html>