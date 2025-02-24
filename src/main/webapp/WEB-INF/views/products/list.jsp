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
	<h1>상품 정보 페이지</h1>
	<form action="./list" class="row row-cols-lg-auto g-3 align-items-center">
  <div class="col-12">
    <label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
    <select name="kind" class="form-select" id="inlineFormSelectPref">
      <option value="k1">제목</option>
      <option value="k2">내용</option>
      <option value="k3">제목+내용</option>
    </select>
  </div>
<div class="col-12">
      <input type="text" name="search" class="form-control" id="inlineFormInputGroupUsername">
  </div>

  <div class="col-12">
    <button type="submit" class="btn btn-primary">검색</button>
  </div>
</form>
		<table class="table">
			  <thead>
			    <tr>
			      <th>#</th>
			      <th>상품명</th>
			      <th>이자율</th>
			      <th>기간</th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach items="${list}" var="v">
			    <tr>
			      <td>${v.productNum}</td>
			      <td><a style="color:black; text-decoration: none" href="./detail.do?productNum=${v.productNum}">${v.productName}</a></td>
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
   			   <a class="page-link" href="./list?page=${pager.start-1}" aria-label="Previous">
   		     <span aria-hidden="true">&laquo;</span>
   			   </a>
		    </li>
		    <c:forEach begin="${pager.start}" end="${pager.end}" var="i">
		    	<li class="page-item"><a class="page-link" href="./list?page=${i}">${i}</a></li>
		    </c:forEach>
		    <li class="page-item ${pager.endCheck?'disabled':''}">
		      <a class="page-link" href="./list?page=${pager.end+1}" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
		  </ul>
			</nav>
			</div>
			<a class="btn btn-success" href="./add">상품 등록</a>
	</div>
</div>

<c:import url="/WEB-INF/views/template/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/template/boot_jsp.jsp"></c:import>
</body>
</html>