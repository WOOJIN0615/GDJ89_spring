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
	<h1>장바구니 페이지</h1>
	<form action="./carts" id="list_form" class="row row-cols-lg-auto g-3 align-items-center">
	<input type="hidden" name="page" id="pageNum">
	</form>
		<table class="table">
			  <thead>
			    <tr>
			    <th>
					  <div class="form-check">
						  <input class="form-check-input checks" id="cbox" type="checkbox">
						  <label class="form-check-label" for="cbox">
							전체 선택
						  </label>
						</div>
						</th>
			      <th>#</th>
			      <th>상품명</th>
			      <th>이자율</th>
			      <th>기간</th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach items="${carts}" var="v">
			    <tr>
			    <td>
			    <div class="form-check">
						  <input class="form-check-input checks" data-product-num="${v.productNum}" type="checkbox">
						  <label class="form-check-label" for="defaultCheck1">
						  </label>
						</div>
			    </td>
			      <td>${v.productNum}</td>
			      <td><a style="color:black; text-decoration: none" href="../products/detail.do?productNum=${v.productNum}">${v.productName}</a></td>
			      <td>${v.productRate}%</td>
			      <td>${v.productDate}</td>
			    </tr>
			  </c:forEach>
			  </tbody>
			</table>
			<div >
			<nav aria-label="Page navigation example" style="width: 300px; margin: 0px auto;">
  			<ul class="pagination">
  			  <li class="page-item">
   			   <button class="page-link pages" data-page-num="${pager.start-1}" aria-label="Previous">
   		     <span aria-hidden="true">&laquo;</span>
			   </button>
		    </li>
		    <c:forEach begin="${pager.start}" end="${pager.end}" var="i">
		    	<li class="page-item">
		    		<button data-page-num="${i}" class="page-link pages">${i}</button>
		    	</li>
		    </c:forEach>
		    <li class="page-item ${pager.endCheck?'disabled':''}">
		      <button class="page-link pages" data-page-num="${pager.end+1}" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
			  </button>
		    </li>
		  </ul>
			</nav>
			</div>
			<div class="mb-3" style="justify-content: between">
					<input type="hidden" name="productNum" value="${dto.productNum}">
					<button type="button" id="cart_join" class="btn btn-primary">상품가입</button>
					<button type="button" id="cart_del" class="btn btn-danger">삭제</button>
			</div>
	</div>
</div>

<c:import url="/WEB-INF/views/template/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/template/boot_jsp.jsp"></c:import>
<script src="/resources/js/list.js"></script>
</body>
</html>