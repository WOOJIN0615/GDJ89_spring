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
			<a class="btn btn-success" href="./add">상품 등록</a>
	</div>
</div>

<c:import url="/WEB-INF/views/template/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/template/boot_jsp.jsp"></c:import>
</body>
</html>